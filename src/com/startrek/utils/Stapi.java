package com.startrek.utils;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

public class Stapi {


	public static String getCharacterSpecie(String englishName) throws Exception {
		Client client = ClientBuilder.newClient();
		WebTarget baseTarget = client.target("http://stapi.co/api/v1/rest/character");
		String specie = "";

		Form formData = new Form();
		formData.param("name", englishName);
		
		WebTarget characterTarget = baseTarget.path("search");
		Response characterResponse = characterTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.form(formData));
		if (characterResponse.getStatus() == 200)
		{
			String result = characterResponse.readEntity(String.class);
			JSONObject obj = new JSONObject(result);
			// getting characters with the parameter name
			JSONArray characteres = obj.getJSONArray("characters");
			if (characteres.length() > 0)
			{
				Boolean foundCharacter = false;				
				//getting the uid from the character found
				for (int i = 0; i < characteres.length(); i++) {
					if (characteres.getJSONObject(i).getString("name").toLowerCase().matches(englishName.toLowerCase()))
					{
						String uid = characteres.getJSONObject(i).getString("uid");
						System.out.println(uid);
						WebTarget fullCharacterTarget = baseTarget.queryParam("uid", uid);
						Response fullCharacterResponse = fullCharacterTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
						if (fullCharacterResponse.getStatus() == 200)
						{
							String fullResult = fullCharacterResponse.readEntity(String.class);
							JSONObject fullCharacter = new JSONObject(fullResult);
							JSONArray characterSpecies = fullCharacter.getJSONObject("character").getJSONArray("characterSpecies");
							if (characterSpecies.length() > 0)
								specie = characterSpecies.getJSONObject(0).getString("name");
							else
								throw new Exception("No species found for this character.");
						}
						else
							throw new Exception("No characters found.");
						foundCharacter = true;
						break;

					}
				}
				if (!foundCharacter)
					throw new Exception("No characters found.");
			}
			else
				throw new Exception("No characters found.");
		}
		else
			System.out.println(characterResponse.toString());
		
		client.close();
		
		return specie;
	}
}
