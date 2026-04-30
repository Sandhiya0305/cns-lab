public class DiffieHellman {
    public static void main(String[] args) {
        int p = 23; // prime
        int g = 5;  // base

        int a = 6; // private A
        int b = 15; // private B

        int A = (int) Math.pow(g, a) % p;
        int B = (int) Math.pow(g, b) % p;

        int keyA = (int) Math.pow(B, a) % p;
        int keyB = (int) Math.pow(A, b) % p;

        System.out.println("Shared Key A: " + keyA);
        System.out.println("Shared Key B: " + keyB);
    }
}