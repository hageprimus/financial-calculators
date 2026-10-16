package com.pluralsight;

import java.util.Scanner;

public class DepositCalculator {
    private static final int DAYS_IN_YEAR = 365;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //Get necessary values from user
        double deposit = getDeposit(s);
        double interestRate = getInterestRate(s);
        double cdLength = getCdLength(s);

        //Calculate monthly payment
        double futureValue = calcFutureValue(deposit, interestRate, cdLength);

        //Calculate total interest paid
        double totalInterest = calcTotalInterest(futureValue, deposit);

        //Display these values on the console
        System.out.println("The future value of your CD is $" + futureValue + ".");
        System.out.println("Your total interest you will accrue over the length of your CD is $" + totalInterest + ".");
    }

    //Returns principal value from user input
    public static double getDeposit(Scanner s) {
        System.out.println("Enter the full size of your deposit: ");
        return s.nextDouble();
    }

    //Returns interest rate as a DECIMAL from user input as a PERCENTAGE
    public static double getInterestRate(Scanner s) {
        System.out.println("Enter the interest rate of your account as a percentage: ");
        return s.nextDouble() / 100;
    }

    //Returns loan length from user input
    public static double getCdLength(Scanner s) {
        System.out.println("Enter how long your CD is for in years: ");
        return s.nextDouble();
    }

    //Calculates future value of CD based on deposit, interest rate, and length in years
    public static double calcFutureValue(double deposit, double interestRate, double cdLength) {
        return deposit * Math.pow(1 + (interestRate / DAYS_IN_YEAR), cdLength * DAYS_IN_YEAR);
    }

    //Calculate total interest
    public static double calcTotalInterest(double futureValue, double deposit) {
        return futureValue - deposit;
    }
}
