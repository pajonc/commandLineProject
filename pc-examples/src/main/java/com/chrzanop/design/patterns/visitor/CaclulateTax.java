package com.chrzanop.design.patterns.visitor;

import java.util.ArrayList;
import java.util.List;

public class CaclulateTax {


    public static void main(String[] args) {
        RegularTaxCalculator taxCalculator = new RegularTaxCalculator();
        ChristmasTaxCalculator christmasTaxCalculator = new ChristmasTaxCalculator();


        List<Visitable> visitables = new ArrayList<>(3);
        visitables.add(new Dress(150));
        visitables.add(new Shoe(200));
        visitables.add(new Jacket(221.5));

        for (Visitable visitable: visitables) {
            visitable.accept(taxCalculator);
            visitable.accept(christmasTaxCalculator);
        }

        System.out.println(taxCalculator.getSumOFTaxes());
        System.out.println(christmasTaxCalculator.getSumOFTaxes());



    }

}
