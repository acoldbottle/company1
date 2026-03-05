package problem1;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 문제 설명
     *
     * 로그 데이터가 다음과 같은 형식으로 주어집니다.
     *
     * "userId action"
     *
     * 예:
     * "u1 login"
     * "u2 logout"
     * "u1 login"
     *
     * 각 사용자별로 action이 몇 번 발생했는지 집계하여 반환하세요.
     *
     * 반환 형식:
     * Map<userId, Map<action, count>>
     *
     * 예:
     *
     * 입력:
     * [
     *   "u1 login",
     *   "u2 login",
     *   "u1 logout",
     *   "u1 login"
     * ]
     *
     * 결과:
     * {
     *   "u1": { "login": 2, "logout": 1 },
     *   "u2": { "login": 1 }
     * }
     */
    public Map<String, Map<String, Integer>> aggregateActions(String[] logs) {

        // TODO 구현
        Map<String, Map<String, Integer>> map = new HashMap<>();
        for (String log : logs) {
            String[] arr = log.split(" ");
            String user = arr[0];
            String action = arr[1];

            Map<String, Integer> actionMap = map.computeIfAbsent(user, k -> new HashMap<>());
            actionMap.put(action, actionMap.getOrDefault(action, 0)+1);
        }

        return map;
    }
}
