package se.lexicon;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerDemo {

    // Use Cases:
    // Printing elements of a collection
    // Modifying elements in a collection
    // Performing action on elements during the iteration
    public static void main(String[] args) {

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

        Consumer<Account> printUsername = (account) -> System.out.println(account.getUsername());
        Consumer<Account> printCreateDate = (account) -> System.out.println(account.getCreateDate());

        /*for (Account account: accounts){
            printUsername.accept(account);
        }*/

        Predicate<Account> isUserRoleGuest = (account) -> account.getRole().equals(Role.GUEST);
        accounts.forEach((account) -> {
            if (isUserRoleGuest.test(account)){
                System.out.println(account.getUsername());
            }
        });

    }

}
