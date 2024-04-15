package se.lexicon;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

    // Use Case for Predicate Interface is to :
    // Filtering elements in condition
    // Selecting elements from a stream or sequence of data that meet the specific condition

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = -10; i < 30; i++) {
            numbers.add(i);
        }


        Predicate<Integer> isEven = number -> number % 2 == 0;
        Predicate<Integer> isGreaterThan18 = n -> n > 18;
        Predicate<Integer> isPositive = n -> n > 0;
        filterNumbers(numbers, isEven);
        filterNumbers(numbers, isPositive);


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


        Predicate<Account> isEnable = (account) -> account.isEnable();
        Predicate<Account> isRoleGuest = (account) -> account.getRole().equals(Role.GUEST);


        List<Account> enableAccounts = filterAccounts(accounts, isEnable);
        System.out.println(enableAccounts);

        List<Account> userAccounts = filterAccounts(accounts, isRoleGuest);
        System.out.println(userAccounts);



    }


    public static void filterNumbers(List<Integer> numbers, Predicate<Integer> predicate) {
        for (Integer number : numbers) {
            if (predicate.test(number)) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }


    public static List<Account> filterAccounts (List<Account> accounts, Predicate<Account> predicate){
        List<Account> result = new ArrayList<>();
        for (Account account: accounts){
            if(predicate.test(account)){
                result.add(account);
            }
        }
        return result;
    }

}
