package org.example.interfaces;

//MUST HAVE ONLY ONE ABSTRACT METHOD!
@FunctionalInterface
public interface StringOperator {
    String operate(String s1, String s2);
}
