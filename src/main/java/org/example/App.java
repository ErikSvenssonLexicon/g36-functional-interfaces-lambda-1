package org.example;

import org.example.implementations.StringConcatOperator;
import org.example.interfaces.StringOperator;

public class App
{

    //ANONYMOUS INNER CLASS
    static StringOperator longestStringOperator = new StringOperator(){

        @Override
        public String operate(String s1, String s2) {
            if(s1.length() > s2.length()){
                return s1;
            }
            return s2;
        }
    };

    static StringOperator concatOperator = new StringConcatOperator();

    public static void main( String[] args )
    {
        //DEFINING A LAMBDA EXPRESSION:
        //(arguments)
        //Arrow ->
        //implementation of interface (body)

        StringOperator vonOperator = (s1, s2) -> s1 + " von " + s2;


        System.out.println(stringOperation("Java Group ", "36", concatOperator));
        System.out.println(stringOperation("123", "1234", longestStringOperator));
        System.out.println(stringOperation("Joakim", "Anka", vonOperator));
        System.out.println(stringOperation("Erik", "Växjö", (s1, s2) -> s1 + " af " + s2));
    }

    public static String stringOperation(String s1, String s2, StringOperator operator){
        return operator.operate(s1, s2);
    }
}
