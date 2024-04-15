package se.lexicon;

import java.util.UUID;

public class LambdaDemo {

    static DoStringStuff concatenate = (str1, str2) -> str1 + " " + str2;

    public static void main(String[] args) {
        System.out.println(concatenate.operate("Hello", "Lambda!"));
        /*DoStringStuff getBiggestString = (s1,s2) ->  {
            if (s1.length() >= s2.length()){
                return s1;
            } else {
                return s2;
            }
        };*/
        DoStringStuff getBiggestString = (s1, s2) -> s1.length() >= s2.length() ? s1 : s2;
        DoubleOperator addition = (n1, n2) -> n1 + n2;
        DoubleOperator subtraction = (n1, n2) -> n1 - n2;

        System.out.println(getBiggestString.operate("ABCD", "ABC"));
        System.out.println(addition.apply(10,6));
        System.out.println(subtraction.apply(10,6));

        // Printer    void print(String input);

        Printer printString = str -> System.out.println(str);
        printString.print("Hello Lambda!");

        // String generate();
        StringRandomNumber generateRandomText = () -> UUID.randomUUID().toString();
        printString.print(generateRandomText.generate());


    }

}
