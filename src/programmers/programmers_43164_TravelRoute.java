package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class programmers_43164_TravelRoute {
	public static ArrayList<ArrayList<String>> arrAns = new ArrayList<>();

	public static void main(String[] args) {
		String[][] tickets1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		//solution(tickets1);
		//(Outputs) {ICN, JFK, HND, IAD}

		String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		solution(tickets2);
		//(Outputs) {ICN, ATL, ICN, SFO, ATL, SFO}
	}

    public static String[] solution(String[][] tickets) {
        String[] answer = new String[0];
        ArrayList<String> ans = new ArrayList<>();
        ans.add("ICN");		// 1번째 시작 공항
        
        HashMap<String, ArrayList<String>> tickMap = new HashMap<>();
        for(int i=0;i<tickets.length;i++) {		// <시작 공항, <연결된 공항 리스트>>
        	if(tickMap.containsKey(tickets[i][0])) {
        		tickMap.get(tickets[i][0]).add(tickets[i][1]);
        	} else {
        		tickMap.put(tickets[i][0], new ArrayList<>());
        		tickMap.get(tickets[i][0]).add(tickets[i][1]);
        	}
        }
        
        nextAirport("ICN", tickMap, ans);
        
        Collections.sort(arrAns, new Comparator<ArrayList<String>>() {		// 다중 정답(경로) 정렬
			@Override
			public int compare(ArrayList<String> arg0, ArrayList<String> arg1) {
				int size = arg0.size() < arg1.size() ? arg0.size() : arg1.size();
				
				for(int i=0;i<size;i++)
					if(!arg0.get(i).equals(arg1.get(i)))
						return arg0.get(i).compareTo(arg1.get(i));

				return arg0.get(size-1).compareTo(arg1.get(size-1));
			}
        });

        answer = new String[arrAns.get(0).size()];		// 정답 셋팅
        for(int i=0;i<arrAns.get(0).size();i++) {
        	answer[i] = arrAns.get(0).get(i);
        	System.out.print(answer[i] + "\t");
        }System.out.println();
        
        return answer;
    }
    
    public static void nextAirport(String now, HashMap<String, ArrayList<String>> tickMap, ArrayList<String> ans) {
//    	for(String key : tickMap.keySet()) {
//    		System.out.println(key);
//    		for(String value : tickMap.get(key))
//    			System.out.print(value + "\t");
//    		System.out.println("\n----------------------");
//    	}System.out.println("===========================");
    	
    	if(tickMap.size() == 0) {
    		arrAns.add(ans);
    		
//    		for(String s : ans)
//    			System.out.print(s + "\t");
//    		System.out.println("\n-------------------------");
    		
    		return;
    	}
    	
    	if(tickMap.get(now) == null)
    		return;

    	for(int i=0;i<tickMap.get(now).size();i++) {
    		String next = tickMap.get(now).get(i);
    		
    		HashMap<String, ArrayList<String>> copyMap = copyMap(tickMap);
    		copyMap.get(now).remove(next);	// 이용한 항공권 삭제
    		ArrayList<String> copyAns = copyList(ans);
    		
            if(copyMap.get(now).size() == 0)	// now에서 출발하는 항공권 모두 소진
            	copyMap.remove(now);
    		
            copyAns.add(next);		// 다음 공항 추가
            nextAirport(next, copyMap, copyAns);	// DFS로 이동경로 찾기
    	}
    }
    
    public static HashMap<String, ArrayList<String>> copyMap(HashMap<String, ArrayList<String>> oriMap) {
    	HashMap<String, ArrayList<String>> copy = new HashMap<>();
    	for(String key : oriMap.keySet()) {
    		ArrayList<String> copyArr = new ArrayList<>();
    		for(String arr : oriMap.get(key))
    			copyArr.add(arr);
    		copy.put(key, copyArr);
    	}
    	
    	return copy;
    }

    public static ArrayList<String> copyList(ArrayList<String> oriList) {
    	ArrayList<String> copy = new ArrayList<>();
    	for(int i=0;i<oriList.size();i++)
    		copy.add(oriList.get(i));
    	
    	return copy;
    }
}
