import java.util.*;

public class Vigenere {

    static String encrypt(String t, String k) {
        t = t.toUpperCase();
        k = t.toUpperCase();
        String r = "";

        for(int i = 0, j = 0; i < t.length(); i++) {
            char c = t.charAt(i);

            if(Character.isLetter(c)) {
                r += (char) ((c + k.charAt(j) - 2 * 'A') % 26 + 'A');
                j = (j + 1) % k.length();
            } else r+=c;
        }

            return r;
        
    }

    static String decrypt(String t, String k) {
        t = t.toUpperCase();
        k = k.toUpperCase();
        String r = "";
        for (int i = 0, j = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (Character.isLetter(c)) {
                r += (char)((c - k.charAt(j) + 26) % 26 + 'A');
                j = (j + 1) % k.length();
            } else r += c;
        }
        return r;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Text: ");
        String t = sc.nextLine();
        System.out.print("Key: ");
        String k = sc.nextLine();

        String e = encrypt(t, k);
        System.out.println("Encrypted: " + e);
        System.out.println("Decrypted: " + decrypt(e, k));
    }
}