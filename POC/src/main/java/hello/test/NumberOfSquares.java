import java.util.ArrayList;
import java.util.List;

public class NumberOfSquares {

	public static void main(String[] args) {
		System.out.println("number for 5:"+ foo(5));
		System.out.println("number for 7:"+ foo(7));
		System.out.println("number for 12:"+ foo(12));
		System.out.println("number for 20:"+ foo(20));

	}
	public static int foo(int n) {
		int result =0;
		int temp = (int)Math.ceil(Math.sqrt(n));
		List<Integer> a=new ArrayList<>();
		while(temp>0) {
			if(temp*temp <= n) {
				a.add(temp*temp);
			}
			temp--;
		}
		
		return minSquares(a,n);
	}
	
	public static int minSquares(List<Integer> a,int n) {
		if(a.contains(n)) {
			return 1;
		}
		int mi = Integer.MAX_VALUE;
		for(int i=0;i<a.size();i++) {
			int temp = 1;
			if( n-a.get(i)>0) {
				temp = 1+minSquares(a, n-a.get(i));
				if(temp<mi) {
					mi = temp;
				}
			}
		}
		return mi;
	}
}
