import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DayWithMAxNumberofGuests {

	Map<Integer, Integer> mapcount = new HashMap<>();

	public void foo(int a[],int d[]) {
		for(int i=0;i<a.length;i++) {
			for(int j=a[i];j<=d[i];j++) {
				Integer temp = mapcount.get(j);
				if(temp==null) {
					temp=0;
				}
				temp++;
				mapcount.put(j, temp);
			}
		}
		int max = 0;
		int day =0;
		for(Entry<Integer,Integer> s: mapcount.entrySet()) {
			if(s.getValue() > max) {
				max = s.getValue();
				day = s.getKey();
			}
		}
		System.out.println(day);
	}
}
