package part1.chapter21;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ExplicitChannelWriteJDK6 {
    public static void main(String[] args) {
        FileOutputStream fOut = null;
        FileChannel fChan = null;
        ByteBuffer mBuf;
        try {
            fOut = new FileOutputStream("d:/test1.txt");
            fChan = fOut.getChannel();
            mBuf = ByteBuffer.allocate(26);
            for (int i = 0; i < 26; i++) {
                mBuf.put((byte) ('A' + i));
            }
            mBuf.rewind();
            fChan.write(mBuf);
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
