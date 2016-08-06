package part1.chapter21;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MappedChannelWriteJDK6 {
    public static void main(String[] args) {
        RandomAccessFile fOut = null;
        FileChannel fChan = null;
        ByteBuffer mBuf;
        try {
            fOut = new RandomAccessFile("d:/test1.txt", "rw");
            fChan = fOut.getChannel();
            mBuf = fChan.map(FileChannel.MapMode.READ_WRITE, 0, 26);
            for (int i = 0; i < 26; i++) {
                mBuf.put((byte) ('A' + i));
            }
        } catch (IOException e) {
            System.out.printf("IOException %s%n", e);
            System.exit(1);
        } finally {
            try {
                if (fChan != null) fChan.close();
            } catch (IOException e) {
                System.out.println("Channel closing error.");
            }
            try {
                if (fOut != null) fOut.close();
            } catch (IOException e) {
                System.out.println("File closing error.");
            }
        }
    }
}