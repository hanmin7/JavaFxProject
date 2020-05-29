package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {
	
	public static void getMap(Map<Integer,String> map) {
		Set<Integer> set = map.keySet();
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			Integer num = iter.next();
			if(num>=80) {
				String val = map.get(num);
				System.out.println(val);
			}
			
		}
	}
	
	public static void main(String[] args) {
		Map<Integer, String> scores = new HashMap<>();
		scores.put(90, "Hong");
		scores.put(78, "Hwang");
		scores.put(80, "Park");
		
		System.out.println("80이상인 학생");
		getMap(scores);
		System.out.println("=============");
		
		
		List<String> list = new ArrayList<>();
		list.add("Hong");
		list.get(0);
		
		Set<String> set = new HashSet<>();
		set.add("Hong");
		set.add("Hwang");
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String str = iterator.next();
			System.out.println(str.toString());
		}
		
		Map<String, Integer> map = new HashMap<>();
		//key:value -> Map.Entry
		map.put("Hong", 98);
		map.put("Hwang", 90);
		map.put("Hong", 80);
		
		Set<String> ketSet = map.keySet();
		Iterator<String> keyItor = ketSet.iterator();
		while(keyItor.hasNext()) {
			String key = keyItor.next();
			Integer value = map.get(key); //key에 해당하는 값을 가져옴
			System.out.println("key: " + key + ", value: " + value);
			//같은이름 값이 있으면 하나만 나옴. (홍은 "Hong",80만 출력됨.)
		}
		
		Set<Entry<String, Integer>> entSet = map.entrySet();
		Iterator<Entry<String, Integer>> entIter = entSet.iterator();
		while(entIter.hasNext()) {
			Entry<String, Integer> entry = entIter.next();
			String key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println("key: " + key + ", value: " + val);
		}
	}
}
