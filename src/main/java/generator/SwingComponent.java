package generator;

import model.OsmMap;

import java.awt.*;

public class SwingComponent extends Canvas {

    SwingGenerator generator;

    public SwingComponent(OsmMap map) {
         this(map, GeneratorDrawer.DEFAULT_WIDTH, GeneratorDrawer.DEFAULT_HEIGHT);
    }

    public SwingComponent(OsmMap map, int width, int height) {
        this.generator = new SwingGenerator(map, width, height);
    }

    @Override
    public void paint(Graphics g) {
        this.generator.setGraphics((Graphics2D) g);
        try {
            this.generator.generate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
