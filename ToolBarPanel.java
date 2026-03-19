import javax.swing.*;

class ToolBarPanel extends JPanel {
    ToolBarPanel(DrawingCanvas canvas) {
        JButton clear = new JButton("Clear");

        clear.addActionListener(e -> {
            canvas.clearCanvas();
            canvas.repaint();
        });

        add(clear);
    }
}
