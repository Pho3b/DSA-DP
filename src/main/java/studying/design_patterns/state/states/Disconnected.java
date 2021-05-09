package studying.design_patterns.state.states;

import studying.design_patterns.state.EchoStudio;

public class Disconnected extends State {

    public Disconnected(EchoStudio echoStudio) {
        super(echoStudio);
    }

    @Override
    public void connect() {
        System.out.println("Echo Studio is not connected to the internet");
        echoStudio.setState(new StandBy(echoStudio));
    }

    @Override
    public void unplug() {
        System.out.println("Echo Studio has been unplugged");
        echoStudio.setState(new Unplugged(echoStudio));
    }

    @Override
    public void play() {
        System.out.println("No connection found, unable to play something");
    }
}
