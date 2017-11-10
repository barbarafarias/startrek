package com.startrek.model;

public class Character {
	
	private String englishName;
	private String kligonName;
	private String specie;
	
	public Character() {
		
	}
	public Character(String[] fullName) {
		for (String name : fullName) {
			this.englishName += name + " ";
		}
		this.englishName = this.englishName.trim();
	}

	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public String getKligonName() {
		return kligonName;
	}
	public void setKligonName(String kligonName) {
		this.kligonName = kligonName;
	}
	public String getSpecie() {
		return specie;
	}
	public void setSpecie(String specie) {
		this.specie = specie;
	}
	

}
