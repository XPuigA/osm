package generator;

import model.OsmMap;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class HtmlFileGenerator implements Generator {

    public static int DEFAULT_WIDTH = 300;
    public static int DEFAULT_HEIGHT = 150;

    private String result;
    private OsmMap map;
    private int width;
    private int height;
    private String destination;

    public HtmlFileGenerator(OsmMap map, String path, String destination) {
        this.map = map;
        this.destination = destination;
    }

    public HtmlFileGenerator(OsmMap map, int width, int height, String destination) {
        this.map = map;
        this.width = width;
        this.height = height;
        this.destination = destination;
    }

    @Override
    public void generate() throws Exception {
        HtmlGenerator generator = new HtmlGenerator(map, width, height);
        RandomAccessFile stream = new RandomAccessFile(destination, "rw");
        FileChannel channel = stream.getChannel();
        generator.generate();
        byte[] strBytes = generator.getResult().getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
        buffer.put(strBytes);
        buffer.flip();
        channel.write(buffer);
        stream.close();
        channel.close();
        result = destination;
    }

    @Override
    public String getResult() {
        return result;
    }


}
