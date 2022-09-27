package com.chrzanop.design.patterns.visitor;

public class Jacket implements Visitable {

    private double price;

    public Jacket(double price) {
        this.price = price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public double getPrice() {
        return price;
    }
}
