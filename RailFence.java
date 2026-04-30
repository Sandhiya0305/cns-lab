import java.util.*;

public class RailFence {

    static String encrypt(String text, int key) {
        if (key <= 1) return text;

        char[][] rail = new char[key][text.length()];
        for (char[] r : rail) Arrays.fill(r, '\n');

        boolean down = false;
        int row = 0;

        for (int i = 0; i < text.length(); i++) {
            if (row == 0 || row == key - 1) down = !down;
            rail[row][i] = text.charAt(i);
            row += down ? 1 : -1;
        }

        String res = "";
        for (int i = 0; i < key; i++)
            for (int j = 0; j < text.length(); j++)
                if (rail[i][j] != '\n')
                    res += rail[i][j];

        return res;
    }

    static String decrypt(String cipher, int key) {
        if (key <= 1) return cipher;

        char[][] rail = new char[key][cipher.length()];
        for (char[] r : rail) Arrays.fill(r, '\n');

        boolean down = false;
        int row = 0;

        // mark zigzag positions
        for (int i = 0; i < cipher.length(); i++) {
            if (row == 0 || row == key - 1) down = !down;
            rail[row][i] = '*';
            row += down ? 1 : -1;
        }

        // fill characters row-wise
        int k = 0;
        for (int i = 0; i < key; i++)
            for (int j = 0; j < cipher.length(); j++)
                if (rail[i][j] == '*' && k < cipher.length())
                    rail[i][j] = cipher.charAt(k++);

        // read zigzag again
        String res = "";
        row = 0;
        down = false;

        for (int i = 0; i < cipher.length(); i++) {
            if (row == 0 || row == key - 1) down = !down;
            res += rail[row][i];
            row += down ? 1 : -1;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Text: ");
        String text = sc.nextLine();

        System.out.print("Key (rails): ");
        int key = sc.nextInt();

        String enc = encrypt(text, key);
        String dec = decrypt(enc, key);

        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + dec);

        sc.close();
    }
}