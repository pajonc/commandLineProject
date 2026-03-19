package com.chrzanop.coding.algoexpert.greedy;

import java.math.BigDecimal;

public class ValidStartingCity {

    // O(n^2) time | O(n) space- where n is the number of cities
    public int validStartingCity(int[] distances, int[] fuel, int mpg) {

        int numberOfCities = distances.length;

        for (int city = 0; city < numberOfCities; city++) {

            int counter = numberOfCities;
            int tempCity = city;
            BigDecimal fuelLeft = new BigDecimal(0);
            while (counter > 0) {
                BigDecimal distance = new BigDecimal(distances[tempCity]);
                fuelLeft = new BigDecimal(fuel[tempCity]).add(fuelLeft);
                if (fuelLeft.multiply( new BigDecimal(mpg)).compareTo(distance) < 0) {
                    break;
                }
                BigDecimal fuelUsageForProvidedDistance = distance.divide(new BigDecimal(mpg));
                fuelLeft = fuelLeft.subtract( fuelUsageForProvidedDistance );
                counter--;
                tempCity = (tempCity + 1 ) % numberOfCities;
            }
            if(counter==0) return city;

        }

        return -1;
    }

    // O(n^2) time | O(n) space- where n is the number of cities
    public int validStartingCityAlgo(int[] distances, int[] fuel, int mpg) {
        int numberOfCities = distances.length;

        for (int startCityIdx = 0; startCityIdx < numberOfCities; startCityIdx++) {
            int milesRemaining = 0;

            for (int currentIdx = startCityIdx;
                 currentIdx < startCityIdx + numberOfCities;
                 currentIdx++) {
                if(milesRemaining < 0) {
                    continue;
                }

                int currentCityIdxRotated = currentIdx % numberOfCities;

                int fuelFromCurrentCity = fuel[currentCityIdxRotated];
                int distanceToNextCity = distances[currentCityIdxRotated];
                milesRemaining += fuelFromCurrentCity * mpg - distanceToNextCity;
            }

            if(milesRemaining >= 0) {
                return startCityIdx;
            }
        }

        return -1;
    }



}
