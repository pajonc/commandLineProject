package com.chrzanop.coding.algoexpert.string;

import java.util.ArrayList;

public class ValidIPAddresses {

    // O(1) time | O(1) space - due to 2^32 limitation of possibilities
    // 8 bytes * 4 per ip slot (0-255) range == 2^8
    // 2^8.2^8.2^8.2^8 = possible ip address
    public ArrayList<String> validIPAddresses(String string) {
        ArrayList<String> ipAddressesFound = new ArrayList<String>();

        for (int i = 1; i < Math.min((int) string.length(), 4); i++) {
            String[] currentIpAddressParts = new String[]{"", "", "", ""};

            currentIpAddressParts[0] = string.substring(0, i);
            if (!isValidPart(currentIpAddressParts[0])) {
                continue;
            }

            for (int j = i + 1; j < i + Math.min((int) string.length() - i, 4); j++) {
                currentIpAddressParts[1] = string.substring(i, j);
                if (!isValidPart(currentIpAddressParts[1])) {
                    continue;
                }

                for (int k = j + 1; k < j + Math.min((int) string.length() - j, 4); k++) {
                    currentIpAddressParts[2] = string.substring(j, k);
                    currentIpAddressParts[3] = string.substring(k);
                    if (isValidPart(currentIpAddressParts[2]) && isValidPart(currentIpAddressParts[3])) {
                        ipAddressesFound.add(join(currentIpAddressParts));
                    }
                }
            }
        }
        return ipAddressesFound;
    }

    private boolean isValidPart(String str) {
        int strAsInt = Integer.parseInt(str);
        if (strAsInt > 255) {
            return false;
        }
        return str.length() == Integer.toString(strAsInt).length();
    }

    private String join(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
            if (i < strings.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

}
