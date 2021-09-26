package main;

import controller.CommandController;
import controller.EventConnector;
import controller.EventConnectorImpl;
import controller.KeyboardInterface;
import controller.MouseCoordinateNormalizer;
import controller.MouseHandler;
import controller.command.CommandHistory;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import model.ShapeFactory;
import model.persistence.UserChoicesImpl;
import view.gui.Frame;
import view.gui.Gui;
import view.gui.GuiWindowImpl;
import view.gui.PaintCanvas;
import view.gui.Renderer;
import view.interfaces.GuiWindow;
import view.interfaces.UiModule;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        PaintCanvas paintCanvas = new PaintCanvas();
        GuiWindow guiWindow = new GuiWindowImpl(paintCanvas);
        UiModule uiModule = new Gui(guiWindow);
        UserChoicesImpl appState = new UserChoicesImpl(uiModule);
        EventConnector controller = new EventConnectorImpl(uiModule, appState);

        KeyboardInterface keys = new KeyboardInterface(paintCanvas, appState);
        keys.setup();

        ShapeFactory ShapeFac = new ShapeFactory(appState);
        CommandController ComController = new CommandController(ShapeFac, paintCanvas);

        MouseHandler mouse = new MouseHandler(ComController);

        paintCanvas.addMouseListener(mouse);
        controller.setup();



        //Thread.sleep(500);
    }
}
