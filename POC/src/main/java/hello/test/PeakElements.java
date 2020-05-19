import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PeakElements {

	public static void generatePeakElements(int n) {
		int digitsCount = (int) Math.log10(n) + 1;
		System.out.println(digitsCount);
		Map<Integer, Set<Integer>> map = new HashMap<>();
		Set<Integer> temp = new HashSet<>();
		for (int i = 1; i < 10; i++) {
			temp.add(i);
		}
		map.put(1, temp);
		for (int i = 2; i <= digitsCount; i++) {
			Set<Integer> levelList = map.get(i - 1);
			temp = new HashSet<>();
			for (Integer j : levelList) {
				String s = Integer.toString(j);
				String first = s.substring(0, 1);
				String last = s.substring(s.length() - 1);
				String newFirstAdd = Integer.toString((Integer.parseInt(first) + 1));
				String newFirstSub = Integer.toString((Integer.parseInt(first) - 1));
				String newLastAdd = Integer.toString((Integer.parseInt(last) + 1));
				String newLastSub = Integer.toString((Integer.parseInt(last) - 1));
				if (Integer.parseInt(s + newLastSub) <= n) {
						temp.add(Integer.parseInt(s + newLastSub));
				}
				if (Integer.parseInt(s + newLastAdd) <= n) {
					temp.add(Integer.parseInt(s + newLastAdd));
				}
				if (Integer.parseInt(newFirstAdd+s) <= n) {
					temp.add(Integer.parseInt(newFirstAdd+s));
				}
				if (Integer.parseInt(newFirstSub+s) <= n) {
					temp.add(Integer.parseInt(newFirstSub+s));
				}
			}
			map.put(i,temp);
		}
		System.out.println("done");
	}

	public static void main(String[] args) {
		generatePeakElements(5000);
	}
}
