package com.tuf.dp;

import java.util.Arrays;

public class NinjaTraining {

    public static int getMaxTrainigPointRecursive(int[][] tasks, int currentDay, int lastTaskNumber) {
        if (currentDay == 0) {
            int maxPoints = 0;
            for (int currentTaskNumber = 0; currentTaskNumber < tasks[0].length; currentTaskNumber++) {
                if (currentTaskNumber != lastTaskNumber)
                    maxPoints = Math.max(maxPoints, tasks[currentDay][currentTaskNumber]);
            }
            return maxPoints;
        }

        int maxPoints = 0;
        for (int currentTaskNumber = 0; currentTaskNumber < tasks[0].length; currentTaskNumber++) {
            if (currentTaskNumber != lastTaskNumber) {
                int todaysPoints = tasks[currentDay][currentTaskNumber]
                        + getMaxTrainigPointRecursive(tasks, currentDay - 1, currentTaskNumber);
                maxPoints = Math.max(maxPoints, todaysPoints);
            }
        }
        return maxPoints;
    }

    public static int getMaxTrainigPointMemo(int[][] tasks, int currentDay, int lastTaskNumber, int[][] memo) {
        if (currentDay == 0) {
            int maxPoints = 0;
            for (int currentTaskNumber = 0; currentTaskNumber < tasks[0].length; currentTaskNumber++) {
                if (currentTaskNumber != lastTaskNumber)
                    maxPoints = Math.max(maxPoints, tasks[currentDay][currentTaskNumber]);
            }
            return maxPoints;
        }
        if (memo[currentDay][lastTaskNumber] != -1)
            return memo[currentDay][lastTaskNumber];

        int maxPoints = 0;
        for (int currentTaskNumber = 0; currentTaskNumber < tasks[0].length; currentTaskNumber++) {
            if (currentTaskNumber != lastTaskNumber) {
                int todaysPoints = tasks[currentDay][currentTaskNumber]
                        + getMaxTrainigPointMemo(tasks, currentDay - 1, currentTaskNumber, memo);
                maxPoints = Math.max(maxPoints, todaysPoints);
            }
        }
        memo[currentDay][lastTaskNumber] = maxPoints;
        return maxPoints;
    }

    public static int getMaxTrainigPointMemoStart(int[][] tasks, int currentDay, int lastTaskNumber) {
        int totalDaysOfTraining = tasks.length;
        int totalUniqueTask = tasks[0].length;
        int[][] memo = new int[totalDaysOfTraining + 1][totalUniqueTask + 1];// +1 just to avoid outofbound
        for (int i = 0; i < memo[0].length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return getMaxTrainigPointMemo(tasks, currentDay, lastTaskNumber, memo);
    }

    public static void main(String[] args) {
        int[][] tasks = {
                { 2, 1, 2 },
                { 3, 4, 6 },
                { 10, 1, 6 },
                { 8, 3, 7 },
        };

        System.out
                .println("Max point can be earned(recursive)    :"
                        + getMaxTrainigPointRecursive(tasks, tasks[0].length, tasks[0].length));
        System.out
                .println("Max point can be earned(meoization)   :"
                        + getMaxTrainigPointMemoStart(tasks, tasks[0].length, tasks[0].length));
    }

}
