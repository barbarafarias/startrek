package com.startrek.utils;

public class Translator {
	
	public static String translate(String[] fullEnglishName) throws Exception {
		
		String fullKligonName = "";
		for (String name : fullEnglishName) {
			fullKligonName += " 0x0020 " + translateName(name);			
		}
		fullKligonName = fullKligonName.replaceFirst(" 0x0020 ", "");
		
		return fullKligonName;
		
	}

	private static String translateName(String name) throws Exception {
		String fullKligonName = "";
		for (int index = 0; index < name.length(); index++) {
		     char letter = name.charAt(index);
		     String kligonName = "";
		     switch (letter) {
				case 'a':
				case 'A':
						kligonName += "0XF8D0";
					break;
				case 'b':
				case 'B':
						kligonName += "0XF8D1";
					break;
				case 'c':
				case 'C':
						if (index + 1 < name.length()) {
							if ((name.charAt(index+1) == 'h') || (name.charAt(index+1) == 'H')) {
								kligonName += "0XF8D2";
								index++;
							}
							else
								throw new Exception("This is not a translatable name");
						}
						else
							throw new Exception("This is not a translatable name");
					break;
				case 'd':
				case 'D':
						kligonName += "0XF8D3";
					break;
				case 'e':
				case 'E':
						kligonName += "0XF8D4";
					break;
				case 'g':
				case 'G':
					if (index + 1 < name.length()) {
						if ((name.charAt(index+1) == 'h') || (name.charAt(index+1) == 'H')) {
							kligonName += "0XF8D5";
							index++;
						}
						else
							throw new Exception("This is not a translatable name");
					}
					else
						throw new Exception("This is not a translatable name");
					break;
				case 'h':
				case 'H':
						kligonName += "0XF8D6";
					break;
				case 'i':
				case 'I':
						kligonName += "0XF8D7";
					break;
				case 'j':
				case 'J':
						kligonName += "0XF8D8";
					break;
				case 'l':
				case 'L':
						kligonName += "0XF8D9";
					break;
				case 'm':
				case 'M':
						kligonName += "0XF8DA";
					break;
				case 'n':
				case 'N':
					if (index + 1 < name.length()) {
						if ((name.charAt(index+1) == 'g') || (name.charAt(index+1) == 'G')) {
							kligonName += "0XF8DC";
							index++;
						}
						else
							kligonName += "0XF8DB";	
					}
					else
						kligonName += "0XF8DB";
					break;
				case 'o':
				case 'O':
						kligonName += "0XF8DD";
					break;
				case 'p':
				case 'P':
						kligonName += "0XF8DE";
					break;
				case 'q':
						kligonName += "0XF8DF";
					break;
				case 'Q':
					kligonName += "0XF8E0";
					break;
				case 'r':
				case 'R':
					kligonName += "0XF8E1";
					break;
				case 's':
				case 'S':
					kligonName += "0XF8E2";
					break;
				case 't':
				case 'T':
					if (index + 1 < name.length()) {
						if ((name.charAt(index+1) == 'l') || (name.charAt(index+1) == 'L')) {
							if (index + 2 < name.length()) {
								if ((name.charAt(index+2) == 'h') || (name.charAt(index+2) == 'H')) {
									kligonName += "0XF8E4";
									index += 2;
								}
								else
									throw new Exception("This is not a translatable name");
							}
							else
								throw new Exception("This is not a translatable name");
						}
						else
							kligonName += "0XF8E3";
					}
					else
						kligonName += "0XF8E3";
					break;
				case 'u':
				case 'U':
					kligonName += "0XF8E5";
					break;
				case 'v':
				case 'V':
					kligonName += "0XF8E6";
					break;
				case 'w':
				case 'W':
					kligonName += "0XF8E7";
					break;
				case 'y':
				case 'Y':
					kligonName += "0XF8E8";
					break;
			}
		    
		     fullKligonName += kligonName + " ";
		     
		}
		
		fullKligonName = fullKligonName.trim();
		return fullKligonName;
	}
}
