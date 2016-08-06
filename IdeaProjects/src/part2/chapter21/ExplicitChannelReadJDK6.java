package part1.chapter21;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExplicitChannelReadJDK6 {
    public static void main(String[] args) {
        FileInputStream fin = null;
        FileChannel fChan = null;
        ByteBuffer mBuf;
        int count;

        try {
            fin = new FileInputStream("d:/test1.txt");
            fChan = fin.getChannel();
            mBuf = ByteBuffer.allocate(128);

            do {
                count = fChan.read(mBuf);
                if (count != -1) {
                    mBuf.rewind();
                    for (int i = 0; i < count; i++) {
                        System.out.print((char) mBuf.get());
                    }
                }
            } while (count != -1);
            System.out.println();
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
