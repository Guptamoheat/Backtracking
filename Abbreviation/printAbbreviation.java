package Mohit.java.DSA.BackTracking;

public class printAbbreviation {
    public static void main(String[] args) {
        solve("pep", "", 0, 0);
    }

    public static void solve(String str, String asf, int count, int pos) {
        if(pos == str.length()) {
            if(count == 0) {
                System.out.println(asf);
            } else {
                System.out.println(asf + count);
            }

            return;
        }

        if(count != 0) {
            solve(str, asf + count + str.charAt(pos), 0, pos + 1);
            solve(str, asf, count + 1, pos + 1);
        } else {
            solve(str, asf + str.charAt(pos), 0, pos + 1);
            solve(str, asf, count + 1, pos + 1);
        }
    }
}
