package leetcode.problems.arrays;

public class ReshapeTheMatrix {

    public static void main(String[] args) {
        ReshapeTheMatrix m = new ReshapeTheMatrix();
        int[][] mat = {{1,2},{3,4}};
        int r = 4;
        int c = 1;
        m.matrixReshape(mat, r, c);
    }
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int mR = mat.length;
        int mC = mat[0].length;
        System.out.println(mR);
        System.out.println(mC);
        if (mR*mC != r*c) {
            return mat;
        }
        int idxR = 0;
        int idxC = 0;

        int[][] res = new int[r][c];
        for (int i = 0; i < mR; i++) {
            for (int j = 0; j < mC; j++) {
                System.out.println("i: " + i + " j: " + j + " idxR: " + idxR + " idxC: " + idxC);
                res[idxR][idxC] = mat[i][j];
                if ((idxC + 1) % c == 0) {
                    idxC = 0;
                    idxR++;
                } else {
                    idxC++;
                }
            }
        }

        return res;
    }
}
