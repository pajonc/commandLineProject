package com.chrzanop.coding.algoexpert.stacks;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class CollidingAsteroids {


    // O(n) time | O(n) space
    public int[] collidingAsteroidsAlgo(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();

        for (int asteroid : asteroids) {

            if (stack.isEmpty() || asteroid > 0 || stack.peek()<0)  {
                stack.push(asteroid);
                continue;
            }

            while (!stack.isEmpty()) {

                if (stack.peek()<0) {
                    stack.push(asteroid);
                    break;
                }

                int asteroidSize = Math.abs(asteroid);

                if (stack.peek() > asteroidSize) {
                    break;
                }
                if (stack.peek() == asteroidSize) {
                    stack.pop();
                    break;
                }

                if(stack.peek() < asteroidSize) {
                    stack.pop();
                }

                if(stack.isEmpty()) {
                    stack.push(asteroid);
                    break;
                }
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }


    public int[] collidingAsteroids(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(asteroids[0]);
        stack.push(asteroids[1]);

        for (int i = 2; i < asteroids.length; i++) {
            int currentAsteroid = asteroids[i];
            int previousAsteroid = stack.peek();
            while (!stack.isEmpty()) {
                if (previousAsteroid > 0 && currentAsteroid < 0) {
                    if (previousAsteroid < Math.abs(currentAsteroid)) {
                        stack.pop();
                        previousAsteroid = stack.peek();
                    } else if (previousAsteroid == Math.abs(currentAsteroid)) {
                        // kill both
                        stack.pop();
                        currentAsteroid = 0;
                        break;
                    } else if (previousAsteroid > Math.abs(currentAsteroid)) {
                        // kill currentAsteroid
                        currentAsteroid = 0;
                        break;
                    }
                } else if (previousAsteroid < 0 && (currentAsteroid < 0 || currentAsteroid > 0)) {
                    break;
                } else if (previousAsteroid > 0 && currentAsteroid > 0) {
                    break;
                }

            }
            if (currentAsteroid != 0) stack.push(currentAsteroid);
        }

        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }

        //reverse
        int[] resultReversed = new int[result.length];
        int k = 0;
        for (int j = result.length - 1; j >= 0; j--) {
            resultReversed[k] = result[j];
            k++;
        }

        return resultReversed;
    }
}
