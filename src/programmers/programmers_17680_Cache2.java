
package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class programmers_17680_Cache2 {

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
	    Queue<String> strLatest = new LinkedList<String>();
	    Queue<Integer> intLatest = new LinkedList<Integer>();
	    
	    if(cacheSize == 0) {
	    	answer =  cities.length * 5;
	    	return answer;
	    }
	      
	    for(int i=0;i<cities.length;i++) {
	    	cities[i] = cities[i].toUpperCase();			//소문자 > 대문자

	    	if(strLatest.size() < cacheSize) {					//빈 캐시 있으면
	    		if(isHit(cache, cities[i])) {
	    			answer += 1;
	    			updateLatest(strLatest, intLatest, cities[i]);
	    		} else {
	    			answer += 5;
	    			for(int j=0;j<cache.length;j++) {
		    			if(cache[j] == null) {
		    				cache[j] = cities[i];				//캐시 업데이트
		    				strLatest.add(cities[i]);			//최근 캐시 업데이트
		    				intLatest.add(j);
		    				break;
		    			}
		    		}
	    		}
	    	} else {
	    		if(isHit(cache, cities[i])) {				//캐시 hit
	    			answer += 1;
	    			updateLatest(strLatest, intLatest, cities[i]);
	    		} else {									//캐시 miss
	    			answer += 5;
	    			updateCache(cache, strLatest, intLatest, cities[i]);
	    		}
	    	}
	    	
	    	/*int size = strLatest.size();
	    	for(int j=0;j<size;j++) {
	    		String strNow = strLatest.poll();
	    		int intNow = intLatest.poll();
				System.out.print(strNow + "-" + intNow + "\t");
				strLatest.add(strNow);
				intLatest.add(intNow);
	    	}System.out.println();
	    	
	    	for(int j=0;j<cache.length;j++) {
	    		System.out.print(cache[j] + "\t");
	    	}System.out.println();System.out.println();*/
	    }
	      
	    System.out.println("answer : " + answer);
	      
	    return answer;
	}
	
	public static boolean isHit(String[] cache, String city) {		//Hit 여부 체크
		for(int i=0;i<cache.length;i++)
			if(cache[i] != null && cache[i].equals(city))
				return true;
		
		return false;
	}
	
	//Miss > 캐시, 최근 캐시 업데이트
	public static void updateCache(String[] cache, Queue<String> strLatest, Queue<Integer> intLatest, String city) {
		strLatest.remove();
		strLatest.add(city);
		
		int last = intLatest.poll();
		intLatest.add(last);
		cache[last] = city;
	}
	
	//Hit > 최근 캐시 업데이트
	public static void updateLatest(Queue<String> strLatest, Queue<Integer> intLatest, String city) {
		int size = strLatest.size();
		String strHit = "";			int intHit = 0;
		for(int j=0;j<size;j++) {
			String strLast = strLatest.poll();
			int intLast = intLatest.poll();
			
			if(!strLast.equals(city)) {
				strLatest.add(strLast);		intLatest.add(intLast);
			} else {
				strHit = strLast;			intHit = intLast;
			}
		}
		strLatest.add(strHit);		intLatest.add(intHit);
	}
}

