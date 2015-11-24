package pkg;

public class Longest_Increasing_Subsequence_Efficient 
{
	
    public static void main(String[] args)
    {
        int A[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
        int n = A.length;
        System.out.println("Length of Longest Increasing Subsequence is "+ LongestIncreasingSubsequenceLength(A, n));
        
        int i = 6;// get position of LIS last elements
    	System.out.print(A[7]+" ");
    	int temp = A[7];
        while(i>=0)
        {
        	if(A[i] < temp)
        	{
        		temp = A[i];
        		System.out.print(temp+" ");
        	}
        	i--;
        }
    }
    
    
    /*
     	1. If A[i] is smallest among all end candidates of active lists, 
      		we will start new active list of length 1.
		2. If A[i] is largest among all end candidates of active lists, 
			we will clone the largest active list, and extend it by A[i].
		3. If A[i] is in between, we will find a list with largest end element that is smaller than A[i]. 
			Clone and extend this list by A[i]. We will discard all other lists of same length as that of this modified list.
     */
    static int LongestIncreasingSubsequenceLength(int A[], int size)
    {
        // Add boundary case, when array size is one 
        int[] tailTable   = new int[size];
        int len; // always points empty slot
 
        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++)
        {
            if (A[i] < tailTable[0])
                // new smallest value
                tailTable[0] = A[i];
 
            else if (A[i] > tailTable[len-1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];
 
            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, 0, len-1, A[i])] = A[i];
        }
        return len;
        //return tailTable[len-1];
    }

	// Binary search (note boundaries in the caller)
	// A[] is ceilIndex in the caller
    static int CeilIndex(int A[], int l, int r, int key)
    {
        while (r > l+1)
        {
            int m = (l + r)/2;
            if (A[m]>=key)
                r = m;
            else
                l = m;
        }
        return r;
    }
}
