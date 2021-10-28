package controller;

import controller.command.CommandHistory;
import model.interfaces.UserChoices;
import view.EventName;
import view.gui.PaintCanvas;
import view.interfaces.UiModule;

/**
 * @see controller.EventConnector
 */
public class EventConnectorImpl implements EventConnector {
    private final UiModule uiModule;
    private final UserChoices userChoices;
    private final CommandController CmdController;

    public EventConnectorImpl(UiModule uiModule, UserChoices userChoices, CommandController _CmdController) {
        this.uiModule = uiModule;
        this.userChoices = userChoices;
        this.CmdController = _CmdController;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        //uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> userChoices.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_SHAPE, userChoices::setActiveShape);
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, userChoices::setActivePrimaryColor);
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, userChoices::setActiveSecondaryColor);
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, userChoices::setActiveShadingType);
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, userChoices::setActiveStartAndEndPointMode);
        uiModule.addEvent(EventName.UNDO, CmdController::undo);
        uiModule.addEvent(EventName.REDO, CmdController::redo);
        uiModule.addEvent(EventName.COPY, CmdController::copy);
        uiModule.addEvent(EventName.PASTE, CmdController::paste);
    }
}
