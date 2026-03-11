import javax.swing.*;
import java.awt.*;

class ToolBarPanel extends JPanel {
    ToolBarPanel(DrawingCanvas canvas) {
        JButton clear = new JButton("Clear");

        clear.addActionListener(e -> {
            canvas.strokes.clear();
            canvas.repaint();
        });

        add(clear);
    }
}
