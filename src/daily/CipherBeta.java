package daily;

import java.util.HashMap;

public class CipherBeta {

    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private static HashMap<Character, Integer> lookup = new HashMap<Character, Integer>() {{
        for (int i = 0; i < alphabet.length(); i++)
            put(alphabet.charAt(i), i);
    }};

    public static String encrypt(String msg, String phrase) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < msg.length(); i++, j = (j + 1) % phrase.length()) {
            int index = (lookup.get( msg.charAt(i)) + lookup.get(phrase.charAt(j)) ) % alphabet.length();
            sb.append(alphabet.charAt(index));
        }
        return sb.toString();
    }

    public static String decrypt(String msg, String phrase) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < msg.length(); i++, j = (j + 1) % phrase.length()) {
            int index = (lookup.get( msg.charAt(i)) - lookup.get(phrase.charAt(j)) + alphabet.length() ) % alphabet.length();
            sb.append(alphabet.charAt(index));
        }
        return sb.toString();
    }

}
