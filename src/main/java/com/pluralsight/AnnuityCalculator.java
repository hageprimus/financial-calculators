package com.pluralsight;

import java.util.Scanner;

public class AnnuityCalculator {
    private static final int MONTHS_IN_YEAR = 12;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //Get necessary values from user
        double monthlyPayment = getMonthlyPayment(s);
        double interestRateYears = getInterestRate(s);
        double annuityLengthYears = getAnnuityLength(s);

        //Convert year values to months as necessary
        double interestRateMonths = interestRateYears / MONTHS_IN_YEAR;
        double annuityLengthMonths = annuityLengthYears * MONTHS_IN_YEAR;

        //Calculate present value and output
        double presentValue = calcPresentValue(monthlyPayment, interestRateMonths, annuityLengthMonths);
        System.out.println("The present value of your annuity is $:" + presentValue + ".");
    }

    //Returns principal value from user input
    public static double getMonthlyPayment(Scanner s) {
        System.out.println("Enter the monthly payout from your annuity: ");
        return s.nextDouble();
    }

    //Returns interest rate as a DECIMAL from user input as a PERCENTAGE
    public static double getInterestRate(Scanner s) {
        System.out.println("Enter the yearly interest rate of your annuity as a percentage: ");
        return s.nextDouble() / 100;
    }

    //Returns loan length from user input
    public static double getAnnuityLength(Scanner s) {
        System.out.println("Enter the length of your annuity in years: ");
        return s.nextDouble();
    }

    //Calculate present value of annuity
    public static double calcPresentValue(double monthlyPayment, double interestRate, double annuityLength) {
        return monthlyPayment * ((1 - Math.pow(1 + interestRate, -annuityLength)) / interestRate);
    }
}
