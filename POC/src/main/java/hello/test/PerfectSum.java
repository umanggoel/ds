
public class PerfectSum {

	public static void main(String[] args) {
		int arr[] = {2,3,5,6,8,10};
		int sum = 2;
		System.out.println(calSum(arr,arr.length-1,sum));
	}
	public static boolean calSum(int a[],int n, int sum) {
		if(n < 0) return false;
		if(sum == 0) return true;
		
		if(sum == a[n]) {
				return true;
		}
		if(sum < a[n]) {
			return calSum(a,n-1,sum);
		}
		
		return calSum(a,n-1,sum) || calSum(a,n-1,sum-a[n]);
	}
	
}
