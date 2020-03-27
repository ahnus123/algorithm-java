package programmers;

import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;

public class programmers_17680_Cache {

	public static void main(String[] args) {
		int cacheSize1 = 3;
		String[] cities1 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		solution(cacheSize1, cities1);
		//(output) 50
		
		int cacheSize2 = 3;
		String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		solution(cacheSize2, cities2);
		//(output) 21
		
		int cacheSize3 = 2;
		String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		solution(cacheSize3, cities3);
		//(output) 60
		
		int cacheSize4 = 5;
		String[] cities4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		solution(cacheSize4, cities4);
		//(output) 52
		
		int cacheSize5 = 2;
		String[] cities5 = {"Jeju", "Pangyo", "NewYork", "newyork"};
		solution(cacheSize5, cities5);
		//(output) 16
		
		int cacheSize6 = 0;
		String[] cities6 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		solution(cacheSize6, cities6);
		//(output) 25
	}

	public static int solution(int cacheSize, String[] cities) {
		int answer = 0;
	    String[] cache = new String[cacheSize];
	    Queue<Pair<String, Integer>> latest = new LinkedList<Pair<String, Integer>>();
	    
	    if(cacheSize == 0) {
	    	answer =  cities.length * 5;
	    	return answer;
	    }
	      
	    for(int i=0;i<cities.length;i++) {
	    	cities[i] = cities[i].toUpperCase();			//소문자 > 대문자

	    	if(latest.size() < cacheSize) {					//빈 캐시 있으면
	    		answer += 5;
	    		for(int j=0;j<cache.length;j++) {
	    			if(cache[j] == null) {
	    				cache[j] = cities[i];				//캐시 업데이트
	    				latest.add(new Pair<String, Integer>(cities[i], j));		//최근 캐시 업데이트
	    				break;
	    			}
	    		}
	    	} else {
	    		Pair<String, Integer> out = latest.poll();	//최근 캐시 업데이트
	    		latest.add(new Pair<String, Integer>(cities[i], out.getValue()));
	    		
	    		if(isHit(cache, cities[i])) {				//캐시 hit
	    			answer += 1;
	    		} else {									//캐시 miss
	    			answer += 5;
		    		cache[out.getValue()] = cities[i];
	    		}
	    	}
	    	
	    	/*int size = latest.size();
	    	for(int j=0;j<size;j++) {
	    		Pair<String, Integer> now = latest.poll();
				System.out.print(now.getKey() + "-" + now.getValue() + "\t");
				latest.add(now);
	    	}System.out.println();
	    	
	    	for(int j=0;j<cache.length;j++) {
	    		System.out.print(cache[j] + "\t");
	    	}System.out.println();System.out.println();*/
	    }
	      
	    System.out.println("answer : " + answer);
	      
	    return answer;
	}
	
	public static boolean isHit(String[] cache, String city) {
		for(int i=0;i<cache.length;i++)
			if(cache[i].equals(city))
				return true;
		
		return false;
	}
}

