package problem2;

import java.util.*;

public class Solution {

    /**
     * 문제 설명
     *
     * 상품 주문 로그가 다음과 같은 형식으로 주어집니다.
     *
     * "userId productName"
     *
     * 예:
     * "u1 apple"
     * "u2 banana"
     * "u1 apple"
     *
     * 가장 많이 주문된 상품 상위 k개를 반환하세요.
     *
     * 반환 형식:
     * List<String>
     *
     * 정렬 기준:
     * 1. 주문 횟수 내림차순
     * 2. 주문 횟수가 같으면 상품 이름 오름차순
     *
     * 예:
     *
     * 입력:
     * orders = [
     *   "u1 apple",
     *   "u2 banana",
     *   "u3 apple",
     *   "u4 orange",
     *   "u5 banana"
     * ]
     *
     * k = 2
     *
     * 결과:
     * ["apple", "banana"]
     */
    public List<String> topKProducts(String[] orders, int k) {

        // TODO 구현
        Map<String, Product> map = new HashMap<>();
        for (String order : orders) {
            String productName = order.substring(order.indexOf(' ')+1);
            Product product = map.computeIfAbsent(productName, p -> new Product(productName));
            product.increaseCount();
        }

        List<Product> products = map.values().stream().toList();
        return products.stream()
                .sorted(
                        Comparator.comparing(Product::getCount).reversed()
                                .thenComparing(Product::getName))
                .map(Product::getName)
                .limit(k)
                .toList();
    }
    static class Product {
        private String name;
        private int count;

        public Product(String name){
            this.name = name;
        }
        private void increaseCount() {
            count++;
        }

        private String getName() {
            return name;
        }

        private int getCount() {
            return count;
        }
    }
}
