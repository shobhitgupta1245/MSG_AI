package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EarningCalculator {

    /*
     * Pre-computation Complexity: 0,
     * Complexity: O(rounds * size of group list)
     */
    public static long calculate(List<Integer> groupList, int busCapacity, int rounds, long sumOfGroupsSizes) {
        long sum = 0;
        int index = 0;
        if (sumOfGroupsSizes != 0 && busCapacity > sumOfGroupsSizes) {
            sum = rounds * sumOfGroupsSizes;
        }
        else {
            while (rounds > 0) {
                long sumOfGroups = 0;
                for (int j = 0; j < groupList.size(); j++) {
                    long nextSum = sumOfGroups + groupList.get(index % groupList.size());
                    if (busCapacity >= nextSum) {
                        sumOfGroups = nextSum;
                    }
                    else {
                        break;
                    }
                    index++;
                }
                if (sumOfGroups == 0) {
                    break;
                }
                sum += sumOfGroups;
                rounds--;
            }
        }
        return sum;
    }

    /*
     * Pre-computation Complexity: O(size of group list),
     * Complexity: O(rounds)
     */
    public static long optimizeCalculate(List<Integer> groupList, int busCapacity, int rounds, long sumOfGroupsSizes) {
        Map<Integer, Pair> iTojAndSum = new HashMap<Integer, Pair>();
        long sum = 0;
        int start, end = 0;
        if (sumOfGroupsSizes != 0 && busCapacity > sumOfGroupsSizes) {
            sum = rounds * sumOfGroupsSizes;
        }
        else {
            for (int i = 0; i < groupList.size(); i++) {
                start = i;
                if (end < start) {
                    end = start;
                }
                if (i > 0) {
                    sum -= groupList.get(i - 1);
                }
                while (end - start < groupList.size()) {
                    long nextSum = sum + groupList.get(end % groupList.size());
                    if (busCapacity >= nextSum) {
                        sum = nextSum;
                    }
                    else {
                        break;
                    }
                    end++;
                }
                iTojAndSum.put(start, new Pair(end % groupList.size(), sum));
            }

            sum = 0;
            start = 0;
            while (rounds-- > 0) {
                if (iTojAndSum.containsKey(start)) {
                    sum += iTojAndSum.get(start).getSum();
                    start = iTojAndSum.get(start).getEndPosition();
                }
                else {
                    return sum;
                }
            }
        }
        return sum;
    }
}
