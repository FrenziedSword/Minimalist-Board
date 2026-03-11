import java.util.*;
import java.awt.*;

class Stroke {
    Color color;
    int size;
    java.util.List<Point> points = new ArrayList<>();

    Stroke(Color color, int size) {
        this.color = color;
        this.size = size;
    }
}
