package com.chrzanop.coding.algoexpert.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TaskAssignment {

    // O(nlog(n) time | O(n) space - where n is the number of tasks
    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        ArrayList<ArrayList<Integer>> pairedTasks = new ArrayList<ArrayList<Integer>>();
        int left = 0;
        int right = tasks.size() - 1;

        HashMap<Integer, ArrayList<Integer>> taskDurationToIndices = getTaskDurationsToIndices(tasks);
        ArrayList<Integer> sortedTasks = tasks;
        Collections.sort(sortedTasks);

        while (left < right) {
            int task1 = sortedTasks.get(left);
            int task2 = sortedTasks.get(right);
            ArrayList<Integer> indicesWithTaskDuration1 = taskDurationToIndices.get(task1);
            int task1Idx = indicesWithTaskDuration1.remove(indicesWithTaskDuration1.size() - 1);

            ArrayList<Integer> indicesWithTaskDuration2 = taskDurationToIndices.get(task2);
            int task2Idx = indicesWithTaskDuration2.remove(indicesWithTaskDuration2.size() - 1);

            ArrayList<Integer> pairedTask = new ArrayList<Integer>();
            pairedTask.add(task1Idx);
            pairedTask.add(task2Idx);
            pairedTasks.add(pairedTask);
            left++;
            right--;
        }
        return pairedTasks;
    }

    private HashMap<Integer, ArrayList<Integer>> getTaskDurationsToIndices(ArrayList<Integer> tasks) {
        HashMap<Integer, ArrayList<Integer>> taskDurationToIndices = new HashMap<Integer, ArrayList<Integer>>();

        for (int idx = 0; idx < tasks.size(); idx++) {
            int taskDuration = tasks.get(idx);
            if (taskDurationToIndices.containsKey(taskDuration)) {
                taskDurationToIndices.get(taskDuration).add(idx);
            } else {
                ArrayList<Integer> indicies = new ArrayList<Integer>();
                indicies.add(idx);
                taskDurationToIndices.put(taskDuration, indicies);
            }
        }
        return taskDurationToIndices;

    }

}
