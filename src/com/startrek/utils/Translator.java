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
		     String KlingonName = "0x";
		     switch (letter) {
				case 'a':
				case 'A':
						KlingonName += "F8D0";
					break;
				case 'b':
				case 'B':
						KlingonName += "F8D1";
					break;
				case 'c':
				case 'C':
						if (index + 1 < name.length()) {
							if ((name.charAt(index+1) == 'h') || (name.charAt(index+1) == 'H')) {
								KlingonName += "F8D2";
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
						KlingonName += "F8D3";
					break;
				case 'e':
				case 'E':
						KlingonName += "F8D4";
					break;
				case 'g':
				case 'G':
					if (index + 1 < name.length()) {
						if ((name.charAt(index+1) == 'h') || (name.charAt(index+1) == 'H')) {
							KlingonName += "F8D5";
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
						KlingonName += "F8D6";
					break;
				case 'i':
				case 'I':
						KlingonName += "F8D7";
					break;
				case 'j':
				case 'J':
						KlingonName += "F8D8";
					break;
				case 'l':
				case 'L':
						KlingonName += "F8D9";
					break;
				case 'm':
				case 'M':
						KlingonName += "F8DA";
					break;
				case 'n':
				case 'N':
					if (index + 1 < name.length()) {
						if ((name.charAt(index+1) == 'g') || (name.charAt(index+1) == 'G')) {
							KlingonName += "F8DC";
							index++;
						}
						else
							KlingonName += "F8DB";	
					}
					else
						KlingonName += "F8DB";
					break;
				case 'o':
				case 'O':
						KlingonName += "F8DD";
					break;
				case 'p':
				case 'P':
						KlingonName += "F8DE";
					break;
				case 'q':
						KlingonName += "F8DF";
					break;
				case 'Q':
					KlingonName += "F8E0";
					break;
				case 'r':
				case 'R':
					KlingonName += "F8E1";
					break;
				case 's':
				case 'S':
					KlingonName += "F8E2";
					break;
				case 't':
				case 'T':
					if (index + 1 < name.length()) {
						if ((name.charAt(index+1) == 'l') || (name.charAt(index+1) == 'L')) {
							if (index + 2 < name.length()) {
								if ((name.charAt(index+2) == 'h') || (name.charAt(index+2) == 'H')) {
									KlingonName += "F8E4";
									index += 2;
								}
								else
									throw new Exception("This is not a translatable name");
							}
							else
								throw new Exception("This is not a translatable name");
						}
						else
							KlingonName += "F8E3";
					}
					else
						KlingonName += "F8E3";
					break;
				case 'u':
				case 'U':
					KlingonName += "F8E5";
					break;
				case 'v':
				case 'V':
					KlingonName += "F8E6";
					break;
				case 'w':
				case 'W':
					KlingonName += "F8E7";
					break;
				case 'y':
				case 'Y':
					KlingonName += "F8E8";
					break;
				case '\'':
					KlingonName += "F8E9";
					break;
				default:
					throw new Exception("This is not a translatable name");
			}
		    
		     fullKlingonName += KlingonName + " ";
		     
		}
		
		fullKlingonName = fullKlingonName.trim();
		return fullKlingonName;
	}
}
