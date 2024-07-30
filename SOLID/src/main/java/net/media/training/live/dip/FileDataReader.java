package net.media.training.live.dip;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class FileDataReader implements Reader{
    public String read(String source){
        String res = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(source));
            res = reader.lines().collect(Collectors.joining(""));;
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
