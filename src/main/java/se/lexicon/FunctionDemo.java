package se.lexicon;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionDemo {

    // Use Case: it is used to apply a transformation to an input value and produce an output.
    public static void main(String[] args) {
        Function<String, String> toLowercase = (str) -> str.toLowerCase();
        System.out.println(toLowercase.apply("HELLO"));
        UnaryOperator<String> toUppercase = (str) -> str.toUpperCase();
        System.out.println(toUppercase.apply("hello"));

        Function<Double, String> formatNumber = (number) -> {
            DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
            return decimalFormat.format(number);
        };

        double num = 1234567.981234; // 1,234,567.98
        String formattedNumber = formatNumber.apply(num);
        System.out.println("formattedNumber = " + formattedNumber);

        Function<Integer[], Integer> arrayToAvg = (arrayOfNumbers) -> {
            int sum = 0;
            for (Integer number : arrayOfNumbers) {
                sum += number;
            }
            int avg = sum / arrayOfNumbers.length;
            return avg;
        };

        Integer[] numbers = {1, 2, 3, 4, 5};
        System.out.println(arrayToAvg.apply(numbers));


        List<Account> accounts = new ArrayList<>();
        Account account1 = new Account("DEV1");
        account1.setRole(Role.USER);
        account1.enable();
        Account account2 = new Account("DEV2");
        account2.setRole(Role.USER);
        account2.enable();

        Account account3 = new Account("GUEST1");
        Account account4 = new Account("GUEST2");
        Account account5 = new Account("GUEST3");

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);
        accounts.add(account5);

        Function<Account, String> extractAccountInfo = account -> account.getUsername() + " " + account.getRole();

        Consumer<Account> printAccountInfo = (account) -> System.out.println(extractAccountInfo.apply(account));
        accounts.forEach(printAccountInfo);


    }

}
