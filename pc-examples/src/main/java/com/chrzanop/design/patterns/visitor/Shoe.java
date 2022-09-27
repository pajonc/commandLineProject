package com.chrzanop.design.patterns.visitor;

public class Shoe implements Visitable{

    private int price;

    public Shoe(int price) {
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


