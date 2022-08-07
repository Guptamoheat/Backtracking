package Mohit.java.DSA.BackTracking;

public class NQueens {
    public static void main(String[] args) {
        boolean[][] chess = new boolean[4][4];
        boolean[] colArr = new boolean[4];
        boolean[] nDigArr = new boolean[7];
        boolean[] rDigArr = new boolean[7];

        solve(chess, 0, colArr, nDigArr, rDigArr, "");
    }

    public static void solve(boolean[][] chess, int row, boolean colArr[], boolean nDigArr[], boolean rDigArr[], String asf) {
        if(row == chess.length) {
            System.out.println(asf);
            return;
        }

        for(int col = 0; col < chess.length; col++) {

            if((colArr[col] == false) && (nDigArr[row + col] == false) && (rDigArr[row - col + chess.length - 1] == false)) {
                
                colArr[col] = true;
                nDigArr[row + col] = true;
                rDigArr[row - col + chess.length - 1] = true;
                //chess[row][col] = true;
                solve(chess, row + 1, colArr, nDigArr, rDigArr, asf + row + "-" + col + ", ");
                //chess[row][col] = false;
                colArr[col] = false;
                nDigArr[row + col] = false;
                rDigArr[row - col + chess.length - 1] = false;
            }
        }
    }
}
