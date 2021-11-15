package view.gui;

import javax.swing.JComponent;
import java.awt.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaintCanvas extends JComponent {

    private static final Logger log = LoggerFactory.getLogger(PaintCanvas.class);

    @Override
    public void paintComponent(Graphics graphics) {
        Renderer.render((Graphics2D) graphics);
    }
}
