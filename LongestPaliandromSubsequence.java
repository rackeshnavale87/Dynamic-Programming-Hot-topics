package pkg;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class LPS_DP {
	public static void main(String[] args)  {
		String X = "XAGBDBAXX";
		int dps = dpS(X,X.length());
		System.out.println("\nLongest Paliandrom Subsequence length: "+dps);

	}
	private static int dpS(String x, int length) {
		int[][] dp = new int[length][length];
		
		for(int i=0;i<length;i++) {
			dp[i][i] = 1;			
		}
		
		for(int sublen = 2;sublen<=length; sublen++) {
			for(int i=0;i<=dp.length-sublen;i++) {
				int j = i+sublen-1;
				if(x.charAt(i)==x.charAt(j) && sublen==2) {
					dp[i][j] = 2;
				}
				else if(x.charAt(i)==x.charAt(j)){
					dp[i][j] = dp[i+1][j-1]+2;
				}
				else{
					dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
				}
			}
		}
		
		List<Character> sol = new ArrayList<Character>();
		List<Character> solpart2 = new ArrayList<Character>();
		int i = 0, j = length-1;
		while(i < length && j>0 && j>=i) {
			if(x.charAt(i)==x.charAt(j)) {
				sol.add(x.charAt(j));
				i++;j--;
			}
			else if(dp[i+1][j]>= dp[i][j-1])
				i++;
			else
				j--;			
		}

		int ans = dp[0][dp.length-1];
		int flag = (ans == sol.size()*2) ? 0 : 1;
		
		List<Character> sol2 = new ArrayList<Character>();
		ListIterator<Character> itr = sol.listIterator();
		while(itr.hasNext())
			sol2.add(itr.next());
		if(flag==1)
			itr.previous();
		while(itr.hasPrevious())
			sol2.add(itr.previous());

		System.out.print("Longest possible Paliandrom that can be generated is : ");
		itr = sol2.listIterator();
		while(itr.hasNext())
			System.out.print(itr.next());
		
		return dp[0][dp.length-1];
	}
}
