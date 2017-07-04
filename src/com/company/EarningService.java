package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shobhit on 04/07/17.
 */
public class EarningService {

    public static void main(String[] args) throws IOException {
        int numOfGroups, busCapacity, numOfRounds;
        long sumOfGroupsSizes = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Number of groups: ");
        numOfGroups = Integer.parseInt(reader.readLine());
        System.out.print("Capacity of bus: ");
        busCapacity = Integer.parseInt(reader.readLine());
        System.out.print("Number of rounds: ");
        numOfRounds = Integer.parseInt(reader.readLine());

        List<Integer> groupSizeList = new ArrayList<Integer>(numOfGroups);
        System.out.print("Size of each Group(Total: " + numOfGroups + "), space separated: ");
        String groupSizeString = reader.readLine();
        for (int i = 0; i < numOfGroups; i++) {
            groupSizeList.add(Integer.parseInt(groupSizeString.split(" ")[i]));
            sumOfGroupsSizes += groupSizeList.get(i);
        }
        System.out.println("Total earnings[BRUTE FORCE APPROACH] is: "
                + EarningCalculator.calculate(groupSizeList, busCapacity, numOfRounds, sumOfGroupsSizes));
        System.out.println("Total earnings[OPTIMIZED APPROACH] is: "
                + EarningCalculator.optimizeCalculate(groupSizeList, busCapacity, numOfRounds, 0));
    }

}
