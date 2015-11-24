package pkg;

public class CutRod 
{
	static int cutcost = 5;
	public static void main(String[] args) 
	{
		
		int[] price = {10, 50, 80, 90, 100, 170, 170, 200, 240, 300};
		//int[] price = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
		int[] lengths = {1,2,3,4,5,6,7,8,9,10};


		int ans = cut(price, lengths);
		//System.out.println(ans);

		int[] solutions = new int[lengths.length+1];
		int[] sol = cutALL(price, lengths, solutions);
		int i = lengths.length;	
		
		System.out.print("Cut rod at positin : ");
		while(i>0)
		{
			System.out.print(sol[i] +" ");
			i = i - sol[i];
		}
		
	}

	private static int cut(int[] price, int[] lengths) 
	{
		int[] dp = new int[lengths.length+1];
		int solution = 0, L = lengths.length;
		
		for(int i = lengths.length; i >=0; i--)
		{
			dp[lengths.length] = 0;
		}
		
		// ONLY GET THE OPTIMUM MAX REVENUE OF ROD
		for(int currentLength = 1; currentLength<= L; currentLength++)
		{
			solution = Integer.MIN_VALUE;
			int c = 0;
			for(int cutHere = 1; cutHere<=currentLength ; cutHere++)
			{
				if (cutHere == currentLength)
					c = 0;
				else
					c = cutcost;
				solution = Math.max(solution,  dp[currentLength-cutHere] + price[cutHere-1]-c);
			}
			dp[currentLength] = solution;
		}
		return dp[L];
	}
	
	
	
	// GET THE WHERE TO CUT THE ROD FOR OPTIMUM REVENUE
	private static int[] cutALL(int[] price, int[] lengths, int[] sol) 
	{
		int[] dp = new int[lengths.length+1];
		int solution = 0, L = lengths.length;
		
		for(int i = lengths.length; i >=0; i--)
		{
			dp[lengths.length] = 0;
			sol[i] = 0;
		}
		
		for(int currentLength = 1; currentLength<= L; currentLength++)
		{
			for(int cutHere = 1; cutHere<=currentLength ; cutHere++)
			{
				solution = Integer.MIN_VALUE;
				if(dp[currentLength-cutHere] + price[cutHere-1] > solution)////////// check and consider this cut
				{
					solution = Math.max(solution,  dp[currentLength-cutHere] + price[cutHere-1]);
					sol[currentLength]= cutHere;
				}
			}
			dp[currentLength] = solution;
		}
		System.out.println("Optimum revenue : "+dp[L]);
		return sol;
	}
	
}
