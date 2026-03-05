package problem3;

import java.util.Arrays;

public class Solution {

    /**
     * 문제 설명
     *
     * 사용자 세션 로그가 다음과 같은 형식으로 주어집니다.
     *
     * "start end"
     *
     * start: 접속 시작 시간
     * end: 접속 종료 시간
     *
     * 예:
     * "1 5"
     * "2 6"
     * "4 8"
     *
     * 동시에 접속한 최대 사용자 수를 구하세요.
     *
     * 예:
     *
     * 입력:
     * [
     *   "1 5",
     *   "2 6",
     *   "4 8"
     * ]
     *
     * 시간 흐름:
     *
     * 1 → user1 접속 (1명)
     * 2 → user2 접속 (2명)
     * 4 → user3 접속 (3명)
     *
     * 최대 동시 접속자 = 3
     */
    public int maxConcurrentSessions(String[] sessions) {

        // TODO 구현
        // 접속 종료 시간 중에 가장 큰 시간을 찾아서 배열로 만들까? .. 근데 종료시간에 범위가 안나와있어. 근데 시간이라고 한거보면 24까지겠지?

        int[] sessionArr = new int[25];
        for (String session : sessions) {
            int idx = session.charAt(' ');
            int s = Integer.parseInt(session.substring(0, idx));
            int e = Integer.parseInt(session.substring(idx+1));
            for(int i = s; i <= e; i++){
                sessionArr[i]++;
            }
        }

        Arrays.sort(sessionArr);
        return sessionArr[24];
    }
}
