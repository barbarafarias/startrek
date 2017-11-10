package com.startrek.main;
import com.startrek.model.Character;
import com.startrek.utils.Stapi;
import com.startrek.utils.Translator;

public class Main {

	public static void main(String[] args) {
		try {
			String name = args[0];
			Character character = new Character(name);
			
			String kligonName = Translator.translateEnglishName(name);
			character.setKligonName(kligonName);
			
			String characterSpecie = Stapi.getCharacterSpecie(character.getEnglishName());
			character.setSpecie(characterSpecie);
			
			System.out.println(character.getKligonName());
			System.out.println(character.getSpecie());
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
