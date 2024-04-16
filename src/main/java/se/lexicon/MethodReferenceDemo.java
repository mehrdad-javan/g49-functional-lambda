package se.lexicon;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToDoubleBiFunction;

public class MethodReferenceDemo {

    public static void main(String[] args) {

        Function<Double, Double> calcTaxLambda = (salary) -> Calculator.calculateTax(salary);
        System.out.println(calcTaxLambda.apply(10000d));
        // Reference to a static method (ClassName::staticMethodName)
        Function<Double, Double> calcTaxMethodReference = Calculator::calculateTax;
        System.out.println(calcTaxMethodReference.apply(10000d));


        Calculator calculator = new Calculator();
        ToDoubleBiFunction<Double, Double> additionUsingLambda = (n1, n2) -> calculator.add(n1, n2);
        System.out.println(additionUsingLambda.applyAsDouble(10d,20d));
        // Reference to instance method of a particular object (objectName::methodName)
        ToDoubleBiFunction<Double, Double> additionUsingMethodReference = calculator::add;
        System.out.println(additionUsingMethodReference.applyAsDouble(10d,20d));

    }

}
