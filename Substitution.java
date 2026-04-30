import java.util.Scanner;

public class Substitution {

    // Encrypt Method
    static String encrypt(String text, int key) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isUpperCase(ch)) {
                result += (char) ((ch - 'A' + key) % 26 + 'A');
            } else if (Character.isLowerCase(ch)) {
                result += (char) ((ch - 'a' + key) % 26 + 'a');
            } else {
                result += ch;
            }
        }
        return result;
    }

    // Decrypt Method
    static String decrypt(String text, int key) {
        return encrypt(text, 26 - key);
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.print("Enter plain text: ");
        String text = s.nextLine();

        System.out.print("Enter key: ");
        int key = s.nextInt();

        String encrypted = encrypt(text, key);
        String decrypted = decrypt(encrypted, key);

        System.out.println("Encrypted text: " + encrypted);
        System.out.println("Decrypted text: " + decrypted);

        s.close();
    }
}