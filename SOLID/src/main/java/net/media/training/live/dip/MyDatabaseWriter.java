package net.media.training.live.dip;

public class MyDatabaseWriter<T> implements Writer<T>{
    public void write(T myDatabase, String content){
        ((MyDatabase) myDatabase).write(content);
    }
}
