package com.chrzanop.design.patterns.visitor;

public class ChristmasTaxCalculator implements Visitor {

    private double sumOFTaxes;

    @Override
    public void visit(Shoe shoe) {
        sumOFTaxes = sumOFTaxes +  shoe.getPrice()*.22;
    }

    @Override
    public void visit(Dress dress) {
        sumOFTaxes = sumOFTaxes + dress.getPrice()*0.33;
    }

    @Override
    public void visit(Jacket jacket) {
        sumOFTaxes = sumOFTaxes + jacket.getPrice()*.44;
    }

    public double getSumOFTaxes() {
        return sumOFTaxes;
    }
}
