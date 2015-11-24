package pkg;

public class Fibonacii {

	public static void main(String[] args) 
	{
		
		long startTime = System.currentTimeMillis();
		int n = 20;
		
		//int ans = fibo(n);
		//System.out.println(ans);
		
		int ans = fibonacci_rec(n);
		System.out.println(ans);
		
				
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time : "+totalTime*100);
	}

	private static int fibo(int n) 
	{
		
		int[] dp = new int[n+1];
		dp[0]=0;
		dp[1]=1;
		dp[2]=1;
		
		for(int i = 3; i<=n; i++)
		{
			dp[i]= dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
	
	
	public static int fibonacci_rec(int n) {
	    if (n < 3) return 1;
	    return fibonacci_rec(n-2) + fibonacci_rec(n-1);
	}
	
	
	

}
