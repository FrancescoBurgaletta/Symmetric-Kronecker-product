public class SymmetricKroneckerTest {

    public static void symmetric_kronecker_test() {
        double s = Math.pow(2, -0.5);
        double[][] a = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        },
        b = {
            {17, 18, 19, 20},
            {21, 22, 23, 24},
            {25, 26, 27, 28},
            {29, 30, 31, 32}
        },
        q = {
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, s, 0, 0, s, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, s, 0, 0, 0, 0, 0, s, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, s, 0, 0, 0, 0, 0, 0, 0, 0, s, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, s, 0, 0, s, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, s, 0, 0, 0, 0, 0, s, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, s, 0, 0, s, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        };

        double[][] ab = new double[16][16], ba = new double[16][16];

        for (int i = 0; i < 4; i++) for (int j = 0; j < 4; j++) for (int k = 0; k < 4; k++) for (int l = 0; l < 4; l++) {
            ab[i * 4 + k][j * 4 + l] = a[i][j] * b[k][l];
            ba[i * 4 + k][j * 4 + l] = b[i][j] * a[k][l];
        }

        double[][] abba = new double[16][16];
        
        for (int i = 0; i < 16; i++) for (int j = 0; j < 16; j++) {
            abba[i][j] = ab[i][j] + ba[i][j];
        }
        
        double[][] qabba = new double[10][16];
        
        for (int k = 0; k < 16; k++) for (int i = 0; i < 10; i++) for (int j = 0; j < 16; j++) {
            qabba[i][j] += q[i][k] * abba[k][j];
        }
        
        double[][] qabbaqt = new double[10][10];
        
        for (int k = 0; k < 16; k++) for (int i = 0; i < 10; i++) for (int j = 0; j < 10; j++) {
            qabbaqt[i][j] += qabba[i][k] * q[j][k];
        }
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print((qabbaqt[i][j] * 0.5) + "\t");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        symmetric_kronecker_test();
    }
}