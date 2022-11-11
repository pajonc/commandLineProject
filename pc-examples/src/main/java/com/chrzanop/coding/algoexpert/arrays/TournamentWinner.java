package com.chrzanop.coding.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> competitions = new ArrayList<ArrayList<String>>();
        ArrayList<String> competition1 = new ArrayList<String>(Arrays.asList("HTML", "C#"));
        ArrayList<String> competition2 = new ArrayList<String>(Arrays.asList("C#", "Python"));
        ArrayList<String> competition3 = new ArrayList<String>(Arrays.asList("Python", "HTML"));
        competitions.add(competition1);
        competitions.add(competition2);
        competitions.add(competition3);
        ArrayList<Integer> results = new ArrayList<Integer>(Arrays.asList(0, 0, 1));
        String expected = "Python";

        String winner = tournamentWinner(competitions, results);

        System.out.println(expected.equals(winner));
    }

    /*
    O(n) time - refers to loop so number of competitions | O(k) space - k refers to number of scores created in hash map
     */
    public static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

        int resultsIdx = 0;
        Map<String, Integer> scores = new HashMap<>();
        int TEAM_WON = 1;
        String bestTeam = "";
        scores.put(bestTeam, 0);
        String winningTeam = null;

        for (ArrayList<String> competition : competitions) {
            int outcome = results.get(resultsIdx);
            winningTeam = outcome == TEAM_WON ? competition.get(0) : competition.get(1);
            updateTeamToPoint(winningTeam, scores, 3);
            if (scores.get(winningTeam) > scores.get(bestTeam)) {
                bestTeam = winningTeam;
            }
            resultsIdx++;
        }
        return bestTeam;

    }


    public static void updateTeamToPoint(String team, Map<String, Integer> scores, int points) {
        if (!scores.containsKey(team)) {
            scores.put(team, 0);
        } else {
            scores.put(team, scores.get(team) + points);
        }
    }

}
