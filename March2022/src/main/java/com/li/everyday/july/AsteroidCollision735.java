package com.li.everyday.july;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 735. 行星碰撞
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 * <p>
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 * <p>
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 * 示例 2：
 * <p>
 * 输入：asteroids = [8,-8]
 * 输出：[]
 * 解释：8 和 -8 碰撞后，两者都发生爆炸。
 * 示例 3：
 * <p>
 * 输入：asteroids = [10,2,-5]
 * 输出：[10]
 * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= asteroids.length <= 104
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 * 通过次数53,599提交次数124,585
 */
public class AsteroidCollision735 {

    public static void main(String[] args) {
        AsteroidCollision735 main = new AsteroidCollision735();
        int[] asteroids = new int[]{5, 10, -5};
        int[] ints = main.asteroidCollision(asteroids);
    }

    public int[] asteroidCollision(int[] asteroids) {
        int length = asteroids.length;
        Deque<Integer> negaDqueue = new LinkedList<Integer>();
        Deque<Integer> posiDqueue = new LinkedList<Integer>();
        ArrayList<Integer> arrayList = new ArrayList<>();


        for (int i = 0; i < length; i++) {
            if (asteroids[i] < 0) {
                boolean flag = true;
                if (posiDqueue.size()==0)negaDqueue.addLast(asteroids[i]);

                while (posiDqueue.size() != 0) {
                    Integer positive = posiDqueue.peekLast();
                    if (positive + asteroids[i] > 0) {
                        flag = false;
                    } else if (positive + asteroids[i] == 0) {
                        posiDqueue.pollLast();
                    } else if (positive + asteroids[i] < 0) {
                        negaDqueue.addLast(asteroids[i]);
                    }
                }
                if (flag) arrayList.add(asteroids[i]);
            } else if (asteroids[i] == 0) {
                continue;
            } else if (asteroids[i] > 0) {
                if (negaDqueue.size()==0)posiDqueue.addLast(asteroids[i]);
                while (negaDqueue.size() != 0) {
                    Integer negative = negaDqueue.peekLast();
                    if (negative + asteroids[i] > 0) {
                        negaDqueue.pollLast();
                    } else if (negative + asteroids[i] == 0) {
                        negaDqueue.pollLast();
                    } else if (negative + asteroids[i] < 0) {
                    }
                }
            }
        }
        System.out.println();

        return null;
    }
}
