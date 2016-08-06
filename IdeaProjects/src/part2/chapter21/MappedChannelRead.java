package part1.chapter21;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MappedChannelRead {
    public static void main(String[] args) {

        try (FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get("d:/test.txt"))) {
            long fSize = fChan.size();
            MappedByteBuffer mBuf = fChan.map(FileChannel.MapMode.READ_ONLY, 0, fSize);

            for (long i = 0; i < fSize; i++) {
                System.out.print((char) mBuf.get());
            }
            System.out.println();
        } catch (IOException e) {
            System.out.printf("IOException %s\n", e);
        }
    }
}
