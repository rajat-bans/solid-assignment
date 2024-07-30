package net.media.training.live.dip;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
public class FileDataWriter<T> implements Writer<T>{
    public void write(T destination, String content){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter((String) destination));
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
