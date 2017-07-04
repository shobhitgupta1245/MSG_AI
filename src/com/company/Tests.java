package com.company;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Created by shobhit on 02/07/17.
 */
public class Tests {

    /*
     * If the capacity of bus is less than the first group's size, then earning
     * will be ZERO
     */
    @Test
    public void TestZeroEarning() {
        System.out.println("Test case 1:\nStarted");
        int rounds = (int) (Math.random() * 100) + 1;
        int busCapacity = (int) (Math.random() * 100) + 1;
        System.out.print("Bus Capacity: " + busCapacity + ", Rounds: " + rounds + ", Group's Sizes: ");

        List<Integer> groupList = new ArrayList<Integer>(10);
        for (int i = 0; i < 10; i++) {
            groupList.add((int) (Math.random() * 100) + 100);
            System.out.print(groupList.get(i) + " ");
        }
        long ans1 = EarningCalculator.calculate(groupList, busCapacity, rounds, 0);
        long ans2 = EarningCalculator.optimizeCalculate(groupList, busCapacity, rounds, 0);
        assert ans1 == 0 && ans1 == ans2;
        System.out.println(", Earnings: " + ans1);
        System.out.println("Passed");
    }

    /*
     * If the sum of all group's sizes is less than the bus capacity, total
     * earning will be equal to the sum of group's sizes in 1 round
     */
    @Test
    public void TestTotalEarningEqualToGroupSizeSumMultipliedRounds() {
        System.out.println("\nTest case 2:\nStarted");
        long sum = 0;
        int rounds = (int) (Math.random() * 100) + 1;
        int busCapacity = (int) (Math.random() * 100) + 100;
        System.out.print("Bus Capacity: " + busCapacity + ", Rounds: " + rounds + ", Group's Sizes: ");

        List<Integer> groupList = new ArrayList<Integer>(10);
        for (int i = 0; i < 10; i++) {
            groupList.add((int) (Math.random() * 10) + 1);
            System.out.print(groupList.get(i) + " ");
            sum += groupList.get(i);
        }
        long ans1 = EarningCalculator.calculate(groupList, busCapacity, rounds, 0);
        long ans2 = EarningCalculator.optimizeCalculate(groupList, busCapacity, rounds, 0);
        assert ans1 == (sum * rounds) && ans1 == ans2;
        System.out.println(", Earnings: " + ans1);
        System.out.println("Passed");
    }

    /*
     * Comparison between 2 approaches
     */
    @Test
    public void ComparingTwoApproaches() {
        System.out.println("\nTest case 3:\nStarted");
        int rounds = (int) (Math.random() * 100) + 1;
        int busCapacity = (int) (Math.random() * 100) + 50;
        System.out.print("Bus Capacity: " + busCapacity + ", Rounds: " + rounds + ", Group's Sizes: ");

        List<Integer> groupList = new ArrayList<Integer>(10);
        for (int i = 0; i < 10; i++) {
            groupList.add((int) (Math.random() * 70) + 1);
            System.out.print(groupList.get(i) + " ");
        }
        long ans1 = EarningCalculator.calculate(groupList, busCapacity, rounds, 0);
        long ans2 = EarningCalculator.optimizeCalculate(groupList, busCapacity, rounds, 0);
        System.out.println("\nEarnings from calculate: " + ans1);
        System.out.println("Earnings from optimizeCalculate: " + ans2);
        assert ans1 == ans2;
        System.out.println("Passed");
    }
}
