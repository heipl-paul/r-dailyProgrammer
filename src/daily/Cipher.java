package daily;

public class Cipher {
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static String encode (String message, String keyword) {
        StringBuilder encodedMsg = new StringBuilder();
        for (int i = 0, j = 0; i < message.length(); i++, j = (j + 1) % keyword.length()) {
            message.indexOf(keyword.charAt(j));
        }
        return null;
    }

}
