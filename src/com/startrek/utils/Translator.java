package com.startrek.utils;

public class Translator {
	
	public static String translate(String[] fullEnglishName) throws Exception {
		
		String fullKlingonName = "";
		for (String name : fullEnglishName) {
			fullKlingonName += " 0x0020 " + translateName(name);			
		}
		fullKlingonName = fullKlingonName.replaceFirst(" 0x0020 ", "");
		
		return fullKlingonName;
		
	}

	private static String translateName(String name) throws Exception {
		String fullKlingonName = "";
		for (int index = 0; index < name.length(); index++) {
		     char letter = name.charAt(index);
		     String KlingonName = "";
		     switch (letter) {
				case 'a':
				case 'A':
						KlingonName += "0XF8D0";
					break;
				case 'b':
				case 'B':
						KlingonName += "0XF8D1";
					break;
				case 'c':
				case 'C':
						if (index + 1 < name.length()) {
							if ((name.charAt(index+1) == 'h') || (name.charAt(index+1) == 'H')) {
								KlingonName += "0XF8D2";
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
						KlingonName += "0XF8D3";
					break;
				case 'e':
				case 'E':
						KlingonName += "0XF8D4";
					break;
				case 'g':
				case 'G':
					if (index + 1 < name.length()) {
						if ((name.charAt(index+1) == 'h') || (name.charAt(index+1) == 'H')) {
							KlingonName += "0XF8D5";
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
						KlingonName += "0XF8D6";
					break;
				case 'i':
				case 'I':
						KlingonName += "0XF8D7";
					break;
				case 'j':
				case 'J':
						KlingonName += "0XF8D8";
					break;
				case 'l':
				case 'L':
						KlingonName += "0XF8D9";
					break;
				case 'm':
				case 'M':
						KlingonName += "0XF8DA";
					break;
				case 'n':
				case 'N':
					if (index + 1 < name.length()) {
						if ((name.charAt(index+1) == 'g') || (name.charAt(index+1) == 'G')) {
							KlingonName += "0XF8DC";
							index++;
						}
						else
							KlingonName += "0XF8DB";	
					}
					else
						KlingonName += "0XF8DB";
					break;
				case 'o':
				case 'O':
						KlingonName += "0XF8DD";
					break;
				case 'p':
				case 'P':
						KlingonName += "0XF8DE";
					break;
				case 'q':
						KlingonName += "0XF8DF";
					break;
				case 'Q':
					KlingonName += "0XF8E0";
					break;
				case 'r':
				case 'R':
					KlingonName += "0XF8E1";
					break;
				case 's':
				case 'S':
					KlingonName += "0XF8E2";
					break;
				case 't':
				case 'T':
					if (index + 1 < name.length()) {
						if ((name.charAt(index+1) == 'l') || (name.charAt(index+1) == 'L')) {
							if (index + 2 < name.length()) {
								if ((name.charAt(index+2) == 'h') || (name.charAt(index+2) == 'H')) {
									KlingonName += "0XF8E4";
									index += 2;
								}
								else
									throw new Exception("This is not a translatable name");
							}
							else
								throw new Exception("This is not a translatable name");
						}
						else
							KlingonName += "0XF8E3";
					}
					else
						KlingonName += "0XF8E3";
					break;
				case 'u':
				case 'U':
					KlingonName += "0XF8E5";
					break;
				case 'v':
				case 'V':
					KlingonName += "0XF8E6";
					break;
				case 'w':
				case 'W':
					KlingonName += "0XF8E7";
					break;
				case 'y':
				case 'Y':
					KlingonName += "0XF8E8";
					break;
			}
		    
		     fullKlingonName += KlingonName + " ";
		     
		}
		
		fullKlingonName = fullKlingonName.trim();
		return fullKlingonName;
	}
}
