
public class Test {

	public static void main(String[] args) {
		int arr2[] = {-1, 2, -3, -4, 5, 0, 6, -7, -8, 10, 9};
		int arr[] = { -1, 2, -3, 4, 5, -6, -7, 8, -9 ,-10,3};
		int arr1[] = { -1, -0, -3, -4, 5, -6, 7, 8, 9 ,10,3};
		rearrangeNumbers(arr1);
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
	}

	public static void rearrangeNumbers(int arr[]) {
		int length = arr.length;
		int start = 0;
	
		
		for (int i = 0; i < length; i++) {
			if (start % 2 != 0 && start <length) {
				if (arr[start] < 0) {
					start++;
				} else if (arr[i] < 0) {
					int temp = arr[start];
					arr[start] = arr[i];
					arr[i] = temp;
					start++;
				}
			}
			if (start % 2 == 0) {
				if (arr[start] >= 0) {
					start = start + 1;
				} else if (arr[i] >= 0) {
					int temp = arr[start];
					arr[start] = arr[i];
					arr[i] = temp;
					start = start + 1;
				}
			} 
			
		}
	}
}
