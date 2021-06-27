import java.util.Stack;

public class SubsetSum {

	public static void main(String[] args) {
	
		SubsetSum sum = new SubsetSum();
		int[] arr= new int[] {15, 22, 14, 26, 32, 9, 16, 8};
		boolean result = sum.isSubsetPossible(arr,45,0);
		System.out.println(result);
		
	}
	
	static Stack<Integer> result = new Stack<>();
	
	public boolean isSubsetPossible(int[] arr, int sum ,int start) {
		
		if(start >= arr.length) {
			return false;
		}
		if(sum == 0) {
			return true;
		}
		
		int temp = sum - arr[start];
		result.push(arr[start]);
		
		if(temp == 0) {
			return true;
		}else if(temp < 0) {
			result.pop();
			return false;
		}else {
			for(int i=start+1;i<arr.length;i++) {
				if(isSubsetPossible(arr, temp, i)) {
					return true;
				}
			}
		}
		result.pop();
		return false;
	}
	
	
}
