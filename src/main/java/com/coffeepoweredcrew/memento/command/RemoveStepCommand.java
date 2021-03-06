package com.coffeepoweredcrew.memento.command;

import com.coffeepoweredcrew.memento.WorkflowDesigner;

public class RemoveStepCommand extends AbstractWorkflowCommand {

    private final String step;

    public RemoveStepCommand(WorkflowDesigner designer, String step) {
        super(designer);
        this.step = step;
    }

    @Override
    public void execute() {
        memento = receiver.getMemento();
        receiver.removeStep(step);
    }
}
