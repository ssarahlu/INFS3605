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
        learnings.add(new Learnings(7, "The Wayambeh The Turtle story teaches us a number of values, including: respect and follow the guidance from your elders; to accept responsibility or deal with the consequences of your actions; if you do not abide by the laws of society you will be forced to choose another path that is different from your origin.", "https://www.kullillaart.com.au/assets/images/turtle.jpg ", 6));
        learnings.add(new Learnings(8, "<b>Language is survival</b>\n" +
                "\"If our language survives, we survive as Warlpiri people. Our language keeping us strong. It’s always kept us strong.\"\n" +
                "\nWarlpiri is a central Australian language spoken primarily in the communities of Yuendumu, Lajamanu, Nyirripi and Willowra. The 2006 Census recorded just over 2500 speakers, making it one of the most spoken languages in Australia in terms of number of speakers.", "https://www.themandarin.com.au/wp-content/uploads/2019/09/Aboriginal-Tent-Embassy-in-Canberra-Parliamentary-Zone-Australia-Capital-Territory.jpg", 6));
        learnings.add(new Learnings(9, "<b>Reviving language</b>\n" +
                "Past government policies which saw people moved onto missions and children removed from families had a devastating impact on the transmission of languages and culture. In many communities the link between generations of speakers was broken and children had little or no knowledge of their first languages. Their parents were partial speakers and their grandparents were the remaining few speakers of a language that, as the Elders, they alone could pass down to the next generation.\n" +
                "\nFor others the threat of being taken away from their families meant that language was kept secret. While languages may have been lying dormant they are never lost. By drawing on the memories of Elders and historical records, languages are being recovered and revitalised for future generations.", "https://live-production.wcms.abc-cdn.net.au/69c17cde4c46a6f2c44206e662a9b4d8?impolicy=wcms_crop_resize&cropH=437&cropW=783&xPos=387&yPos=0&width=862&height=485   ", 6));
        learnings.add(new Learnings(10, "<b>Language lives on</b>\n" +
                "\nBeing able to pass on language to future generations is central to keeping language, identity and culture strong. As Tyronne Bell, Ngunnawal Traditional custodian explains, ‘You can have the stories and knowledge passed down from the elders but without language your whole cultural identity is incomplete.’ Speaking in language is also a powerful connection to ancestral spirits.", "https://www.didgeproject.com/wp-content/uploads/2015/10/aboriginal-didgeridoo-player-e1451956216547.jpg", 6));
        learnings.add(new Learnings(11, "The Tiddalik story helps to teach a number of values: the importance of our environment and the preciousness of our water resources; the value of our Elders and the importance of listening to those whose life experiences can help us make good decisions; to share and not be greedy or selfish; and the importance of teamwork.\n" +
                "\nThe story also tells of all of the animals following the instructions of a wise owl (an elder) and joining together in a ritual/ceremony in an attempt to make the frog laugh.\n" +
                "\nRituals and ceremonies are intrinsic to the First Nations People’s expression of culture.", "https://www.kullillaart.com.au/assets/full/ARTP-GCARD-DKA-FROG.jpg?20200711031150", 1));
        learnings.add(new Learnings(12, "<b>Corroborees</b>\n" +
                "A Corroboree is a ceremonial meeting of First Nations People, where they interact with the Dreamtime through music, costume, and dance. The English language doesn’t do justice to the profound epistemology of the Dreaming, which can be basically described as Aboriginal Australians’ religious-cultural worldview. The music and dancing at traditional ceremonies help pass down this rich cultural knowledge.", "https://img.theculturetrip.com/1440x/smart/wp-content/uploads/2018/05/indigenous-australians-perform-a-cultural-ceremony--malcolm-williams-_-flickr.jpg", 1));
        learnings.add(new Learnings(13, "<b>Smoking ceremonies</b>\n" +
                "Smoking ceremonies are an ancient custom that involves burning native plants. The idea behind them is to acknowledge ancestors, ward off evil spirits, and heal and cleanse the place and the participants. Research has shown that heating the leaves of Eremophila longifolia (commonly known as the Berrigan emu bush), one of the plants favoured by Aboriginal people for smoking purposes, produces a smoke with significant antimicrobial effects.", "https://img.theculturetrip.com/1440x/smart/wp-content/uploads/2018/05/indigenous-ceremony--australian-heritage-festival.jpg", 1));
        learnings.add(new Learnings(14, "<b>Body art</b>\n" +
                "Body art is an ancient tradition. Bright, creative body painting is another traditional custom that dates back millennia of Indigenous culture. The ornamentation reflects a person’s family, ancestors, social grouping and territory, and is a deeply spiritual practice, particularly around marriage ceremonies. The style of art varies greatly around the different nations that inhabit the Australian continent.\n" +
                "\nUltimately, these ancient traditions bring communities together, represent the First Nations People’s unique identity and is a way of self expression that transcends language. It is an integral component of their wellbeing.", "https://img.theculturetrip.com/1440x/smart/wp-content/uploads/2018/05/australian-kids--roderick-eime_flickr.jpg", 1));
        learnings.add(new Learnings(15, "Aboriginal people passed on stories orally as they knew no writing. Listening to the story teller was vital to reproduce the story accurately to the next generation of story-tellers. Deep listening describes the processes of deep and respectful listening to build community—a way of encouraging people to explore and learn from the ancient heritage of Aboriginal culture, knowledge and understanding.\n" +
                "\nA beautiful expression from Central Australia is \"Can they bend the knees?\" It inquires if you can sit down and truly listen, prerequisite for effectively absorbing information, but also an allusion to how information is passed on in that area: by sitting on the red earth.", "https://images.squarespace-cdn.com/content/v1/5efa97c7b484f22b9fdb9704/1611621093867-XPSKWPGECH22IJ6C9EPN/Miriam-Rose+Ungunmerr+Baumann.jpg", 4));
        learnings.add(new Learnings(16, "<b>Dadirri</b>\n" +
                "Deep listening is also called dadirri, a word from the Ngan'gikurunggurr and Ngen'giwumirri languages of the Aboriginal people of the Daly River region, 220 kilometres south of Darwin, NT. In the Wiradjuri language the word for meditation, deep listening, knowing and reflecting is Winhangadhurinya.\n" +
                "\n\"Dadirri is in everyone. It is not just an Aboriginal thing.\" — Miriam-Rose Ungunmerr-Baumann, Aboriginal writer ", "https://live-production.wcms.abc-cdn.net.au/ec5a03c03aeedc76e963d702c6b89ea8?impolicy=wcms_crop_resize&cropH=1988&cropW=2991&xPos=0&yPos=0&width=862&height=575", 4));
        learnings.add(new Learnings(17, "<b>Modern uses for deep listening</b>\n" +
                "Deep listening is at the basis of some therapeutic methods used in counselling \n" +
                "\nJennifer Thompson, founder of the Jenwakka Indigenous Counselling Service, describes deep listening as \"tapping into her ancestors, constantly listening to spirits\". \"[Dadirri is] what non-Aboriginal people would call contemplation. It's the way we sit and take time and go in deep... The Dadirri is a way to take advantage of this [healing] knowledge. It requires people to stop, look, listen and learn.\" \n", "https://religionsforpeaceaustralia.org.au/wp-content/uploads/2019/01/meditatio.jpg", 4));
        learnings.add(new Learnings(18, "<b>How you can experience dadirri</b>\n" +
                "Reserve a space regularly for about 5 minutes, in the morning or evening. Go outside if you can. Simply sit and look at and listen to the earth and environment that surrounds you.\n" +
                "\nFocus on something specific, such as a bird, a blade of grass, a clump of soil, cracked earth, a flower, bush or leaf, a cloud in the sky or a body of water, whatever you can see.\n" +
                "\nYou can also let something find you, be it a leaf, the sound of a bird, the feel of the breeze, the light on a tree trunk. There's no need to try, just wait a while.\n", "https://natureconservancy-h.assetsadobe.com/is/image/content/dam/tnc/nature/en/photos/MartuWesternAustralia.jpg?crop=240,0,2400,1320&wid=4000&hei=2200&scl=0.6", 4));
        return learnings;


    }


    }
