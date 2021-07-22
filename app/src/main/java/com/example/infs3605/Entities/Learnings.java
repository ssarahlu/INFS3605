package com.example.infs3605.Entities;

import java.util.ArrayList;

import com.example.infs3605.R;

public class Learnings {
    private int learningId;
    private String information;
    private String image;
    private int moduleId;

    public Learnings(){

    }

    public Learnings(int learningId, String information, String image, int moduleId) {
        this.learningId = learningId;
        this.information = information;
        this.image = image;
        this.moduleId = moduleId;
    }

    public int getLearningId() {
        return learningId;
    }

    public void setLearningId(int learningId) {
        this.learningId = learningId;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }


    //dummy data
    public static ArrayList<Learnings> getLearnings() {
        ArrayList<Learnings> learnings = new ArrayList<>();

        learnings.add(new Learnings(0, "It has life-giving powers that send conception (fertility) spirits to all the watercourses, such as billabongs, rivers, creeks and lagoons as it is in control of producing rainfall.", "https://www.kullillaart.com.au/assets/images/image12.jpg", 0));
        learnings.add(new Learnings(1, "The Rainbow Serpent is the protector of the land, its people, and the source of all life.", "https://www.kullillaart.com.au/assets/images/image12.jpg", 0 ));
        learnings.add(new Learnings(2, "Aboriginals in the Kimberley regions believe that the Rainbow Serpent places spirit-children throughout waterholes in which women will become impregnated if they wade in the water.", "https://www.kullillaart.com.au/assets/images/image12.jpg", 0 ));

        learnings.add(new Learnings(3, "<b>Goo-Goor-Gaga the Kookaburra</b> \n" +
                "\nThe Goo-Goor-Gaga the Kookaburra story teaches us a number of important values, for example: actions will always have consequences; in the midst of chaos, there is also opportunity; there is always beauty to be found in the darkness. \n", "https://cdn.shopify.com/s/files/1/0056/7931/7105/products/rsz_dsc_0042.jpg?v=1556257532", 7));
        learnings.add(new Learnings(4, "<b>Music & Dance</b> \n" +
                "\nAs with image making, Aboriginal music also unites consciousness with the invisible laws and energy patterns of nature. Music and dance are important to Aboriginal culture. They are used as part of everyday life and to mark special occasions. Songlines tell stories of the Creation and Dreamtime as Aboriginals made their journeys across the desert, while other sacred music is used in ceremonies. By singing the songs in the appropriate order indigenous Australians could navigate vast distances in the hostile desert environment.", "https://northernterritory.com/-/media/images/heroes/katherine-and-surrounds/a_performer_at_barunga_festival_near_katherine.jpg?bc=white&as=1&h=630&w=1200&crop=1&hash=E91EE8165789977337371C59DDB04E48", 7));
        learnings.add(new Learnings(5, "<b>Ceremonies</b> \n" +
                "\nMusic is an integral part of Aboriginal ceremonies, also known as corroborees. Through mime and song they tell the mythical history of their tribe. There are sacred and non-sacred ceremonies. During sacred ceremonies people from outside of the community are not allowed to attend. Non-sacred ceremonies are usually performed at night in front of the men, women and children of the tribe. A group of adult men, seated around a small fire, chant one of their ancient songs. Others through dance and song, act out different elements of the myth they are telling. Each Tribe can have leaders in both song and dance. The ‘Songman’ composed songs to describe day-to-day events as well as singing ancient songs passed down through generations. Dancers were also very important -the best dancers being highly regarded. Traditional dancing involves arm, body and foot movements and a lot of foot stamping. Dances were often imitations of the movements of animals or birds.", "https://www.walangari.com.au/wp-content/uploads/2020/04/Diramu-at-ICC-e1587940447506-550x367.jpg", 7));
        learnings.add(new Learnings(6, "<b>Instruments</b> \n" +
                "\nThe didgeridoo is a traditional Aboriginal instrument which is believed to be over 1,500 years old and the oldest wind instrument in the world. This is confirmed by its appearance in ancient paintings in caves and shelters. As part of Aboriginal culture it is used as an accompaniment to songs and chants. Traditionally, it is made from the Eucalyptus trees located in the North of Australia, which were hollowed out by termites. It consists of a long tube, without fingerholes, through which the player blows. Aboriginals try to replicate the sounds of nature like animals, wind, water, etc., within the droning sound of the didgeridoo.", "https://www.didgeproject.com/wp-content/uploads/2015/10/aboriginal-didgeridoo-player-e1451956216547.jpg", 7));

        return learnings;


    }


    }
