import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class BalancedParantesis {

	static Map<Character, Character> mapChars = new HashMap<>();
	static Set<Character> set =new HashSet<>();
	static {
		mapChars.put('(', ')');
		mapChars.put('{', '}');
		mapChars.put('[', ']');
		set.add('(');
		set.add(')');
		set.add('{');
		set.add('}');
		set.add('[');
		set.add(']');
	}

	public static void main(String[] args) {
		String str = "(kjds(hfkj)sdhf)";
		System.out.println(foo(str));
	}
	
	public static boolean foo(String str) {
		Stack<Character> temp = new Stack<>();
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if(set.contains(chars[i])) {
				if (mapChars.get(chars[i]) != null) {
					temp.push(mapChars.get(chars[i]));
				}else {
					if(temp.isEmpty()) {
						return false;
					}else if(temp.pop() != chars[i]) {
						return false;
					}
				}
				
			}
			
		}
		if(temp.isEmpty()) {
			return true;
		}
		return false;
	}

}
