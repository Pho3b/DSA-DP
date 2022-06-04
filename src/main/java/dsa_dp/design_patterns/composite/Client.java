package dsa_dp.design_patterns.composite;

import dsa_dp.design_patterns.composite.composites.HouseSpeakers;
import dsa_dp.design_patterns.composite.composites.JazzRoomSpeakers;
import dsa_dp.design_patterns.composite.composites.RockRoomSpeakers;
import dsa_dp.design_patterns.composite.leaves.GenericSpeaker;
import dsa_dp.design_patterns.composite.leaves.JazzSpeaker1;
import dsa_dp.design_patterns.composite.leaves.RockSpeaker1;
import dsa_dp.design_patterns.composite.leaves.RockSpeaker2;

public class Client {
    public SpeakerComponent speakersTree;


    public Client() {
        this.speakersTree = this.generateCompositeTee();
    }

    private SpeakerComponent generateCompositeTee() {
        HouseSpeakers houseSpeakers = new HouseSpeakers("All Speakers");
        GenericSpeaker genericSpeaker = new GenericSpeaker("Generic speaker");
        JazzRoomSpeakers jazzRoomSpeakers = new JazzRoomSpeakers("Jazz Room");
        JazzSpeaker1 jazzSpeaker1 = new JazzSpeaker1("Jazz speaker 1");
        RockRoomSpeakers rockRoomSpeakers = new RockRoomSpeakers("Rock Room");
        RockSpeaker1 rockSpeaker1 = new RockSpeaker1("Rock speaker 1");
        RockSpeaker2 rockSpeaker2 = new RockSpeaker2("Rock speaker 2");

        houseSpeakers.addChild(genericSpeaker);
        houseSpeakers.addChild(jazzRoomSpeakers);
        jazzRoomSpeakers.addChild(jazzSpeaker1);
        jazzRoomSpeakers.addChild(rockRoomSpeakers);
        rockRoomSpeakers.addChild(rockSpeaker1);
        rockRoomSpeakers.addChild(rockSpeaker2);

        return houseSpeakers;
    }
}
