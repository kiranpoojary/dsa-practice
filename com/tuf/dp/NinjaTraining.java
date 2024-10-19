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

    public static int getMaxTrainigPointRecursiveMemo(int[][] tasks, int currentDay, int lastTaskNumber, int[][] memo) {
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
                        + getMaxTrainigPointRecursiveMemo(tasks, currentDay - 1, currentTaskNumber, memo);
                maxPoints = Math.max(maxPoints, todaysPoints);
            }
        }
        memo[currentDay][lastTaskNumber] = maxPoints;
        return maxPoints;
    }

    public static int getMaxTrainigPointRecursiveMemoStart(int[][] tasks, int currentDay, int lastTaskNumber) {
        int totalDaysOfTraining = tasks.length;
        int totalUniqueTask = tasks[0].length;
        int[][] memo = new int[totalDaysOfTraining + 1][totalUniqueTask + 1];// +1 just to avoid outofbound
        for (int i = 0; i < memo[0].length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return getMaxTrainigPointRecursiveMemo(tasks, currentDay, lastTaskNumber, memo);
    }

    public static int getMaxTrainigPointTabulation(int[][] tasks) {
        int totalDaysOfTraining = tasks.length;
        int totalUniqueTask = tasks[0].length;
        int[][] dp = new int[totalDaysOfTraining + 1][totalUniqueTask + 1];

        // Initialize the first day's maximum points based on the available choices
        dp[0][0] = Math.max(tasks[0][1], tasks[0][2]);
        dp[0][1] = Math.max(tasks[0][0], tasks[0][2]);
        dp[0][2] = Math.max(tasks[0][0], tasks[0][1]);
        dp[0][3] = Math.max(tasks[0][0], Math.max(tasks[0][1], tasks[0][2]));

        // Iterate through each day and each activity
        for (int day = 1; day < totalDaysOfTraining; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0; // Initialize the maximum points for the current day and last activity
                // Consider each possible task for the current day
                for (int task = 0; task <= 2; task++) {
                    if (task != last) { // Ensure that the current task is different from the last
                        // Calculate the points for the current activity and add it to the maximum
                        // points from the previous day
                        int activity = tasks[day][task] + dp[day - 1][task];
                        // Update the maximum points for the current day and last activity
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
        }

        // Return the maximum points achievable after all days (last activity is 3)
        return dp[totalDaysOfTraining - 1][3];
    }

    public static int getMaxTrainigPointTabulationSpaceOptimizaed(int[][] tasks) {
        int totalDaysOfTraining = tasks.length;
        int totalUniqueTask = tasks[0].length;

        // Initialize an array 'prev' to store the maximum points for the previous day
        int prev[] = new int[4];

        // Initialize the first day's maximum points based on the available choices
        prev[0] = Math.max(tasks[0][1], tasks[0][2]);
        prev[1] = Math.max(tasks[0][0], tasks[0][2]);
        prev[2] = Math.max(tasks[0][0], tasks[0][1]);
        prev[3] = Math.max(tasks[0][0], Math.max(tasks[0][1], tasks[0][2]));

        // Iterate through each day starting from the second day
        for (int day = 1; day < totalDaysOfTraining; day++) {
            // Initialize an array 'temp' to store the maximum points for the current day
            int temp[] = new int[totalDaysOfTraining];
            for (int last = 0; last < totalDaysOfTraining; last++) {
                temp[last] = 0; // Initialize the maximum points for the current day and last activity
                // Consider each possible task for the current day
                for (int task = 0; task <= 2; task++) {
                    if (task != last) { // Ensure that the current task is different from the last
                        // Calculate the points for the current activity and add it to the maximum
                        // points from the previous day
                        temp[last] = Math.max(temp[last], tasks[day][task] + prev[task]);
                    }
                }
            }
            // Update 'prev' to store the maximum points for the current day
            prev = temp;
        }

        // Return the maximum points achievable after all days (last activity is 3)
        return prev[3];
    }

    public static void main(String[] args) {
        int[][] tasks = {
                { 2, 1, 2 },
                { 3, 4, 6 },
                { 10, 1, 6 },
                { 8, 3, 7 },
        };

        System.out
                .println("Max point can be earned(recursive)                :"
                        + getMaxTrainigPointRecursive(tasks, tasks[0].length, tasks[0].length));
        System.out
                .println("Max point can be earned(recursive+meoization)               :"
                        + getMaxTrainigPointRecursiveMemoStart(tasks, tasks[0].length, tasks[0].length));
        System.out
                .println("Max point can be earned(tabulation)               :"
                        + getMaxTrainigPointTabulation(tasks));
        System.out
                .println("Max point can be earned(tabulation-space opti)    :"
                        + getMaxTrainigPointTabulationSpaceOptimizaed(tasks));
    }

}
