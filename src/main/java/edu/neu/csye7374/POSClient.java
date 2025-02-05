package edu.neu.csye7374;

import java.util.List;
import java.util.Objects;

public class POSClient {
    public static void demo(){
        double cash = 500.0;
        System.out.println("Initial cash amount: " + cash);

        List<Double> itemPrices = List.of(15.0, 30.0, 45.0);
        System.out.println("\n");

        System.out.println("Item prices: " + String.join(", ", itemPrices.stream().map(Object::toString).toList()));

        CalculatableAPI cal = new Calculator();

        System.out.println("======================Object adapter design pattern demo======================");
        CalculatorObjectAdapter objectAdapter = new CalculatorObjectAdapter(cal);

        double total = objectAdapter.accumulation(itemPrices);
        System.out.println("Total accumulated price: " + total);

        double change = objectAdapter.payment(cash);
        System.out.println("Remaining change: " + change);

        System.out.println("\n");

        System.out.println("======================Class adapter design pattern demo======================");
        CalculatorClassAdapter classAdapter = new CalculatorClassAdapter();

        total = classAdapter.accumulation(itemPrices);
        System.out.println("Total accumulated price: " + total);

        change = classAdapter.payment(cash);
        System.out.println("Remaining Change: " + change);
    }
}
