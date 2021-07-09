package com.example.infs3605.Entities;

import java.util.ArrayList;

public class MeditationGuide {
    private String guideText;

    public MeditationGuide() {}

    public MeditationGuide (String guideText) {
        this.guideText = guideText;
    }


    public String getGuideText() {
        return guideText;
    }

    public void setGuideText(String guideText) {
        this.guideText = guideText;
    }

    public static ArrayList<MeditationGuide> getMeditationGuide () {
        ArrayList<MeditationGuide> meditationGuide = new ArrayList<>();

        meditationGuide.add(new MeditationGuide("'We are all visitors of this time, this place. We are just passing through. Our purpose here is to observe, to learn, to grow, to love... and then we return home.'"));
        meditationGuide.add(new MeditationGuide("Take a deep breath."));
        meditationGuide.add(new MeditationGuide("Be aware of the nature that surrounds you."));
        meditationGuide.add(new MeditationGuide("Notice the layers of internal and external sounds."));
        meditationGuide.add(new MeditationGuide("Your breathing.. your thoughts..."));
        meditationGuide.add(new MeditationGuide("the birds.. the wind..."));
        meditationGuide.add(new MeditationGuide("These sounds filter through your body day to day without you realising."));
        meditationGuide.add(new MeditationGuide("Recognise these sounds as you reconnect with nature."));
        meditationGuide.add(new MeditationGuide("Remember that you are part of this nature."));
        meditationGuide.add(new MeditationGuide("There is no ego, no agenda."));
        meditationGuide.add(new MeditationGuide("Settle in the tranquility of bathing in nature."));
        meditationGuide.add(new MeditationGuide("Feel your inner power restoring as you connect with nature."));

        return meditationGuide;
    }
}
