package net.media.training.designpattern.strategy;

public interface Strategy {
    default void atLeast(int val, int min) {
        if (val < min)
            throw new RuntimeException("at least check failed:" + val);
    }

    default void atMost(int val, int max) {
        if (val > max)
            throw new RuntimeException("at most check failed:" + val);
    }
}
