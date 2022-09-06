package com.li.everyday.july;

import java.util.PriorityQueue;

/**
 * 871. 最低加油次数
 * 汽车从起点出发驶向目的地，该目的地位于出发位置东面 target 英里处。
 * <p>
 * 沿途有加油站，每个 station[i] 代表一个加油站，它位于出发位置东面 station[i][0] 英里处，并且有 station[i][1] 升汽油。
 * <p>
 * 假设汽车油箱的容量是无限的，其中最初有 startFuel 升燃料。它每行驶 1 英里就会用掉 1 升汽油。
 * <p>
 * 当汽车到达加油站时，它可能停下来加油，将所有汽油从加油站转移到汽车中。
 * <p>
 * 为了到达目的地，汽车所必要的最低加油次数是多少？如果无法到达目的地，则返回 -1 。
 * <p>
 * 注意：如果汽车到达加油站时剩余燃料为 0，它仍然可以在那里加油。如果汽车到达目的地时剩余燃料为 0，仍然认为它已经到达目的地。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 1, startFuel = 1, stations = []
 * 输出：0
 * 解释：我们可以在不加油的情况下到达目的地。
 * 示例 2：
 * <p>
 * 输入：target = 100, startFuel = 1, stations = [[10,100]]
 * 输出：-1
 * 解释：我们无法抵达目的地，甚至无法到达第一个加油站。
 * 示例 3：
 * <p>
 * 输入：target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
 * 输出：2
 * 解释：
 * 我们出发时有 10 升燃料。
 * 我们开车来到距起点 10 英里处的加油站，消耗 10 升燃料。将汽油从 0 升加到 60 升。
 * 然后，我们从 10 英里处的加油站开到 60 英里处的加油站（消耗 50 升燃料），
 * 并将汽油从 10 升加到 50 升。然后我们开车抵达目的地。
 * 我们沿途在1两个加油站停靠，所以返回 2 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= target, startFuel, stations[i][1] <= 10^9
 * 0 <= stations.length <= 500
 * 0 < stations[0][0] < stations[1][0] < ... < stations[stations.length-1][0] < target
 * 通过次数21,181提交次数52,456
 */
public class MinRefuelStops871 {

    public static void main(String[] args) {
        MinRefuelStops871 main = new MinRefuelStops871();

//        int[][] ints = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
//        int[][] ints1 = {};
//        int i = main.minRefuelStops(100, 10, ints);
//        System.out.println(i);

//        1000
//        83
//                [[47,220],[65,1],[98,113],[126,196],[186,218],[320,205],[686,317],[707,325],[754,104],[781,105]]


        int[][] ints = {{47, 220}, {65, 1}, {98, 113}, {126, 196}, {186, 218}, {320, 205}, {686, 317}, {707, 325}, {754, 104}, {781, 105}};
        int[][] ints1 = {{13,21},{26,115},{100,47},{225,99},{299,141},{444,198},{608,190},{636,157},{647,255},{841,123}};
        int i = main.minRefuelStops(1000, 299, ints1);
        System.out.println(i);
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) return 0;
        if (stations.length == 0) return -1;
        int startPosition = 0;
        int curPositionIndex = 0;
        int maxOil = 0;
        int minCount = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < stations.length; i++) {
            if ((stations[i][0] - startPosition) <= startFuel) {
                if (maxOil < stations[i][1]) {
                    maxOil = stations[i][1];
                    queue.add(maxOil);
                    curPositionIndex = i;
                }
            } else {
                if (maxOil == 0) {
                    return -1;
                } else {
                    startFuel = startFuel + maxOil - (stations[curPositionIndex][0] - startPosition);
                    startPosition = stations[curPositionIndex][0];
                    i = curPositionIndex;
                    maxOil = 0;
                    curPositionIndex = 0;
                    minCount++;
                }
            }
        }

        if (target - startPosition <= startFuel) {
        } else {
            if (maxOil != 0) {
                startFuel += maxOil;
                minCount++;
            }
            if (target - startPosition > startFuel) {
                return -1;
            }
        }
        return minCount;
    }
}
