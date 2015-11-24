package pkg;

import java.util.ArrayList;
import java.util.List;

public class LCS_DP
{

	public static void main(String[] args) 
	{
		String Y = "PQAYBZBA";
		String X = "ABZBYAQP";
		
		LCS(X,Y,X.length(),Y.length());
	}

	private static int LCS(String x, String y, int x_len, int y_len) 
	{
		int[][] dp = new int[x_len+1][y_len+1];

		for(int i = 0; i < y_len; i++)
			dp[0][i]= 0;
		for(int i = 0; i < x_len; i++)
			dp[i][0]= 0;
		
		for(int i = 1; i < x_len+1; i++)
		{
			for(int j = 1; j < y_len+1; j++)
			{
				if(x.charAt(i-1) == y.charAt(j-1))
				{
					dp[i][j] = dp[i-1][j-1]+1;
				}
				else
				{
					dp[i][j] = Math.max(
										dp[i][j-1],
										dp[i-1][j]
										);
				}				
			}
		}
		

		System.out.println("String one: "+x);
		System.out.println("String two: "+y);
		List<Character> sol = new ArrayList<Character>();
		int i=x_len, j=y_len;
		while(i>0 && j >0)
		{
			if(x.charAt(i-1)==y.charAt(j-1))
			{
				sol.add(x.charAt(i-1));
				i--;j--;
			}
			else if(dp[i-1][j]>= dp[i][j-1])
				i--;
			else
				j--;			
		}
		System.out.println("Longest Common Subsequence length: "+dp[x_len][y_len]);
		System.out.println("Longest Common Subsequence in reversed order is : "+sol);
		return dp[x_len][y_len];
	}

}
