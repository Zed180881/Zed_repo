package part1.chapter21;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MappedChannelReadJDK6 {
    public static void main(String[] args) {
        FileInputStream fin = null;
        FileChannel fChan = null;
        long fSize;
        ByteBuffer mBuf;

        try {
            fin = new FileInputStream("d:/test1.txt");
            fChan = fin.getChannel();
            fSize = fChan.size();
            mBuf = fChan.map(FileChannel.MapMode.READ_ONLY, 0, fSize);
            for (long i = 0; i < fSize; i++) {
                System.out.print((char) mBuf.get());
            }
        } catch (IOException e) {
            System.out.printf("IOException %s\n", e);
        } finally {
            try {
                if (fChan != null) fChan.close();
            } catch (IOException e) {
                System.out.println("Channel closing error.");
            }
            try {
                if (fin != null) fin.close();
            } catch (IOException e) {
                System.out.println("File closing error.");
            }
        }
    }
}
