package com.chrzanop.design.patterns.visitor;

public class RegularTaxCalculator implements Visitor {

    private double sumOFTaxes;

    public void visit(Shoe shoe) {
        sumOFTaxes = sumOFTaxes + shoe.getPrice() * .1;
    }


    public void visit(Dress dress) {
        sumOFTaxes = sumOFTaxes + dress.getPrice() * .2;
    }


    public void visit(Jacket jacket) {
        sumOFTaxes = sumOFTaxes + jacket.getPrice() * 0.15;
    }

    public double getSumOFTaxes() {
        return sumOFTaxes;
    }
}
