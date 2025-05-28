package com.chrzanop.backbase;

import java.util.*;

public class MinimumCoins {

    public static void main(String[] args) {
        List<Integer> coins = Arrays.asList(1, 4, 5);

        System.out.println(minimumCoinTopDown(6, coins));

        System.out.println(minimumCoinMemoizeTopDown(7, coins, new HashMap<>()));

        System.out.println(minimumCoinBottomUp(5, coins));

        coins = Arrays.asList(1);

        System.out.println(minimumCoinTopDown(6, coins));
    }


    static int minIgnore(Integer a, Integer b) {
        if (a == null) return b;
        if (b == null) return a;
        return Math.min(a, b);
    }

    static int minimumCoinTopDown(int target, List<Integer> coins) {
        Integer answer = null;
        if (target == 0) {
            answer = 0;
        } else {
            for (int i = 0; i < coins.size(); i++) {
                int subProblem = target - coins.get(i);
                if (subProblem < 0) continue;
                int minimumCoinTopDown = minimumCoinTopDown(subProblem, coins);
                answer = minIgnore(answer, minimumCoinTopDown + 1);
            }
        }
        return answer;
    }

    static int minimumCoinMemoizeTopDown(int target, List<Integer> coins, Map<Integer, Integer> answers) {
        Integer answer = null;
        if (answers.get(target) != null) {
            return answers.get(target);
        }
        if (target == 0) {
            answer = 0;
        } else {
            for (int i = 0; i < coins.size(); i++) {
                int subProblem = target - coins.get(i);
                if (subProblem < 0) continue;
                answer = minIgnore(answer, minimumCoinMemoizeTopDown(subProblem, coins, answers) + 1);
            }
        }
        answers.put(target, answer);
        return answer;
    }

    static int minimumCoinBottomUp(int target, List<Integer> coins) {
        // target value <-> number of min coins
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 0);

        for (int currentTarget = 1; currentTarget < target + 1; currentTarget++) {
            for (int j = 0; j < coins.size(); j++) {
                int subProblem = currentTarget - coins.get(j);
                if (subProblem < 0) continue;
                Integer memoI = memo.get(currentTarget);
                Integer subProblemMemoized = memo.get(subProblem);
                memo.put(currentTarget, minIgnore(memoI, subProblemMemoized + 1));
            }

        }
        return memo.get(target);
    }
}
