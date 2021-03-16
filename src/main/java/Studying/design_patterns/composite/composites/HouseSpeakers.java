package Studying.design_patterns.composite.composites;

import Studying.design_patterns.composite.SpeakerComponent;

import java.util.ArrayList;

public class HouseSpeakers extends SpeakerComponent {
    private ArrayList<SpeakerComponent> speakers = new ArrayList<>(5);


    public HouseSpeakers(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println("ROOM: " + this.getName() + " started");

        for (SpeakerComponent speaker : this.speakers) {
            speaker.play();
        }
    }

    @Override
    public void stop() {
        System.out.println("ROOM: " + this.getName() + " stopped");

        for (SpeakerComponent speaker : this.speakers) {
            speaker.stop();
        }
    }

    @Override
    public boolean isPlaying() {
        if (this.speakers.size() <= 0) {
            return false;
        }

        for (SpeakerComponent speaker : this.speakers) {
            if (!speaker.isPlaying()) {
                return false;
            }
        }

        return true;
    }

    public void addChild(SpeakerComponent speaker) {
        this.speakers.add(speaker);
    }

    public void removeChild(int index) {
        this.speakers.remove(index);
    }

    public SpeakerComponent getChild(int index) {
        return this.speakers.get(index);
    }
}
