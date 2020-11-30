package Studying.design_patterns.command;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<UnitCommand> unitCommandsList = new ArrayList<UnitCommand>();


    /**
     * Adds a new unitCommand to the commands list.
     *
     * @param unitCommand
     */
    public void takeUnitCommand(UnitCommand unitCommand) {
        unitCommandsList.add(unitCommand);
    }

    /**
     * Executes the previously piled commands and clears the list.
     */
    public void executeGroundUnitCommands() {
        for(UnitCommand command: unitCommandsList) {
            command.execute();
        }
    }

    /**
     * Calls the undo method on the last command list element.
     */
    public void undoLastGroundUnitCommand() {
        this.unitCommandsList.get(unitCommandsList.size() -1).undo();
        unitCommandsList.clear();
    }
}
