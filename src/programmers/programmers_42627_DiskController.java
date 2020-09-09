package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Job implements Comparable<Job>{
	int startTime;
	int workTime;
	
	public Job(int startTime, int workTime) {
		this.startTime = startTime;
		this.workTime = workTime;
	}
	
	@Override
	public int compareTo(Job j) {
		return this.workTime - j.workTime;
	}
}

public class programmers_42627_DiskController {

	public static void main(String[] args) {
		int[][] jobs1 = {{0, 3}, {1, 9}, {2, 6}};
		solution(jobs1);
		//(output) 9
		
		int[][] jobs2 = {{0, 9}, {0, 4}, {0, 5}, {0, 7}, {0, 3}};
		//solution(jobs2);
		//(output) 13
		
		int[][] jobs3 = {{1, 9}, {1, 4}, {1, 5}, {1, 7}, {1, 3}};
		//solution(jobs3);
		//(output) 13
		
		int[][] jobs4 = {{0, 3}, {1, 9}, {500, 6}};
		//solution(jobs4);
		//(output) 6
		
		int[][] jobs5 = {{24, 10}, {18, 39}, {34, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 2}, {15, 34}, {35, 43}, {26, 1}};
		//solution(jobs5);
		//(output) 74
		
		int[][] jobs6 = {{24, 10}, {18, 39}, {34, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};
		//solution(jobs6);
		//(output) 74
		
	}

	public static int solution(int[][] jobs) {
        int answer = 0;
        ArrayList<Job> sortJobs = new ArrayList<>();
        
        for(int i=0;i<jobs.length;i++) {	//Job 자료형으로 변환 + ArrayList에 담
        	Job job = new Job(jobs[i][0], jobs[i][1]);
        	sortJobs.add(job);
        }

        Collections.sort(sortJobs, new Comparator<Job>() {	//작업시작시간 기준으로 정렬
			public int compare(Job j1, Job j2) {
				if(j1.startTime != j2.startTime)
					return j1.startTime - j2.startTime;
				else
					return j1.workTime - j2.workTime;
			}
        });
        
        /*for(int i=0;i<sortJobs.size();i++)
        	System.out.println(sortJobs.get(i).startTime + " - " + sortJobs.get(i).workTime);*/
        
        Job nowJob = sortJobs.get(0);
        int jobEndTime = sortJobs.get(0).startTime + sortJobs.get(0).workTime;
        answer += sortJobs.get(0).workTime;
        sortJobs.remove(0);
        
        //System.out.println("ans : " + answer + " / endTime : " + jobEndTime);
        
    	PriorityQueue<Job> pq = new PriorityQueue<>();	//우선순위 큐
        while(!(pq.isEmpty() && sortJobs.size() == 0)) {
        	//우선순위 큐에 (현재 ~ 현재 작업 끝) 시간 안에 시작하는 작업들 추가
        	for(int i=sortJobs.size()-1;i>=0;i--) {
        		if(sortJobs.get(i).startTime <= jobEndTime) {
        			pq.add(sortJobs.get(i));
        			sortJobs.remove(i);
        		}
        	}
        	
        	//pq = printPq(pq);
        	
        	if(!pq.isEmpty()) {		//다음 작업 있으면 실행
        		Job nextJob = pq.poll();
            	answer += jobEndTime - nextJob.startTime + nextJob.workTime;
            	jobEndTime += nextJob.workTime;
        	} else {		//없으면 시간+1
        		jobEndTime++;
        	}
        	//System.out.println("ans : " + answer + " / endTime : " + jobEndTime);
        }
        
        answer /= jobs.length;
        
        System.out.println(answer);
        return answer;
    }
	
	public static PriorityQueue printPq(PriorityQueue<Job> pq) {	//print PriorityQueue 
		PriorityQueue<Job> pq2 = new PriorityQueue<>();
		while(!pq.isEmpty()) {
			Job j = pq.poll();
			System.out.println(j.startTime + " / " + j.workTime);
			pq2.add(j);
		}
		return pq2;
	}
}
