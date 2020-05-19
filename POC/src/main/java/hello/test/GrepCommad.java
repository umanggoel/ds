import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GrepCommad {

	
	Map<String,Integer> map = new LinkedHashMap<>();
	Queue<String> q;
	
	public void grep(int n, String word) {
		q= new LinkedList<>();
		int count = 1;
		if(map.get(word) != null) {
			Set<String> temp = map.keySet();
			for (String string : temp) {
				if(string.equals(word)) {	
					q.add(string);
					break;
				}
				if(count>n) {
					q.poll();
				}
				q.add(string);
				count++;
			}
		}
		System.out.println(q);
	}
	
	public void poulateMap(String... str) {
		for(int i=0;i< str.length;i++) {
			map.put(str[i], i);
		}
	}
	
	public static void main(String[] args) {
		GrepCommad g = new GrepCommad();
		g.poulateMap("eg","aaa","bbb","ccc","fff","booking");
		g.grep(3, "ccc");
	}
}
