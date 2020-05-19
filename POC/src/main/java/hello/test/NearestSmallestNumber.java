import java.util.Arrays;

public class NearestSmallestNumber {

	public static void main(String[] args) {
		int n = 620;
		if (n < 10) {
			System.out.println(n);
		} else {

			String str = Integer.toString(n);
			char[] a = str.toCharArray();
			int index = -1;
			char num = a[a.length - 1];
			for (int i = a.length - 1; i > 1; i--) {
				if (a[i] < a[i - 1]) {
					index = i-1;
					num = a[index];
					break;
				}
			}
			if(index>0) {
				char[] b = str.substring(index).toCharArray();
				Arrays.sort(b);
				for(int i=0;i<b.length;i++) {
					if(b[i] == num) {
						a[index] = b[i-1];
						b[i-1]= ' '; 
						index++;
						break;
					}
				}
				for(int i=b.length-1;i>=0;i--) {
					if(b[i]!=' ') {
						a[index]=b[i];
								index++;

					}
				}
			}
			System.out.println(a);
			
		}
	}
}
