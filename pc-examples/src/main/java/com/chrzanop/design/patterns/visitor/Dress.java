package com.chrzanop.design.patterns.visitor;

import java.util.Hashtable;

public class Dress implements Visitable {

    private int price;

    public Dress(int price) {
        this.price = price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getPrice() {
        return price;
    }
}
