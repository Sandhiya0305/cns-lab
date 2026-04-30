import java.util.*;

public class RowColumn {

    static String encrypt(String text, int key) {
        int rows = (int)Math.ceil((double)text.length()/key);
        char[][] grid = new char[rows][key];

        int k = 0;
        for(int i=0;i<rows;i++)
            for(int j=0;j<key;j++)
                grid[i][j] = (k < text.length()) ? text.charAt(k++) : 'X';

        String result="";
        for(int j=0;j<key;j++)
            for(int i=0;i<rows;i++)
                result += grid[i][j];

        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Text: ");
        String text = sc.nextLine();

        System.out.print("Key (columns): ");
        int key = sc.nextInt();

        System.out.println("Encrypted: " + encrypt(text, key));
        sc.close();
    }
}