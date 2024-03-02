package base;

import javax.swing.*;
import java.io.IOException;

import generator.SwingGenerator;
import model.OsmMap;
import parser.OsmParser;

import static base.Utils.getResourceFileAsString;

public class SwingMain {

    public static void main(String[] args) throws IOException {
        OsmMap osmMap = OsmParser.parse(getResourceFileAsString("map2.osm"));

        JFrame frame = new JFrame("");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        SwingGenerator generator = new SwingGenerator(frame.getContentPane().getGraphics(), osmMap);
        generator.generate();
        frame.getContentPane().add(generator.getResult());
    }
}
