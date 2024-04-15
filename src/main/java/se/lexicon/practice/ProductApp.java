package se.lexicon.practice;

import java.util.ArrayList;
import java.util.List;

public class ProductApp {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product("Iphone x", 1000, 1);
        products.add(product1);
        products.add(new Product("Surface Book 3", 2000.00, 20));
        products.add(new Product("Iphone 6s", 100.00, 0));
        products.add(new Product("Iphone 8", 150.00, 5));
        products.add(new Product("Best", 120.00, 0));

        //Print out all Products that have stock value of 0.
        Conditional conditionalForStockZero = (p) -> p.getStock() == 0;
        Action printProduct = (p) -> System.out.println(p.summary());
        process(products, conditionalForStockZero, printProduct);

        //Print out the productName of all the Products that starts with B.
        process(products, (p) -> p.getName().startsWith("B"), (p) -> System.out.println(p.getName()));


        //TODO:  Print out all Products that have price above 100 AND lower than 150
        //TODO:  Increase the price of all Products that have a stock value of less than 10 AND above 0 by 50%

    }


    public static void process(List<Product> list, Conditional conditional, Action action) {
        for (Product product : list) {
            if (conditional.test(product)) {
                action.execute(product);
            }
        }
    }

}
