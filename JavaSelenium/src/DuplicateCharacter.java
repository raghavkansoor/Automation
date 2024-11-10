import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DuplicateCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name = "raghavendra";
	
		duplicate(name);
		reverseName(name);
		charCount(name);
		calculateVowels(name);
	}

	

	private static void duplicate(String name) {
		// TODO Auto-generated method stub
		char[] charArray = name.toCharArray();
		int counter;
		
		for(int i=0; i<charArray.length; i++) {
			counter= 1;
			for(int j=i+1; j<charArray.length; j++) {
				if(charArray[i] == charArray[j]) {
					counter++;
					charArray[j] = '0';
				}
			}
			if((counter > 1) && (charArray[i] !='0'))
				System.out.println(charArray[i]);
		}
		
		
		/*
		for(int i=0; i<name.length(); i++) {
			String output = "";
			char refVar = name.charAt(i);
			for(int j=0; j<name.length(); j++) {
				if(refVar == name.charAt(j)) {
					output += name.charAt(j);
					
				}
				
			}
			if(output.length() >1)
				System.out.println(output);
			
			
			
		}
*/		

	}
private static void charCount(String name) {
		
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
	//	for(hashMap.entrySet(); )
		System.out.println(hashMap);
	}


	private static void reverseName(String name) {
		// TODO Auto-generated method stub
		//name = "bababbabss";
		
		Scanner scanner  = new Scanner(System.in);
		name = scanner.next();
		String output = "";
		for(int i=name.length()-1; i>=0; i--) {
			output += name.charAt(i);
		}
		if(name.equalsIgnoreCase(output)) {
			System.out.println("String reverse not done");
		}
		else
			System.out.println(output);
	}


	private static void calculateVowels(String name) {
		// TODO Auto-generated method stub
		
		List list = new ArrayList();
		list.add('a');
		list.add('e');
		list.add('i');
		list.add('o');
		list.add('u');
		
		for(int i=0; i<name.length(); i++) {
			if(list.contains(name.charAt(i))){
				System.out.println("Vowels in input = "+name.charAt(i));
			}
			else
				System.out.println("Consonent ="+name.charAt(i));
		}
	}

}
