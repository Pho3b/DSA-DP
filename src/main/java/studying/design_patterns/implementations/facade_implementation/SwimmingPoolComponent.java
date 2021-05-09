package studying.design_patterns.implementations.facade_implementation;

public abstract class SwimmingPoolComponent {
    boolean isOn = false;

    public String turnOn(){
        if(!this.isOn) {
            this.isOn = true;
            return "Component turned ON";
        }

        return "This component is already ON";
    }

    public String turnOff(){
        if(this.isOn) {
            this.isOn = false;
            return "Component turned OFF";
        }

        return "This component is already OFF";
    }

    public boolean isOn() {
        return this.isOn;
    }
}
