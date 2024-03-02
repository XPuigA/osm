package generator;

import model.OsmMap;

public class HtmlGenerator implements Generator {

    public static int DEFAULT_WIDTH = 300;
    public static int DEFAULT_HEIGHT = 150;

    private String result;
    private OsmMap map;
    private int width;
    private int height;

    public HtmlGenerator(OsmMap map) {
        this(map, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public HtmlGenerator(OsmMap map, int width, int height) {
        this.map = map;
        this.width = width;
        this.height = height;
    }

    @Override
    public void generate() {
        SvgGenerator svgGenerator = new SvgGenerator(map, width, height);
        svgGenerator.generate();
        StringBuilder sb = new StringBuilder("<html><body>").append(svgGenerator.getResult()).append("</body></html>");
        result = sb.toString();
    }

    @Override
    public String getResult() {
        return result;
    }
}
