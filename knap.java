// A Dynamic Programming based solution for 0-1 Knapsack problem
class Main {

	// A utility function that returns maximum of two integers
	static int max(int a, int b)
{ return (a > b) ? a : b; }

	// Returns the maximum value that can be put in a knapsack
	// of capacity W
	static int knapSack(int W, int wt[], int val[], int n)
	{
		
		int K[][] = new int[n + 1][W + 1];
        // builds k[][] according to algorithm we learnt.
		for(int w =0;w<=W;w++)
		K[0][w]=0;
		for(int i=0;i<=n;i++)
		K[i][0]=0;
        for(int i=1;i<=n;i++)
        {
            for(int w=1;w<=W;w++)// val[i-1] and wt [i-1] are -1 coz of array indexing
            {
                if(wt[i-1]>w)
                K[i][w]=K[i-1][w];
                else
                K[i][w]=max(K[i-1][w],val[i-1]+K[i-1][w-wt[i-1]]);
            }
        }
        		
        // find items in knapSack
        System.out.println("Items in knapSack : \n");
    int i=n,k=W;
    while(i>0 && k>0)
    {
        if(K[i][k]!=K[i-1][k])
        {
            System.out.println(val[i-1]+" "+wt[i-1]);
           
            k=k-wt[i-1];
             i=i-1;
            
        }
        else
        i=i-1;
    }
    return K[n][W];
	}
	// Driver program to test above function
	public static void main(String args[])
	{
		int val[] = new int[] { 20,10,30 };
		int wt[] = new int[] { 2,2,3 };
		int W = 5;
		int n = val.length;
		System.out.println(knapSack(W, wt, val, n));
	}
}
