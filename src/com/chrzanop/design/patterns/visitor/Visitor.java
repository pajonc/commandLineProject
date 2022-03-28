package com.chrzanop.design.patterns.visitor;

public interface Visitor {

    void visit(Shoe shoe);

    void visit(Dress dress);

    void visit(Jacket jacket);
}
