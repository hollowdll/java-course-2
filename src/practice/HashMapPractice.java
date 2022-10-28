package practice;

import java.util.Map;
import java.util.HashMap;

class HashMapPractice {

	public static void main(String[] args) {
		
		Map<String, Integer> myHashMap1 = new HashMap<String, Integer>();
		
		myHashMap1.put("C", 3);
		myHashMap1.put("A", 1);
		myHashMap1.put("D", 4);
		myHashMap1.put("B", 2);
		myHashMap1.put("B", 3);
		
		myHashMap1.replace("A", 5);
		
		for (String k : myHashMap1.keySet()) {
			System.out.println("Key: " + k + " Value: " + myHashMap1.get(k));
		}
	}

}
