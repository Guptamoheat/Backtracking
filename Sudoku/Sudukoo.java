package Mohit.java.DSA.BackTracking;

import java.util.Arrays;
import java.util.Scanner;


public class Sudukoo {
    public static void main(String[] args) {
        int arr[][] = new int[9][9];
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        solve(arr, 0, 0);
        sc.close();
    }

    public static void solve(int[][] arr, int row, int col) {
        if(row == arr.length) {
            for(int i = 0; i < 9; i++) {
                System.out.print(Arrays.toString(arr[i]) + " ");
            }
            return;
        }

        int nrow = 0;
        int ncol = 0;

        if(col == arr.length - 1) {
            nrow = row + 1;
            ncol = 0;
            //System.out.println("nrow = " + nrow + " ncol = " + ncol);
            
        } else {
            nrow = row;
            ncol = col + 1;
        }

        //System.out.println("row = " + row + " col = " + col);
        if(arr[row][col] != 0) {
            solve(arr, nrow, ncol);
        } else {
            for(int po = 1; po <= 9 ; po++) {
                if(isValid(arr, row, col, po)) {
                    arr[row][col] = po;
                    solve(arr, nrow, ncol);
                    arr[row][col] = 0;
                }
            }
        }
    }

    public static boolean isValid(int[][] arr, int row, int col, int po) {

        for(int j = 0; j < 9; j++) {
            if(arr[row][j] == po) {
                return false;
            }
        }

        for(int i = 0; i < 9; i++) {
            if(arr[i][col] == po) {
                return false;
            }
        }

        int smi = row / 3 * 3;
        int smj = col / 3 * 3;

        for(int i = 0 ; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(arr[smi + i][smj + j] == po) {
                    return false;
                }
            }
        }
        return true;
    }
}
