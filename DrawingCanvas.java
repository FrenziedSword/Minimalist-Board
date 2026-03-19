import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

public class DrawingCanvas extends JPanel {
    
    private List<Stroke> strokes = new ArrayList<>();
    private Stroke currentStroke;

    private BufferedImage canvasImage;
    private Graphics2D g2d;

    public DrawingCanvas() {
        setBackground(Color.WHITE);

        MouseAdapter mouse = new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                currentStroke = new Stroke(Color.BLACK, 3);
                currentStroke.points.add(e.getPoint());
                strokes.add(currentStroke);
            }
            public void mouseDragged(MouseEvent e) {
                Point latestPoint = e.getPoint();
                currentStroke.points.add(latestPoint);
                if (g2d != null && currentStroke.points.size() > 1) {
                    Point previousPoint = currentStroke.points.get(currentStroke.points.size() - 2);
                    g2d.setColor(currentStroke.color);
                    g2d.setStroke(new BasicStroke(currentStroke.size, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                    g2d.drawLine(previousPoint.x, previousPoint.y, latestPoint.x, latestPoint.y);
                    repaint();
                }
            }
        };

        addMouseListener(mouse);
        addMouseMotionListener(mouse);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (canvasImage == null)    {
            canvasImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
            g2d = canvasImage.createGraphics();

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clearBuffer();
        }

        g.drawImage(canvasImage, 0, 0, null);
    }

    void clearCanvas()  {
        strokes.clear();
        if (g2d != null)    {
            clearBuffer();
            repaint();
        }
    }

    void clearBuffer()  {
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}
