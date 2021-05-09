package studying.design_patterns.state.states;

import studying.design_patterns.state.EchoStudio;

public class StandBy extends State {

    public StandBy(EchoStudio echoStudio) {
        super(echoStudio);
    }

    @Override
    public void disconnect() {
        System.out.println("Echo Studio disconnected from the internet");
        echoStudio.setState(new Disconnected(echoStudio));
    }

    @Override
    public void play() {
        System.out.println("Echo Studio is playing something");
        echoStudio.setState(new PlayingSomething(echoStudio));
    }

    @Override
    public void unplug() {
        System.out.println("Echo Studio has been unplugged");
        echoStudio.setState(new Unplugged(echoStudio));
    }
}
