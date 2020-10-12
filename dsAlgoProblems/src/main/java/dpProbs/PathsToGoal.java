package dpProbs;

import java.util.Scanner;

public class PathsToGoal {

	//https://www.careercup.com/question?id=6229105402970112
	public static void main(String[] args) {

		//Scanner sc = new Scanner(System.in);
        String str = "rrlrlr"; //sc.next();
        int n = 6; //sc.nextInt();
        int s = 1; //sc.nextInt();
        int d = 2; //sc.nextInt();
        // Assuming n and str.len() < 100
        int[][][] dp = new int[101][100][2];
        for (int i = 0; i < 100; i++)
            for (int j = 0; j < 100; j++)
                for (int z = 0; z < 2; z++)
                    dp[i][j][z] = -1;

        int res = solve(str, 0 , 0, s, d, n, dp) + solve(str, 0, 1, s, d, n, dp);
        System.out.println(res);

    }
    static int solve(String str, int idx, int flag, int s, int d, int n, int[][][] dp){
        if(s > n || s < 0)
            return 0;
        if(dp[idx][s][flag] != -1) {
            return dp[idx][s][flag];
        }
        int len = str.length();
        if(idx >= len)
            return 0;
        int res;
        if( (str.charAt(idx) == 'l' && flag == 0 ) || ( str.charAt(idx) == 'r' && flag != 0) ){
            int f = 1;
            if(str.charAt(idx) == 'l')
                f = -1;
            res = solve(str, idx + 1, flag, s + f, d, n, dp) + solve(str, idx + 1, 1 - flag, s + f, d, n, dp);
            // Do a modulo here if needed
            if(s + f == d)
                res++;
        }
        else{
            res = solve(str, idx + 1, flag, s, d, n, dp);
        }
        dp[idx][s][flag] = res;
        return res;
    }
}
