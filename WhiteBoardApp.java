import javax.swing.*;

void main() {
    JFrame frame = new JFrame("WhiteBoard");

    DrawingCanvas canvas = new DrawingCanvas();
    ToolBarPanel toolBar = new ToolBarPanel(canvas);

    frame.add(toolBar, "North");
    frame.add(canvas, "Center");
    frame.setSize(1000, 700);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}