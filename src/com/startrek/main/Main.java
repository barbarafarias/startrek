package com.startrek.main;

import com.startrek.model.Character;
import com.startrek.service.StapiService;
import com.startrek.util.Translator;

public class Main {

	public static void main(String[] args) {
		try {

			if (args.length == 0) {
				System.out.println("Please enter a character name.");
				return;
			}
			Character character = new Character(args);

			String klingonName = Translator.translate(args);
			character.setKlingonName(klingonName);

			String characterSpecie = StapiService.getCharacterSpecie(character.getEnglishName());
			character.setSpecie(characterSpecie);

			System.out.println(character.getKlingonName());
			System.out.println(character.getSpecie());
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
