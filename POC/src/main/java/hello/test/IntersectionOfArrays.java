import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class IntersectionOfArrays {

	Map<Integer,Integer> map = new HashMap<>();
	public void printIntersection(int arr[], int arr2[], int arr3[]) {
		List<Integer> result = new ArrayList<>();
		Set<Integer> s = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			Integer temp = map.get(arr[i]);
			if(s.add(arr[i])) {
				if(temp != null) {
					temp++;
				}else {
					temp = 1;
				}
				map.put(arr[i], temp);
			}
		}
		s = new HashSet<>();
		for (int i = 0; i < arr2.length; i++) {
			Integer temp = map.get(arr2[i]);

			if(s.add(arr2[i])) {
			if(temp != null) {
				temp++;
			}else {
				temp = 1;
			}
			map.put(arr2[i], temp);
			}
		}
		s = new HashSet<>();
		for (int i = 0; i < arr3.length; i++) {
			Integer temp = map.get(arr3[i]);
			if(s.add(arr3[i])) {
			if(temp != null) {
				temp++;
			}else {
				temp = 1;
			}
			map.put(arr3[i], temp);
			}
		}
		
		for(Entry e: map.entrySet()) {
			if((int)e.getValue() == 3) {
				result.add((int)e.getKey());
			}
		}
		System.out.print(result);
	}
	
	public static void main(String[] args) {
		IntersectionOfArrays i = new IntersectionOfArrays();
		int arr[] = {1,3,3};
		int arr2[]={3,2,1};
		int arr3[] = {1,6,2};
		i.printIntersection(arr,arr2,arr3);
	}
}
