package com.startrek.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class StapiService {

	private static Client client = ClientBuilder.newClient();
	private static WebTarget baseTarget = client.target("http://stapi.co/api/v1/rest/character");

	public static String getCharacterSpecie(String englishName) throws Exception {
		String specie = "";

		Form formData = new Form();
		formData.param("name", englishName);

		WebTarget characterTarget = baseTarget.path("search");
		Response characterResponse = characterTarget.request(MediaType.APPLICATION_JSON_TYPE)
				.post(Entity.form(formData));
		if (characterResponse.getStatus() == 200) {
			String result = characterResponse.readEntity(String.class);
			JSONObject obj = new JSONObject(result);
			// getting characters with the parameter name
			JSONArray characteres = obj.getJSONArray("characters");
			if (characteres.length() > 0) {
				String uid = "";
				for (int i = 0; i < characteres.length(); i++) {
					// getting uid from character
					uid = getUidFromCharacter(characteres.getJSONObject(i), englishName);
					if (uid != null)
						break;
				}
				if (uid != null) {
					// getting specie from uid character
					specie = getSpecieFromUid(uid);
					if (specie == null)
						throw new Exception("No species found for this character.");
				} else
					throw new Exception("No characters found.");
			} else
				throw new Exception("No characters found.");
		} else
			System.out.println(characterResponse.toString());

		return specie;
	}

	private static String getUidFromCharacter(JSONObject obj, String englishName) throws JSONException {
		String characterName = obj.getString("name").toLowerCase();
		Pattern pattern = Pattern.compile("\\b(?<!\')" + englishName.toLowerCase() + "\\b(?!\')");
		Matcher matcher = pattern.matcher(characterName);
		if (matcher.find()) {
			return obj.getString("uid");
		} else
			return null;
	}

	private static String getSpecieFromUid(String uid) throws Exception {
		WebTarget fullCharacterTarget = baseTarget.queryParam("uid", uid);
		Response fullCharacterResponse = fullCharacterTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
		if (fullCharacterResponse.getStatus() == 200) {
			String fullResult = fullCharacterResponse.readEntity(String.class);
			JSONObject fullCharacter = new JSONObject(fullResult);
			JSONArray characterSpecies = fullCharacter.getJSONObject("character").getJSONArray("characterSpecies");
			if (characterSpecies.length() > 0)
				return characterSpecies.getJSONObject(0).getString("name");
			else
				throw new Exception("No species found for this character.");
		} else
			throw new Exception("No characters found.");

	}
}
