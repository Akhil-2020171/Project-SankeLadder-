import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Slot extends Rectangle{
    Slot(int length ,int breadth){
        setHeight(length);
        setWidth(breadth);
        setFill(Color.ORANGE);
        setStroke(Color.RED);
    }   
}