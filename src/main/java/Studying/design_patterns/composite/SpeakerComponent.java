package Studying.design_patterns.composite;

public abstract class SpeakerComponent {
    private boolean isPlaying = false;
    private final String name;


    public SpeakerComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void play() {
        if (this.isPlaying) {
            System.out.println("Music is already playing for: " + this.name);
        }

        this.isPlaying = true;
        System.out.println("Music started for speaker: " + this.name);
    }

    public void stop() {
        if (!this.isPlaying) {
            System.out.println("Music is already stopped: " + this.name);
        }

        this.isPlaying = false;
        System.out.println("Music stopped for: " + this.name);
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public void removeChild(int index) {
        throw new UnsupportedOperationException();
    }

    public void addChild() {
        throw new UnsupportedOperationException();
    }

    public SpeakerComponent getChild(int index) {
        throw new UnsupportedOperationException();
    }
}
