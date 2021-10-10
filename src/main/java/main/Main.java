package main;

import controller.CommandController;
import controller.CommandFactory;
import controller.EventConnector;
import controller.EventConnectorImpl;
import controller.KeyboardInterface;
import controller.MouseHandler;
import model.ShapeFactory;
import model.persistence.UserChoicesImpl;
import view.gui.Gui;
import view.gui.GuiWindowImpl;
import view.gui.PaintCanvas;
import view.interfaces.GuiWindow;
import view.interfaces.UiModule;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PaintCanvas paintCanvas = new PaintCanvas();
        GuiWindow guiWindow = new GuiWindowImpl(paintCanvas);
        UiModule uiModule = new Gui(guiWindow);
        UserChoicesImpl appState = new UserChoicesImpl(uiModule);

        ShapeFactory ShapeFac = new ShapeFactory(appState);
        CommandFactory CommandFac = new CommandFactory(ShapeFac);
        CommandController ComController = new CommandController(CommandFac, paintCanvas, appState);

        EventConnector controller = new EventConnectorImpl(uiModule, appState, ComController);

        KeyboardInterface keys = new KeyboardInterface(paintCanvas, appState);
        keys.setup();

        MouseHandler mouse = new MouseHandler(ComController);

        paintCanvas.addMouseListener(mouse);
        controller.setup();
    }
}
