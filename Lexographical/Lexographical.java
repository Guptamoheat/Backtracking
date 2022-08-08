package Mohit.java.DSA.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Lexographical {
    public static void main(String[] args) {
        int n = 100;
        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= 9; i++) {
            solve(i, n, list);
        }

        System.out.println(list);
    }

    public static void solve(int i, int n, List<Integer> list) {
        if(i > n) {
            return;
        }

        list.add(i);
        for(int j = 0; j <= 9; j++) {
            solve(i*10 + j, n, list);
        }
    }
}
