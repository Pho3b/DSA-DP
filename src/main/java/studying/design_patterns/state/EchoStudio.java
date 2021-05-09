package studying.design_patterns.state;

import studying.design_patterns.state.states.StandBy;
import studying.design_patterns.state.states.State;

public class EchoStudio {
    private State state;


    public EchoStudio() {
        this.state = new StandBy(this);
    }

    public void play() {
        this.state.play();
    }

    public void stop() {
        this.state.stop();
    }

    public void plug() {
        this.state.plug();
    }

    public void unplug() {
        this.state.unplug();
    }

    public void connect() {
        this.state.connect();
    }

    public void disconnect() {
        this.state.disconnect();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
