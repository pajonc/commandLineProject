package com.chrzanop.coding.algoexpert.recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class LowestCommonManager {


    static OrgChart lowestCommonManager = null;

    public static OrgChart getLowestCommonManager(
            OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {

        getLowestCommonManagerHelper(topManager, reportOne, reportTwo);

        return lowestCommonManager;

    }


    private static int getLowestCommonManagerHelper(
            OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {

        if (topManager.directReports.size() == 0) {
            if (topManager.name == reportOne.name || topManager.name == reportTwo.name) {
                return 1;
            } else {
                return 0;
            }
        }

        int numberOfReports = 0;
        for (OrgChart directReport : topManager.directReports) {
            numberOfReports += getLowestCommonManagerHelper(directReport, reportOne, reportTwo);
            if (numberOfReports == 2) {
                lowestCommonManager = directReport;
                return numberOfReports;
            }
        }
        return numberOfReports;

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

}
