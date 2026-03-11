import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class DrawingCanvas extends JPanel {
    
    java.util.List<Stroke> strokes = new ArrayList<>();
    Stroke currentStroke;

    DrawingCanvas() {
        setBackground(Color.WHITE);

        MouseAdapter mouse = new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                currentStroke = new Stroke(Color.BLACK, 3);
                currentStroke.points.add(e.getPoint());
                strokes.add(currentStroke);
            }
            public void mouseDragged(MouseEvent e) {
                currentStroke.points.add(e.getPoint());
                repaint();
            }
        };

        addMouseListener(mouse);
        addMouseMotionListener(mouse);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        for(Stroke s : strokes) {
            g2.setColor(s.color);
            g2.setStroke(new BasicStroke(s.size));

            for(int i = 1; i < s.points.size(); i++) {
                Point p1 = s.points.get(i - 1);
                Point p2 = s.points.get(i);

                g2.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
    }
}
