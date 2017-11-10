package com.startrek.main;
import com.startrek.model.Character;
import com.startrek.utils.Stapi;
import com.startrek.utils.Translator;

public class Main {

	public static void main(String[] args) {
		try {
			
			if (args.length == 0)
			{
				System.out.println("Please enter a character name.");
				return;
			}
			Character character = new Character(args);
			
			String kligonName = Translator.translate(args);
			character.setKlingonName(kligonName);
			
			String characterSpecie = Stapi.getCharacterSpecie(character.getEnglishName());
			character.setSpecie(characterSpecie);
			
			System.out.println(character.getKlingonName());
			System.out.println(character.getSpecie());
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
