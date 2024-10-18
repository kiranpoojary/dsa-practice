package com.tuf.dp;

public class NinjaTraining {

    public static int getMaxTrainigPoint(int[][] tasks, int currentDay, int lastTaskNumber) {

        if (currentDay == 0) {
            int maxPoints = 0;
            for (int i = 0; i < tasks[0].length; i++) {
                if (i != lastTaskNumber)
                    maxPoints = Math.max(maxPoints, tasks[currentDay][i]);
            }
            return maxPoints;
        }

        int maxPoints = 0;
        for (int i = 0; i < tasks[0].length; i++) {
            if (i != lastTaskNumber) {
                int todaysPoints = tasks[currentDay][i] + getMaxTrainigPoint(tasks, currentDay - 1, i);
                maxPoints = Math.max(maxPoints, todaysPoints);
            }
        }
        return maxPoints;
    }

    public static void main(String[] args) {
        int[][] tasks = {
                { 2, 1, 2 },
                { 3, 4, 6 },
                { 10, 1, 6 },
                { 8, 3, 7 },
        };

        System.out.println("Max point can be earned    :" + getMaxTrainigPoint(tasks, 3, 3));
    }

}
