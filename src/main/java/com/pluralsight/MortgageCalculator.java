package com.pluralsight;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        //Get necessary values from user
        long principal = getPrincipal(s);
        double interestRateYears = getInterestRate(s);
        double loanLengthYears = getLoanLength(s);

        //Convert loan length and interest rate to months
        double loanLengthMonths = 12 * loanLengthYears;
        double interestRateMonths = interestRateYears / 12;

        //Calculate monthly payment
        double monthlyPayment = calcMonthlyPayment(principal, interestRateMonths, loanLengthMonths);

        //Calculate total interest paid
        double totalInterest = calcTotalInterest(principal, monthlyPayment, loanLengthMonths);

        //Display these values on the console
        System.out.println("Your monthly payment for your mortgage is $" + monthlyPayment + ".");
        System.out.println("Your total interest to pay over the length of your mortgage is $" + totalInterest + ".");
    }

    //Returns principal value from user input
    public static long getPrincipal(Scanner s) {
        System.out.println("Enter the principal of your mortgage: ");
        return s.nextLong();
    }

    //Returns interest rate as a DECIMAL from user input as a PERCENTAGE
    public static double getInterestRate(Scanner s) {
        System.out.println("Enter the interest rate of your mortgage as a percentage: ");
        return s.nextDouble() / 100;
    }

    //Returns loan length from user input
    public static double getLoanLength(Scanner s) {
        System.out.println("Enter how long your mortgage will be paid off for in years: ");
        return s.nextDouble();
    }

    //Calculate monthly payment with compound interest based on previous user input passed into method
    public static double calcMonthlyPayment(long principal, double interestRateMonths, double loanLengthMonths) {
        return principal * (interestRateMonths * Math.pow(1 + interestRateMonths, loanLengthMonths)) / (Math.pow(1 + interestRateMonths, loanLengthMonths) - 1);
    }

    //Calculate total interest
    public static double calcTotalInterest(long principal, double monthlyPayment, double loanLengthMonths) {
        return (monthlyPayment * loanLengthMonths) - principal;
    }
}
