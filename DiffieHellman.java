// public class DiffieHellman {
//     public static void main(String[] args) {
//         int p = 23; // prime
//         int g = 5;  // base

//         int a = 6; // private A
//         int b = 15; // private B

//         int A = (int) Math.pow(g, a) % p;
//         int B = (int) Math.pow(g, b) % p;

//         int keyA = (int) Math.pow(B, a) % p;
//         int keyB = (int) Math.pow(A, b) % p;

//         System.out.println("Shared Key A: " + keyA);
//         System.out.println("Shared Key B: " + keyB);
//     }
// }

// Rely:

public class DiffieHellman {
    public static void main(String[] args) {
        int p = 23;
        int g = 5;

        int a = 6;
        int b = 15;

        int A = modPow(g, a, p);
        int B = modPow(g, b, p);

        int keyA = modPow(B, a, p);
        int keyB = modPow(A, b, p);

        System.out.println("Shared Key A: " + keyA);
        System.out.println("Shared Key B: " + keyB);
    }

    public static int modPow(int base, int exp, int mod) {
        int result = 1;
        base = base % mod;

        while (exp > 0) {
            if (exp % 2 == 1)
                result = (result * base) % mod;

            exp = exp / 2;
            base = (base * base) % mod;
        }
        return result;
    }
}
