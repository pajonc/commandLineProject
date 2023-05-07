package com.chrzanop.coding.algoexpert.greedy;

import java.util.ArrayList;
import java.util.Collections;

public class ClassPhotos {

    // O(2*nLogn + n) --> O(nlogn) time , O(1) space
    public boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights, Collections.reverseOrder());
        Collections.sort(blueShirtHeights, Collections.reverseOrder());

        String shirtColorInFirstRow = redShirtHeights.get(0) < blueShirtHeights.get(0) ?
                "RED" : "BLUE";

        for (int i = 0; i < redShirtHeights.size(); i++) {
            Integer redShirtHeight = redShirtHeights.get(i);
            Integer blueShirtHeight = blueShirtHeights.get(i);

            if (shirtColorInFirstRow == "RED") {
                if (redShirtHeight >= blueShirtHeight)
                    return false;
            } else {
                if (blueShirtHeight >= redShirtHeight)
                    return false;
            }

        }
        return true;
    }

}
