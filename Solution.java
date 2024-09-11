import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	
	public static void main(String args[]) {
		List<String> arr = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			arr.add("test" + i);
		}
//		for (String out: arr) {
//			System.out.println(out);
//			if (out.equals("test5")) {
//				break;
//			}
//		}
		
		arr.stream().mapToInt(i->Integer.parseInt(i.replace("test",""))).takeWhile(p->p<6).forEach(System.out::println);;
	}

}
