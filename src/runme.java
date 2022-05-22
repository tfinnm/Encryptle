import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class runme {
	//⬜ = not in word
	//🟨 = in word, wrong place
	//🟩 = right place
	public static void main(String[] args) {
		//		System.out.println(encrypt("test1"));
		//    		System.out.println(decrypt(encrypt("test1")));
				System.out.println(decrypt("Encryptle 489 46/54 \n🟨⬜⬜⬜⬜\n⬜⬜⬜⬜⬜\n⬜⬜⬜⬜🟨\n⬜⬜⬜⬜⬜\n⬜⬜⬜⬜⬜\n⬜⬜⬜🟨🟨\n⬜⬜⬜⬜⬜\n⬜🟩🟨⬜⬜\n⬜⬜⬜⬜⬜\n⬜⬜⬜⬜⬜\n⬜⬜⬜⬜⬜\n⬜⬜⬜⬜⬜\n⬜⬜⬜⬜⬜\n⬜⬜⬜⬜⬜\n"));
	}

	private static String key = "1234567890abcdefghijklmnopqrstuvwxyzee-=!@#$%^&*()_+`~[]{}\\|;:'\"<>,./?";
	//private static String key = "11111222223333344444555556666677777888889999900000aaaaabbbbbcccccdddddeeeeefffffggggghhhhhiiiiijjjjjkkkkklllllmmmmmnnnnnooooopppppqqqqqrrrrrssssstttttuuuuuvvvvvwwwwwxxxxxyyyyyzzzzz-----=====!!!!!@@@@@#####$$$$$%%%%%^^^^^&&&&&*****((((()))))_____+++++`````~~~~~[[[[[]]]]]{{{{{}}}}}\\\\\\\\\\|||||;;;;;:::::'''''\"\"\"\"\"<<<<<>>>>>,,,,,...../////?????";

	private static ArrayList<String> getKeyChunks() {
		ArrayList<String> chunks = new ArrayList<>();
		for (int i = 0; i+5 <= key.length(); i+=5) {
			chunks.add(key.substring(i, i+5));
		}
		return chunks;
	}

	public static String encrypt(String input) {
		ArrayList<String> chunks = getKeyChunks();
		String out = "";
		for (String s: chunks) {
			for (int i = 0; i < s.length(); i++) {
				if (input.charAt(i) == s.charAt(i)) {
					out += "🟩";
				} else if (input.indexOf(s.charAt(i)) != -1) {
					out += "🟨";
				} else {
					out += "⬜";
				}
				if (i%5==4) {
					out += "\n";
				}
			}
		}
		ArrayList<String> poss = decrypter(out);
		int j = -1;
		for (int i = 0; i < poss.size(); i++) {
			String s = poss.get(i);
			if (s.equals(input)) {
				j = i;
			}
		}
		return "Encryptle "+((int)(Math.random()*900+100))+" "+j+"/"+poss.size()+" \n"+out;
	}

	public static String decrypt(String input) {
		String[] parts = input.split(" ");
		String passInput = parts[3];
		String selector = parts[2].split("/")[0];
		return decrypter(passInput).get(Integer.parseInt(selector));
	}

	private static ArrayList<String> generateAP() {
		String allPossible = "1234567890abcdefghijklmnopqrstuvwxyz-=!@#$%^&*()_+`~[]{}\\|;:'\"<>,./?";
		String[] sarr = allPossible.split("");
		ArrayList<String> returnThis = new ArrayList<String>();
		for (String s: sarr) {
			returnThis.add(s);
		}
		return returnThis;
	}

	private static ArrayList<String> decrypter(String input) {
		input = input.replace("\n", "");
		ArrayList<String> char1 = generateAP();
		ArrayList<String> char2 = generateAP();
		ArrayList<String> char3 = generateAP();
		ArrayList<String> char4 = generateAP();
		ArrayList<String> char5 = generateAP();

		List<String> in = new ArrayList<String>();
		int offset = 0, strLen = input.length();
		while (offset < strLen) {
			int curChar = input.codePointAt(offset);
			offset += Character.charCount(curChar);
			String ret = "";
			for (char c: Character.toChars(curChar)) {
				ret += c;
			}
			in.add(ret);
		}
		String[] karr = key.split("");
		for (int i = 0; i < key.length(); i++) {
			int pos = i%5;
			if (in.get(i).equals("⬜")) { //not in word
				char1.remove(karr[i]);
				char2.remove(karr[i]);
				char3.remove(karr[i]);
				char4.remove(karr[i]);
				char5.remove(karr[i]);
			} else if (in.get(i).equals("🟨")) { //wrong place
				if (pos == 0) {
					char1.remove(karr[i]);
				} else if (pos == 1) {
					char2.remove(karr[i]);
				} else if (pos == 2) {
					char3.remove(karr[i]);
				} else if (pos == 3) {
					char4.remove(karr[i]);
				} else if (pos == 4) {
					char5.remove(karr[i]);
				} else if (pos == 5) {
					char1.remove(karr[i]);
				}
				
			} else if (in.get(i).equals("🟩")) { //right place
				if (pos == 0) {
					for (int l = 0; l < char1.size(); l++) {
						String c = char1.get(l);
						if (!c.equals(karr[i])) {
							char1.remove(c);
							l--;
						}
					}
				} else if (pos == 1) {
					for (int l = 0; l < char2.size(); l++) {
						String c = char2.get(l);
						if (!c.equals(karr[i])) {
							char2.remove(c);
							l--;
						}
					}
				} else if (pos == 2) {
					for (int l = 0; l < char3.size(); l++) {
						String c = char3.get(l);
						if (!c.equals(karr[i])) {
							char3.remove(c);
							l--;
						}
					}
				} else if (pos == 3) {
					for (int l = 0; l < char4.size(); l++) {
						String c = char4.get(l);
						if (!c.equals(karr[i])) {
							char4.remove(c);
							l--;
						}
					}
				} else if (pos == 4) {
					for (int l = 0; l < char5.size(); l++) {
						String c = char5.get(l);
						if (!c.equals(karr[i])) {
							char5.remove(c);
							l--;
						}
					}
				} else if (pos == 5) {
					for (int l = 0; l < char1.size(); l++) {
						String c = char1.get(l);
						if (!c.equals(karr[i])) {
							char1.remove(c);
							l--;
						}
					}
				}
				
			}
		}

		ArrayList<String> possibilities = new ArrayList<String>();
		for (String c1: char1) {
			for (String c2: char2) {
				for (String c3: char3) {
					for (String c4: char4) {
						for (String c5: char5) {
							possibilities.add(c1+c2+c3+c4+c5);
						}
					}
				}
			}
		}
		return possibilities;
	}
	
	private static void cmdLine() {
		 Scanner in = new Scanner(System.in);
		 in.useDelimiter("\n\r\n");
	     String sin = in.next();
	     String op = sin.split(" ")[0];
	     if (op.equals("encrypt")) {
	    	 System.out.print(encrypt(sin.substring(8)));
	     } else if (op.equals("decrypt")) {
	    	 System.out.print(decrypt(sin.substring(8)));
	     }
	     in.close();
	}

}
