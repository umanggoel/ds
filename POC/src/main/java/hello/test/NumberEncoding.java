import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.Semaphore;

public class NumberEncoding {
	 Semaphore s = new Semaphore(1);

	public static void main(String[] args) {
		// System.out.println(findCount("1",0,0));
		// System.out.println(findCount("1234",0,0));
		// List<String> list = generateString(3,new ArrayList<>(), "()");
		// Set<String> result = new HashSet<>();
		// list.forEach(str -> result.add(str));
		// list = new ArrayList<>(result);
		// System.out.println(result);
		int[] arr = {1,1,1,1,2};
		//int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		//countDigit(8999999);
		//permute(arr);
		//largestRectangleArea(arr);
		NumberEncoding n =new NumberEncoding();
	//	Counter c = n.new Counter(10,1);
		//Counter c2 = n.new Counter(10,2);
		//Counter c3 = n.new Counter(10,3);

//		Sample s1=n.new Sample(c1,1);
//		Sample s2=n.new Sample(c1,2);
//		Sample s3=n.new Sample(c1,3);
//		//producer
//		s1.start();
//		s2.start();
//		s3.start();
//		Producer p = n.new Producer(c);
//		Producer p1 = n.new Producer(c);
//		Producer p2 = n.new Producer(c);
//		
//		Consumer c0 = n.new Consumer(c);
//		Consumer c1 = n.new Consumer(c);
//		Consumer c2 = n.new Consumer(c);
//		p.start();
//		p1.start();
//		p2.start();
//		c0.start();
//		c1.start();
//		c2.start();
		
//		int max = 0;
//		for(int i=0;i<arr.length;i++) {
//			int temp = longestIncreasingSubsequence(arr, 0, 1);
//			if(temp>max) {
//				max =temp; 
//			}
//		}
//		System.out.println(max);
		
		HashMap<Date, String> map = new HashMap<>();
		Date d = new Date();
		map.put(d, "Umang");
		System.out.println(map.get(d));
		d.setYear(2018);
		System.out.println(map.get(d));
	}

	class Counter {
		 int number;
		 int limit;
		 Queue<Integer> q = new LinkedList<>();
		 Counter(int n, int y){
			 limit= n;
			 number = y;
		 }
		 public void print() throws InterruptedException {
			 s.acquire();
			 while(number <= limit) {
				 System.out.println(number+Thread.currentThread().getName());
				 number = number+3;
				 s.release();
			 }
		 }
		}
	
	class Producer extends Thread{
		Counter c ;
		Producer(Counter c){
			this.c=c;
		}

		public void run() {
			synchronized (c) {
				while (true) {
					while (c.number == c.limit) {
						try {
							c.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					c.number++;
					c.q.add(c.number);
					System.out.println(Thread.currentThread().getName()+":Produced:" + c.number);
					c.notifyAll();
				}
			}

		}
		}
	

	class Consumer extends Thread {
		Counter c;
		Consumer(Counter c) {
			this.c = c;
		}
		public void run() {
			
				while (true) {
					synchronized (c) {
					while (c.number == 1) {
						try {
							c.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println(Thread.currentThread().getName()+":consumed:" + c.q.poll());
					c.number--;
				}
			}

		}
	}

		class Sample extends Thread{
			Counter c ;
			int nextValue = 1;
			Sample(Counter c, int n){
				nextValue =n;
				this.c=c;
			}
			public void run() {
				synchronized (c) {
					while(c.number<=c.limit) {
					while(c.number != nextValue) {
						try {
							c.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(c.number<c.limit && c.number == nextValue) {
						System.out.println(nextValue);
						nextValue=nextValue+3;
						c.number++;
					}
					c.notifyAll();
				}
					
				}
			}
		}
	public static int findCount(String input, int start, int count) {
		if (input.length() - start == 1 && Integer.parseInt(input.substring(start)) > 0) {
			System.out.println("i" + input.substring(start));
			return count + 1;
		}
		if (input.length() - start == 2 && Integer.parseInt(input.substring(start)) > 9
				&& Integer.parseInt(input.substring(start)) <= 26) {
			System.out.println("i2" + input.substring(start));
			return count + 2;
		}

		count = count + findCount(input, start + 1, count);
		if (input.substring(start).length() > 2 && Integer.parseInt(input.substring(start, 2)) > 9
				&& Integer.parseInt(input.substring(start, 2)) <= 26) {
			System.out.println("i3" + input.substring(start));
			count = count + findCount(input, start + 2, count);
		}
		return count;
	}

	void foo(int[] arr) {
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[j] = arr[i];
				j++;
			}
		}
		for (int i = j; i < arr.length; i++) {
			arr[i] = 0;
		}

	}
	// Map<String, List<String>> map = new HashMap<>();
	//
	// public List<String> letterCombinations(String digits) {
	//
	// List<String> list = new ArrayList<String>();
	// for(int i=0;i<digits.length();i++){
	// List<String> alphabets = map.get(digits.substring(beginIndex,
	// endIndex)(i,1));
	// List<String> tempList = new ArrayList<>();
	// for(int j=0;j<alphabets.size();j++){
	// for(int k=0;k<list.size();k++){
	// templist.add(alphabets.get(j)+list.get(k));
	// }
	// }
	// list.removeAll();
	// list.addAll(templist);
	// }
	// return list;
	//
	// }

	public List<String> foo1(int n) {
		List<String> result = new ArrayList<>();
		String element = "()";
		result.add(element);

		if (n == 1) {
			return result;
		}
		for (int i = 1; i < n; i++) {

		}
		return result;
	}

	public static List<String> generateString(int n, List<String> list, String element) {
		List<String> result = new ArrayList<>();

		if (n == 1) {
			result.add(element);
			return result;
		}

		list = generateString(n - 1, result, element);
		for (int i = 0; i < list.size(); i++) {
			StringBuilder str = new StringBuilder(list.get(i));
			for (int j = 0; j < str.length(); j++) {
				result.add(str.insert(j, element).toString());
				str = new StringBuilder(list.get(i));
			}
		}

		return result;
	}

	public static int rob(int[] nums) {
		int maxSum = 0;
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			if (nums[0] > nums[1]) {
				return nums[0];
			} else {
				return nums[1];
			}
		}
		for (int i = 0; i <= nums.length - 3; i++) {
			int sum = nums[i] + maxSum(nums, i + 2, maxSum);
			if (sum > maxSum) {
				maxSum = sum;
			}
		}
		if (nums.length >= 3 && nums[nums.length - 2] > maxSum) {
			return nums[nums.length - 2];
		}
		if (nums.length >= 2 && nums[nums.length - 1] > maxSum) {
			return nums[nums.length - 1];
		}
		if (nums.length == 1 && nums[nums.length - 1] > maxSum) {
			return nums[nums.length - 1];
		}
		return maxSum;
	}

	public static int maxSum(int[] nums, int start, int maxSum) {
		if (start >= nums.length - 1)
			return nums[nums.length - 1];
		if (start >= nums.length - 2) {
			if (nums[nums.length - 2] > nums[nums.length - 1]) {
				return nums[nums.length - 2];
			} else {
				return nums[nums.length - 1];
			}
		}
		int sum = 0;
		int maxSumTemp = 0;
		for (int i = start; i < nums.length - 2; i++) {
			sum = 0;
			sum = nums[i] + maxSum(nums, i + 2, maxSum);
			if (sum > maxSumTemp) {
				maxSumTemp = sum;
			}
		}

		return maxSumTemp;

	}

	public static int[] searchRange(int[] nums, int target) {

		int start = 0;
		int end = nums.length;
		int mid = (start + end) / 2;
		int index = -1;
		while (start < nums.length && start <= end && end >= 0) {
			mid = (start + end) / 2;
			if (target == nums[mid]) {
				index = mid;
				break;
			} else if (target < nums[mid]) {
				end = mid - 1;
			} else if (target > nums[mid]) {
				start = mid + 1;
			}
		}
		if (index == -1) {
			return new int[] { -1, -1 };
		}
		int startIndex = index;
		int endIndex = index;
		while (startIndex >= 0 && nums[startIndex] == target) {
			startIndex--;
		}
		while (endIndex < nums.length && nums[endIndex] == target) {
			endIndex++;
		}
		return new int[] { startIndex, endIndex };
	}

	public static void rotate(int[][] matrix) {
		int length = matrix[0].length;
		for (int i = 0; i < length - 1; i++) {
			for (int j = i; j < length - 1; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][length - i - 1];
				matrix[j][length - i - 1] = matrix[length - i - 1][length - j - 1];
				matrix[length - i - 1][length - j - 1] = matrix[length - j - 1][i];
				matrix[length - j - 1][i] = temp;
			}
		}
	}

	public static void zigZag(int[][] a) {
		int length = a[0].length;
		int y = 0;
		int z = length - 1;
		boolean order = true;
		for (int i = 0; i < 2 * length - 1; i++) {
			if (y < length) {
				for (int j = 0; j <= y; j++) {
					if (order) {
						System.out.println(a[j][y - j]);
					} else {
						System.out.println(a[y - j][j]);
					}
				}
			}
			y++;
			if (y >= length) {
				for (int j = z; j >= length - z; j--) {
					if (order) {
						System.out.println(a[j][z - j + 1]);
					} else {
						System.out.println(a[z - j + 1][j]);
					}
				}
				z--;
			}
			order = !order;
		}
	}

	public static List<List<Integer>> permute(int[] nums) {
		return permutations(nums, new ArrayList<>(), 0);
	}

	public static List<List<Integer>> permutations(int[] nums, List<List<Integer>> list, int start) {

		if (start == nums.length - 1) {
			List<Integer> temp = new ArrayList<>();
			temp.add(nums[start]);
			list.add(temp);
			return list;
		}

		list = permutations(nums, list, start + 1);
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j <= list.get(i).size(); j++) {
				List<Integer> temp = new ArrayList<>();
				temp.addAll(list.get(i));
				temp.add(j,nums[start]);
				result.add(temp);
			}
		}
		return result;

	}
	
	public static List<List<Integer>> subsets(int[] nums, List<List<Integer>> list, int start) {

		if (start == nums.length - 1) {
			return list;
		}

		list = permutations(nums, list, start + 1);
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j <= list.get(i).size(); j++) {
				List<Integer> temp = new ArrayList<>();
				temp.addAll(list.get(i));
				temp.add(j,nums[start]);
				result.add(temp);
			}
		}
		return result;

	}
	
	public static int longestIncreasingSubsequence(int a[],int start,int cm) {
		if(start == a.length-2) {
			if(a[start] <a[start+1])return 2;
			if(a[start] >=a[start+1])return 1;
			return 0;
		}
		if(start == a.length-1) {
			if(a[start] >=a[start-1])return 1;
			return 0;
		}
		if(a[start] > a[start+1]) {
			int temp = longestIncreasingSubsequence(a, start+1, cm);
			if(cm > temp ) {
				return cm;
			}
			else {
				return temp;
			}
		}
		if(a[start] == a[start+1]) {
			int temp = longestIncreasingSubsequence(a, start+2, cm);
			if(cm > temp ) {
				return cm;
			}
			else {
				return temp;
			}
		}
		
		return cm+longestIncreasingSubsequence(a, start+1, cm);
		
	}
	
	public static int countDigit(int n) {
		double noDigits = Math.floor(Math.log10(n));
		int result = 10;
		for(double i = 1;i<noDigits;i++) {
			result = result*10;
		}
		System.out.println(result);
		return 0;
	}
	
	public static int largestRectangleArea(int[] heights) {
        Stack<Integer> start = new Stack<>();
        Stack<Integer> h = new Stack<>();

        int max = heights[0];
        start.push(0);
        h.push(heights[0]);
        for(int i=1;i<heights.length;i++){
            if(h.isEmpty() || heights[i] >  h.peek()){
                start.push(i);
                h.push(heights[i]);
                if(heights[i] > max){
                    max = heights[i];
                }
            }else {
                while(!h.isEmpty() && heights[i] < h.peek()){
                    int j = h.pop();
                    int temp = j*(i-start.pop()+1);
                    if(temp > max){
                        max=temp;
                     }
                }
                
            }
        }
        
        return max;
    }
	
}
	
//	public int firstMissingPositive(int[] nums) {
//        int max = 1;
//        int min = Integer.MAX_VALUE;
//        x b= new x();
//        b.foo();
//        
//    }

//}



