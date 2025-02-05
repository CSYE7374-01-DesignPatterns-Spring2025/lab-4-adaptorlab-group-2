package edu.neu.csye7374;

import edu.neu.csye7374.CalculatableAPI.OPERATION;

import java.util.ArrayList;
import java.util.List;

public class CalculatorObjectAdapter implements AccumulatableAPI {
	
	private CalculatableAPI calculator;
	private double sum;
	

	public CalculatorObjectAdapter(CalculatableAPI calc) {
		super();
		this.calculator = calc;
		this.sum = 0;
	}

	@Override
	public double accumulation(List<Double> itemPrices) {
		sum = 0;
		for (double itemPrice : itemPrices) {
			sum = this.calculator.operation(OPERATION.ADD, sum, itemPrice);
		}
		return sum;
	}

	@Override
	public double payment(double cash) {
		return this.calculator.operation(OPERATION.SUB, cash, sum);
	}

}

