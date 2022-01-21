package programmers;

import java.util.ArrayList;

public class programmers_72410_RecommendANewID {
    public static void main(String[] args) {
        String ans1 = solution("...!@BaT#*..y.abcdefghijklm");
        System.out.println(ans1);
        //(Outputs) bat.y.abcdefghi

        String ans2 = solution("z-+.^.");
        System.out.println(ans2);
        //(Outputs) z--

        String ans3 = solution("=.=");
        System.out.println(ans3);
        //(Outputs) aaa

        String ans4 = solution("123_.def");
        System.out.println(ans4);
        //(Outputs) 123_.def

        String ans5 = solution("abcdefghijklmn.p");
        System.out.println(ans5);
        //(Outputs)abcdefghijklmn
    }

    public static String solution(String new_id) {
        String answer = "";

        // 1단계. new_id의 모든 대문자를 대응되는 소문자로 치환
        new_id = new_id.toLowerCase();
        ArrayList<Character> ans = new ArrayList<>();       // new_id - string to ArrayList<Character>
        for (int i = 0; i < new_id.length(); i++) {
            ans.add(new_id.charAt(i));
        }
        
        // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        for (int i = ans.size()-1; i >= 0; i--) {
            if (!((ans.get(i) >= 'a' && ans.get(i) <= 'z') || (ans.get(i) >= 'A' && ans.get(i) <= 'Z')
                || (ans.get(i) >= '0' && ans.get(i) <= '9') || ans.get(i) == '-'
                || ans.get(i) == '_' || ans.get(i) == '.')) {
                ans.remove(i);
            }
        }

        // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        int dotCnt = 0;
        for (int i = ans.size()-1; i >= 0; i--) {
            if (ans.get(i) == '.') {
                dotCnt++;
                if (dotCnt >= 2) {
                    ans.remove(i);
                }
            } else {
                dotCnt = 0;
            }
        }

        // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if (ans.get(0) == '.') {
            ans.remove(0);
        }
        if (ans.size() > 0 && ans.get(ans.size()-1) == '.') {
            ans.remove(ans.size()-1);
        }

        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if (ans.size() == 0) {
            ans.add('a');
        }

        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        int size = ans.size();
        if (ans.size() >= 16) {
            for (int i = size - 1; i >= 15; i--) {
                ans.remove(i);
            }
        }

        // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if (ans.get(ans.size()-1) == '.') {
            ans.remove(ans.size()-1);
        }

        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        int length = 3 - ans.size();
        char last = ans.get(ans.size()-1);
        if (ans.size() <= 2) {
            for (int i = 0; i < length; i++) {
                ans.add(last);
            }
        }

        for (int i = 0; i < ans.size(); i++) {
            answer = answer + ans.get(i);
        }
        return answer;
    }
}
