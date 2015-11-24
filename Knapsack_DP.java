package pkg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Knapsack_DP
{
	static int S = 5;
	static int[] s_wt = {4,2,3};
	static int[] values = {10,4,7};
	

	public static void main(String[] args) 
	{
		int[][] dp = new int[s_wt.length+1][S+1];
		// initial condition
		for(int i = 0; i <= S; i++)
			dp[s_wt.length][i]= 0;		
		int ans = knapsack_dp(dp);
		System.out.println("Optimal value that can be collected : "+ ans);
	}
	
	
	private static int knapsack_dp(int[][] dp) 
	{

		for(int object = s_wt.length-1 ; object >=0; object--)
		{
			for(int capacity = 0 ; capacity <= S; capacity++)
			{
				if(capacity >= s_wt[object]) // can be selected
				{
					dp[object][capacity] = 
							Math.max(
										dp[object+1][capacity], 
										dp[object+1][capacity-s_wt[object]] + values[object]
									);					
				}
				else // can not select keep old optimal solution
				{
					dp[object][capacity] = (dp[object+1][capacity]);
				}
			}
		}
		return dp[0][S];
	}
}
