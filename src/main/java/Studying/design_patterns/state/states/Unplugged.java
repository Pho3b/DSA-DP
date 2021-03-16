package Studying.design_patterns.state.states;

import Studying.design_patterns.state.EchoStudio;

public class Unplugged extends State {
    public Unplugged(EchoStudio echoStudio) {
        super(echoStudio);
    }

    @Override
    public void plug() {
        System.out.println("Echo Studio has been plugged to the current");
        echoStudio.setState(new StandBy(echoStudio));
    }
}
