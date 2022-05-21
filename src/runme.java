import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class runme {

	public static void main(String[] args) {
		//⬜ = not in word
		//🟨 = in word, wrong place
		//🟩 = right place
		System.out.println(5-key.length()%5);
		System.out.println(key.length()/5);
		System.out.println(getKeyChunks());
		System.out.println(encrypt("Test1"));
	}
	
	private static String key = "1234567890abcdefghijklmnopqrstuvwxyzee-=!@#$%^&*()_+`~[]{}\\|;:'\"<>,./?";
	
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
			}
		}
		return "Encryptle "+((int)(Math.random()*900+100))+" 07/25\n"+out;
	}
	
	public static String decrypt(String input) {
		String passInput = input.substring(20);
		String selector = input.substring(0);
		return input;
	}
	
	private static ArrayList<String> decrypter(String input) {
		String allPossible = "1234567890abcdefghijklmnopqrstuvwxyz-=!@#$%^&*()_+`~[]{}\\|;:'\"<>,./?";
		List<char[]> char1 = Arrays.asList(allPossible.toCharArray());
		List<char[]> char2 = Arrays.asList(allPossible.toCharArray());
		List<char[]> char3 = Arrays.asList(allPossible.toCharArray());
		List<char[]> char4 = Arrays.asList(allPossible.toCharArray());
		List<char[]> char5 = Arrays.asList(allPossible.toCharArray());
		
		int index = 1;
		ArrayList<String> possibilities = new ArrayList<String>();
		for (char[] c1: char1) {
			for (char[] c2: char2) {
				for (char[] c3: char3) {
					for (char[] c4: char4) {
						for (char[] c5: char5) {
							possibilities.add(""+c1[1]+c2[1]+c3[1]+c4[1]+c5[1]);
						}
					}
				}
			}
		}
		return possibilities.get(index);
	}

}
