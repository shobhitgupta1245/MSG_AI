package com.company;

/**
 * Created by shobhit on 04/07/17.
 */
public class Pair {

    private Integer endPosition;

    private Long sum;

    public Pair(Integer endPosition, Long sum) {
        this.endPosition = endPosition;
        this.sum = sum;
    }

    public Integer getEndPosition() {
        return endPosition;
    }

    public Long getSum() {
        return sum;
    }
}
