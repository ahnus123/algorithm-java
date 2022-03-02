package programmers;

import java.util.*;

public class programmers_92334_GetTheReportResult {
    public static void main(String[] args) {
        String[] id_list1 = {"muzi", "frodo", "apeach", "neo"};
        String[] report1 = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int[] ans1 = solution(id_list1, report1, 2);
        printAns(ans1);
        // (Outputs) {2,1,1,0}

        String[] id_list2 = {"con", "ryan"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int[] ans2 = solution(id_list2, report2, 3);
        printAns(ans2);
        // (Outputs) {0,0}
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, HashSet<String>> reports = new HashMap<>();     // <신고된 유저, 신고한 유저들>

        for (int i = 0; i < report.length; i++) {
            String[] split = report[i].split(" ");
            HashSet<String> reporters = new HashSet<>(); // 신고자 리스트
            if (reports.containsKey(split[1])) {        // 이미 신고당한 이력이 있을 때
                reporters = reports.get(split[1]);
                reporters.add(split[0]);
                reports.put(split[1], reporters);
            } else {        // 최초 신고일 경우
                reporters.add(split[0]);
                reports.put(split[1], reporters);
            }
        }

        Set<String> keySet = reports.keySet();
        for (String key : keySet) {
            HashSet<String> reporters = reports.get(key);
            if (reporters.size() >= k) {     // k번 이상 신고당한 경우
                answer = sendEmail(answer, id_list, reporters);
            }

//            System.out.println(" -> " + key + " <-");
//            for (String s : reporters) {
//                System.out.println(s);
//            }
        }

        return answer;
    }

    // 신고자에게 메일 전송
    public static int[] sendEmail(int[] answer, String[] id_list, HashSet<String> reporters) {
        for (String reporter : reporters) {
            for (int i = 0; i < id_list.length; i++) {
                if (reporter.equals(id_list[i])) {
                    answer[i]++;
                    break;
                }
            }
        }

        return answer;
    }

    public static void printAns(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }System.out.println();
    }
}


