package net.media.training.live.dip;

import java.util.Base64;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 13, 2011
 * Time: 10:05:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class EncodingModule<T> {
    public String encode(String content){
        return Base64.getEncoder().encodeToString(content.getBytes());
    }
    public void encode(Reader reader, String source, Writer<T> writer, T destination){
        String content = reader.read(source);
        String encodedContent = this.encode(content);
        writer.write(destination, encodedContent);
    }
}

