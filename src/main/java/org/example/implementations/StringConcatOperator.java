package org.example.implementations;

import org.example.interfaces.StringOperator;

public class StringConcatOperator implements StringOperator {
    @Override
    public String operate(String s1, String s2) {
        return s1 + s2;
    }
}
