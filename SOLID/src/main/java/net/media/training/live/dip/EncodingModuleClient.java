package net.media.training.live.dip;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 13, 2011
 * Time: 10:20:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class EncodingModuleClient {
    public static void main(String[] args) {
        EncodingModule<String> encodingModule1  = new EncodingModule<String> ();
        FileDataReader fileDataReader = new FileDataReader();
        FileDataWriter<String> fileDataWriter = new FileDataWriter<String>();
        encodingModule1.encode(fileDataReader, "/Users/lazyghost/Desktop/Media.net/solid-assigment/src/main/java/net/media/training/live/dip/beforeEncryption.txt", fileDataWriter, "/Users/lazyghost/Desktop/Media.net/solid-assigment/src/main/java/net/media/training/live/dip/afterEncryption.txt");

        EncodingModule<MyDatabase> encodingModule2 = new EncodingModule<MyDatabase>();
        HTTPNetworkURLReader httpNetworkURLReader = new HTTPNetworkURLReader();
        MyDatabase mydb = new MyDatabase();
        MyDatabaseWriter<MyDatabase> myDatabaseWriter = new MyDatabaseWriter<MyDatabase>();
        encodingModule2.encode(httpNetworkURLReader, "google.com/finance", myDatabaseWriter, mydb);
    }
}
