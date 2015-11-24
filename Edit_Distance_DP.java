package pkg;

public class Edit_Distance_DP 
{

	public static void main(String[] args) 
	{
		String input = "S";
		String output = "SATURDAY";
		
		int ans = EditDistance(input,output,input.length(),output.length());
		System.out.println("Number of Operations done : "+ans);
	}

	private static int EditDistance(String in, String out, int in_len, int out_len) 
	{
		int[][] dp = new int[out_len+1][in_len+1];
		
		for(int i = 0; i < in_len+1; i++)
			dp[0][i]=i;
		for(int i = 0; i < out_len+1; i++)
			dp[i][0]=i;
		
		for(int i=1; i<out_len+1; i++)
		{
			for(int j=1; j< in_len+1; j++)
			{
				if(in.charAt(j-1)==out.charAt(i-1))
				{
					dp[i][j] = dp[i-1][j-1];
				}
				else
				{
					dp[i][j] = Math.min(
										dp[i-1][j-1], 
										Math.min(
												dp[i][j-1],
												dp[i-1][j]
												)
										)+1;
				}
			}
		}
		
		// i ->out
		// j ->in and str
		StringBuffer str = new StringBuffer(in);
		int i = out_len, j = in_len;
		while(i>0 && j>0)
		{
			if(dp[i][j]== dp[i-1][j-1] && in.charAt(j-1) == out.charAt(i-1))
			{
				// No operation done.
				i--;j--;
			}
			else if(dp[i][j] -1  == dp[i-1][j-1])
			{
				// Replace operation done. Replace output string character-i
				str.replace(j-1, j, Character.toString(out.charAt(i-1)));
				i--;j--;
			}
			else if(dp[i][j]-1 ==  dp[i-1][j])
			{
				//Insert from input Operation done. insert from Output string-i.
				str.insert(j, out.charAt(i-1));
				i--;
			}
			else if(dp[i][j]-1 ==  dp[i][j-1])
			{
				//Delete from input Operation done.
				str.delete(j-1, j);
				j--;
			}
		}

		System.out.println(in+ " converted to :->" + str);
		return dp[out_len][in_len];
	}
}
