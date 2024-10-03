package com.chrzanop.coding.algoexpert.recursion;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class LowestCommonManager {


    // O(n) time | O(d) space where d is number of call stack size at maximum depth of tree and n is the number of tree vertices
     public static OrgChart getLowestCommonManager(
            OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {

        OrgInfo orgInfo = getLowestCommonManagerHelper(topManager, reportOne, reportTwo);

        return orgInfo.lowestCommonManager;

    }


    private static OrgInfo getLowestCommonManagerHelper(
            OrgChart manager, OrgChart reportOne, OrgChart reportTwo) {

        int numberOfReports = 0;
        for (OrgChart directReport : manager.directReports) {
            OrgInfo orgInfo = getLowestCommonManagerHelper(directReport, reportOne, reportTwo);
            if (orgInfo.lowestCommonManager != null) {
                return orgInfo;
            }
            numberOfReports += orgInfo.numberOfReports;
        }
        System.out.println(manager.name);
        if (manager == reportOne || manager == reportTwo) {
            numberOfReports++;
        }

        OrgChart lowestCommonManager = numberOfReports == 2 ? manager : null;
        OrgInfo orgInfo = new OrgInfo(lowestCommonManager, numberOfReports);

        return orgInfo;
    }


    static class OrgChart {
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<OrgChart>();
        }

        // This method is for testing only.
        public void addDirectReports(OrgChart[] directReports) {
            for (OrgChart directReport : directReports) {
                this.directReports.add(directReport);
            }
        }
    }

    static class OrgInfo {
        public OrgChart lowestCommonManager;
        public int numberOfReports = 0;

        OrgInfo(OrgChart lowestCommonManager, int numberOfReports) {
            this.lowestCommonManager = lowestCommonManager;
            this.numberOfReports = numberOfReports;
        }
    }

    @Test
    public void shouldPassCheck() {
        HashMap<Character, OrgChart> orgCharts = getOrgCharts();
        orgCharts
                .get('A')
                .addDirectReports(new OrgChart[]{orgCharts.get('B'), orgCharts.get('C')});
        orgCharts
                .get('B')
                .addDirectReports(new OrgChart[]{orgCharts.get('D'), orgCharts.get('E')});
        orgCharts
                .get('C')
                .addDirectReports(new OrgChart[]{orgCharts.get('F'), orgCharts.get('G')});
        orgCharts
                .get('D')
                .addDirectReports(new OrgChart[]{orgCharts.get('H'), orgCharts.get('I')});

        OrgChart lcm =
                getLowestCommonManager(orgCharts.get('A'), orgCharts.get('E'), orgCharts.get('I'));
        assertTrue(lcm == orgCharts.get('B'));

        System.out.println("--------------------------");

    }


    public HashMap<Character, OrgChart> getOrgCharts() {
        HashMap<Character, OrgChart> orgCharts = new HashMap<Character, OrgChart>();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (char a : alphabet.toCharArray()) {
            orgCharts.put(a, new OrgChart(a));
        }
        orgCharts.get('X').addDirectReports(new OrgChart[]{orgCharts.get('Z')});
        return orgCharts;
    }

    /*
        public static OrgChart getLowestCommonManagerIterative(
            OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {

        OrgInfo orgInfo = getLowestCommonManagerHelperIterative(topManager, reportOne, reportTwo);

        return orgInfo.lowestCommonManager;
    }

    // not working due to wrong numberOfReports counter
    private static OrgInfo getLowestCommonManagerHelperIterative(
            OrgChart manager, OrgChart reportOne, OrgChart reportTwo) {

        Deque<OrgChart> orgChartsStack = new LinkedList<>();
        orgChartsStack.push(manager);
        OrgInfo orgInfo = new OrgInfo(null, 0);
        int numberOfReports = 0;
        while (!orgChartsStack.isEmpty()) {
            System.out.println(manager.name);
            if (orgInfo.lowestCommonManager != null) {
                return orgInfo;
            }
            if (manager == reportOne || manager == reportTwo) {
                numberOfReports++;
            }

            for (int i = manager.directReports.size()-1; i >=0 ; i--) {
                orgChartsStack.push(manager.directReports.get(i));

            }

            OrgChart lowestCommonManager = numberOfReports == 2 ? manager : null;
            orgInfo = new OrgInfo(lowestCommonManager, numberOfReports);

            manager = orgChartsStack.pop();
        }


        return orgInfo;
    }


     */


}
