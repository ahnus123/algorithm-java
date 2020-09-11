package programmers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class programmers_17680_Cache3 {

	public static void main(String[] args) {
		int cacheSize1 = 3;
		String[] cities1 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		//solution(cacheSize1, cities1);
		//(output) 50
		
		int cacheSize2 = 3;
		String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		//solution(cacheSize2, cities2);
		//(output) 21
		
		int cacheSize3 = 2;
		String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		//solution(cacheSize3, cities3);
		//(output) 60
		
		int cacheSize4 = 5;
		String[] cities4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		//solution(cacheSize4, cities4);
		//(output) 52
	
		int cacheSize5 = 2;
		String[] cities5 = {"Jeju", "Pangyo", "NewYork", "newyork"};
		//solution(cacheSize5, cities5);
		//(output) 16
		
		int cacheSize6 = 0;
		String[] cities6 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		solution(cacheSize6, cities6);
		//(output) 25
		
		int cacheSize7 = 0;
		String[] cities7 = {"SEOUL", "SEOUL", "SEOUL"};
		solution(cacheSize7, cities7);
		//(output) 7
		
	}
	
	public static int solution(int cacheSize, String[] cities) {
		int answer = 0;
		Map<String, Integer> cache = new HashMap<>();
		
		for(int i=0;i<cities.length;i++)		//전부 대문자로 변환
			cities[i] = cities[i].toUpperCase();
		
		if(cacheSize == 0) {
			answer = cities.length * 5;
		} else {
			for(int i=0;i<cities.length;i++) {
				if(cache.containsKey(cities[i])) {		//캐시 hit
					cache.put(cities[i], i);
					answer += 1;
				} else {		//캐시 miss
					if(cache.size() == 0) {
						cache.put(cities[i], i);
					} else if(cache.size() < cacheSize) {		//캐시 다 안찼을 때
						cache.put(cities[i], i);
					} else {		//캐시 다 찼을 때
						cache = removeOldest(cache);
						cache.put(cities[i], i);
					}
					answer += 5;
				}
			}
		}
		
		System.out.println(answer);
		return answer;
	}
	
	public static Map<String, Integer> removeOldest(Map<String, Integer> cache) {
		int min = 100001;
		
		Collection<Integer> times = cache.values();
		Iterator<Integer> it = times.iterator();
		while(it.hasNext()) {
			int now = it.next();
			if(now < min) {
				min = now;
			}
		}
		
		for(String key : cache.keySet()) {
			if(cache.get(key) == min) {
				cache.remove(key);
				break;
			}
		}
		
		return cache;
	}
}
