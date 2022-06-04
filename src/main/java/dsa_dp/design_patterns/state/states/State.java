package dsa_dp.design_patterns.state.states;

import dsa_dp.design_patterns.state.EchoStudio;

public abstract class State {
    public EchoStudio echoStudio;


    public State(EchoStudio echoStudio) {
        this.echoStudio = echoStudio;
    }

    public void play() {
        this.printUnableToHandle();
    }

    public void stop() {
        this.printUnableToHandle();
    }

    public void plug() {
        this.printUnableToHandle();
    }

    public void unplug() {
        this.printUnableToHandle();
    }

    public void connect() {
        this.printUnableToHandle();
    }

    public void disconnect() {
        this.printUnableToHandle();
    }

    private void printUnableToHandle() {
        System.out.println("Could Not handle this task in the current STATE ;)");
    }
}
