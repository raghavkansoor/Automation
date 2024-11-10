import java.util.HashMap;

public class CharCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "raghavendra";
		
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();

		int counter = 0;
		for(int i=0; i<name.length(); i++) {
			
			if(hashMap.containsKey(name.charAt(i))) {
				counter = hashMap.get(name.charAt(i));
				hashMap.put(name.charAt(i), counter+1);
				
			}
			else
				hashMap.put(name.charAt(i), 1);
		}
		System.out.println(hashMap);
	}

}
