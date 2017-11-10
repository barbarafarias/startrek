package com.startrek.main;
import com.startrek.model.Character;

public class Main {

	public static void main(String[] args) {
		try {
			String name = args[0];
			Character character = new Character();
			character.setEnglishName(name);
			
			System.out.println(name);
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
