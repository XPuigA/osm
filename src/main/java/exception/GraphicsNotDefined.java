package exception;

public class GraphicsNotDefined extends CustomException {

    public GraphicsNotDefined() {
        super("Need to provide a Graphics2D object before generating");
    }
}
