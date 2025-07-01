package com.chrzanop.coding.algoexpert.stacks;

import java.util.*;
import java.util.stream.Collectors;

public class ShortenPath {

    //O(n) time | O(n) space - where n is the length of the path
    public static String shortenPathAlgo(String path) {
        boolean startsWithPath = path.charAt(0) == '/';
        String[] tokensArr = path.split("/");
        List<String> tokensList = Arrays.asList(tokensArr);
        List<String> filteredTokens = tokensList.stream()
                .filter(token -> isImportantToken(token))
                .collect(Collectors.toList());

        List<String> stack = new ArrayList<>();
        if(startsWithPath) stack.add("");
        for(String token : filteredTokens) {
            if(token.equals("..")){
                if(stack.size()==0 || stack.get(stack.size()-1).equals("..")) {
                    stack.add(token);
                } else if(!stack.get(stack.size()-1).equals("")) {
                    stack.remove(stack.size()-1);
                }
            } else {
                stack.add(token);
            }
        }

        if(stack.size()==1 & stack.get(0).equals("")) return "/";
        return String.join("/", stack);
    }

    private static boolean isImportantToken(String token) {
        return token.length()>0 && !token.equals(".");
    }

    //O(n) time | O(n) space - where n is the length of the path
    public static String shortenPath(String path) {

        boolean startsWithSeparator = path.charAt(0) == '/';
        String[] split = path.split("/");
        Deque<String> stack = new LinkedList<>();

        if (startsWithSeparator) stack.push("");
        for (int i = 0; i < split.length; i++) {
            String str = split[i];
            if (str.equals("..")) {
                if (startsWithSeparator && stack.size() == 1) {
                    continue;
                }
                if (startsWithSeparator && stack.size() > 1 && stack.peek().equals("..")) {
                    stack.push(str);
                    continue;
                }
                if (startsWithSeparator && stack.size() > 1 && !stack.peek().equals("..")) {
                    stack.pop();
                    continue;
                }
                if (!startsWithSeparator && stack.peek() != null && !stack.peek().equals("..")) {
                    stack.pop();
                    continue;
                }
                if (!startsWithSeparator && stack.peek() != null && stack.peek().equals("..")) {
                    stack.push(str);
                    continue;
                }
            }
            if (str.equals("") || str.equals(".")) continue;
            stack.push(str);
        }

        List<String> reversedPath = new ArrayList<>();
        while (!stack.isEmpty()) {
            reversedPath.add(stack.pop());
        }

        StringBuilder result = new StringBuilder();
        for (int i = reversedPath.size() - 1; i >= 0; i--) {
            String value = reversedPath.get(i);
            if (value.equals("")) {
                result.append("/");
                continue;
            }
            result.append(value);
            if (i == 0) break;
            result.append("/");
        }

        return result.toString();
    }
}
