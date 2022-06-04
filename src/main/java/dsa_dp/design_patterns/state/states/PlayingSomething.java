package dsa_dp.design_patterns.state.states;

import dsa_dp.design_patterns.state.EchoStudio;

public class PlayingSomething extends State {
    public PlayingSomething(EchoStudio echoStudio) {
        super(echoStudio);
    }

    @Override
    public void stop() {
        System.out.println("Echo Studio stopped playing something");
        echoStudio.setState(new StandBy(echoStudio));
    }

    @Override
    public void disconnect() {
        System.out.println("Echo Studio disconnected from the internet");
        echoStudio.setState(new Disconnected(echoStudio));
    }

    @Override
    public void unplug() {
        System.out.println("Echo Studio has been unplugged");
        echoStudio.setState(new Unplugged(echoStudio));
    }
}
