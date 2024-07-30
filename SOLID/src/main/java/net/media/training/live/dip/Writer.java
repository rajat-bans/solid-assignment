package net.media.training.live.dip;

public interface Writer<T> {
    public void write(T destination, String content);
} 
