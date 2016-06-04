package pkg;

public class Longest_Increasing_subsequence_DP
{

	public static void main(String[] args) 
	{
        int A[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
        int n = A.length;
        System.out.println("Length of Longest Increasing Subsequence is "+ LIS(A, n));
	}

	private static int LIS(int[] array, int n)  {
		int maxLength = 1;
		int[] DP = new int[n];
		DP[0] = 1;
		int[] sol = new int[n];

		for (int i = 1; i < n; i++) {
		   DP[i] = 1;
		   for (int j = i - 1; j >= 0; j--) {
		      if (DP[j] + 1 > DP[i] && array[j] < array[i]) {
		         DP[i] = DP[j] + 1;
		      }
		   } 
		   if (DP[i] > maxLength) {
		      maxLength = DP[i];
		   }
		}
		return maxLength;
	}
}
