package se.lexicon;

import java.util.regex.Pattern;

public class FunctionalDemo {

    static DoStringStuff concatOperator = new DoStringStuff() {
        @Override
        public String operate(String s1, String s2) {
            return s1 + s2;
        }
    };

    static DoubleOperator additionalOperator = new DoubleOperator() {
        @Override
        public double apply(double n1, double n2) {
            return n1 + n2;
        }
    };

    static StringValidator notNullValidator = new StringValidator() {
        @Override
        public boolean validate(String input) {
            return input != null;
        }
    };

    static DoubleOperator subtractionOperator = new DoubleOperator() {
        @Override
        public double apply(double n1, double n2) {
            return n1 - n2;
        }
    };

    static StringValidator mobileValidator = new StringValidator() {
        @Override
        public boolean validate(String input) {
            return input != null && Pattern.compile("^\\d{10}$").matcher(input).matches();
        }
    };


    public static double calcOperator(double n1, double n2, DoubleOperator operator) {
        return operator.apply(n1, n2);
    }

    public static boolean doValidOperator(String input, StringValidator operator){
        return operator.validate(input);
    }


    public static void main(String[] args) {
        /*ConcatStringOperator concatStringOperator = new ConcatStringOperator();
        System.out.println(concatStringOperator.operate("Hello","World!"));

        BiggestString biggestString = new BiggestString();
        System.out.println(biggestString.operate("ABC", "ABCD"));*/


        System.out.println(concatOperator.operate("Hello", "World!"));
        System.out.println(concatOperator.operate("Hello", "Functional Programming!"));
        System.out.println("Additional Operator:" + additionalOperator.apply(10d, 5d));
        System.out.println("Subtraction Operator:" + subtractionOperator.apply(10d, 5d));
        System.out.println(notNullValidator.validate("Text"));

        System.out.println(calcOperator(40, 3, additionalOperator));
        System.out.println(calcOperator(40, 3, subtractionOperator));

        System.out.println(doValidOperator("Hello", notNullValidator));
        System.out.println(doValidOperator("1234567890", mobileValidator ));

    }

}
