package com.chrzanop.collections;

import java.util.HashSet;
import java.util.Set;

public class WrapperObject {

    public static void main(String[] args) {
        WrapperObject[] wrapperObjects = new WrapperObject[10];
        wrapperObjects[0] = new WrapperObject(new HashSet<>());
        wrapperObjects[1] = new WrapperObject(new HashSet<>());
        wrapperObjects[2] = new WrapperObject(new HashSet<>());
        System.out.println(wrapperObjects);
    }

    public Set<String> getElements() {
        return elements;
    }

    private Set<String> elements;

    public WrapperObject(Set<String> elements) {
            this.elements = elements;
    }




}
