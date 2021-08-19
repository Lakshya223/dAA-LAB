import java.util.*;

class Request{
	int s,f,v;
	Request(int s, int f, int v){
		this.s = s; // start time
		this.f = f; // finish time
		this.v = v; // profit or value
	}
}

class SortByFinishTime implements Comparator<Request>{
	public int compare(Request r1, Request r2) {
		return r1.f-r2.f;
	}
}

public class WeightedIntervalScheduling
{	
	
	static int N;
	static ArrayList<Request> arr = new ArrayList<>();
	static int[] pred;
	static int[] sol;
	
	static void findPred() {
		pred = new int[N+1];
		for(int i=1;i<N;i++) {
			for(int j=i-1;j>=0;j--) {
				if(arr.get(j).f<=arr.get(i).s) {
					pred[i+1] = j+1;
					break;
				}
			}
		}
	}
	
	static int solve(int i) {
		if(i==0) {
			sol[i] = 0;
			return 0;
			}
		if(sol[i]!=-1) return sol[i];
		sol[i] = Math.max(arr.get(i-1).v + solve(pred[i]), solve(i-1));
		return sol[i];
	}
	
	static void findRequests(int i) {
		if(i>0) {
			if((arr.get(i-1).v + sol[pred[i]]) > sol[i-1]) {
				System.out.print(i + "  ");
				findRequests(pred[i]);
			}
			else findRequests(i-1);
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no. of requests : ");
		
		N = sc.nextInt();
		System.out.println("Enter the request no. , start time, finish time and profit : ");
		for(int i=0;i<N;i++) {
			int j = sc.nextInt();
			int s = sc.nextInt();
			int f = sc.nextInt();
			int v = sc.nextInt();
			arr.add(j-1,new Request(s,f,v));
		}
		
		Collections.sort(arr, new SortByFinishTime());
		findPred();
		
		sol = new int[N+1];
		for(int i=0;i<N+1;i++) sol[i] = -1;
		
		int maxProf = solve(N);
		
		System.out.println("The maximum profit is : " + maxProf);
		System.out.println("The requests included in the optimal solution are : ");
		
		findRequests(N);
		
		
	}
}
