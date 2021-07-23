package com.example.infs3605.Entities;

import java.util.ArrayList;

import com.example.infs3605.R;

public class Learnings {
    private int learningId;
    private String information;
    private String image;
    private int moduleId;
    private String learningSubtitle;

    public Learnings(){

    }

    public Learnings(int learningId, String information, String image, int moduleId, String learningSubtitle) {
        this.learningId = learningId;
        this.information = information;
        this.image = image;
        this.moduleId = moduleId;
        this.learningSubtitle = learningSubtitle;
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

    public String getLearningSubtitle() {
        return learningSubtitle;
    }

    public void setLearningSubtitle(String learningSubtitle) {
        this.learningSubtitle = learningSubtitle;
    }

    //dummy data
    public static ArrayList<Learnings> getLearnings() {
        ArrayList<Learnings> learnings = new ArrayList<>();

//        learnings.add(new Learnings(0, "<font size=\"22\"><b>Beliefs and culture through art</b></font>\n\n" +
//                "Aboriginal art is based on the stories and knowledge that has been passed down generations and is used to communicate meaning and ideas about important cultural and spiritual beliefs. Stories behind the art are connected to individuals through family lineages which as groups become custodians for particular parts of cultural events and stories. Many cultural stories relate to traditional practices around bush survival management and land, water and bush tucker. This is passed down generations through art and has been critical to the survival for Aboriginal people. \n", "https://d2gf0xft9fx5vk.cloudfront.net/Images/Activities/Activity_Image_4324.jpg", 0));
//        learnings.add(new Learnings(1, "<font size=\"22\"><b>Ownership of art</b></font>\n\n" +
//                "Traditional Aboriginal art requires authority, knowledge, association and recognition by the artist who produces it. The stories depicted in art are very important to Aboriginals and the artists must be entitled to under traditional law as it’s origins represent their land and people. These art forms have multiple levels of interpretation and can only be deciphered accurately by the elders of the Aboriginal groups that own and understand the story in detail. Outsiders may understand some aspects of the stories but the sacred sections are withheld from description or paintings.The ownership of the contents of the paintings are so significant that it removes the need for the artist to sign. The art itself defines the origin of their groups as only few are authorised to paint them.", "https://www.kullillaart.com.au/assets/images/image12.jpg", 0 ));
//        learnings.add(new Learnings(2, "<font size=\"22\"><b>Modernising Indigenous art</b></font>\n\n" +
//                "Aboriginal art is highly valued by the contemporary arts industry and has helped Aboriginal communities share their history and culture with the modern world. Exhibitions around the world have established the unique qualities of Aboriginal art, as a striking  confluence of ancient values, modern materials and an abundant wellspring of visual language and symbols. Specialist contemporary Aboriginal art galleries have become the venues to view Aboriginal art, moving away from the emphasis on ethnographic presentation, as would have been the case in museums in the past.  The immediate future continues to look positive for Aboriginal art, though small remote communities that have contributed to its expansion continue to deal with difficult social issues and skills issues related to modernity and the environment.", "https://s.japingkaaboriginalart.com/wp-content/uploads/1-Jimmy-Pike-Rainbow-Serpent-1.jpg", 0 ));
//        learnings.add(new Learnings(3, "<font size=\"22\"><b>Goo-Goor-Gaga the Kookaburra</b></font>\n\n" +
//                "\nThe Goo-Goor-Gaga the Kookaburra story teaches us a number of important values, for example: actions will always have consequences; in the midst of chaos, there is also opportunity; there is always beauty to be found in the darkness. \n", "https://cdn.shopify.com/s/files/1/0056/7931/7105/products/rsz_dsc_0042.jpg?v=1556257532", 7));
//        learnings.add(new Learnings(4, "<font size=\"22\"><b>Music & dance</b></font>\n\n" +
//                "\nAs with image making, Aboriginal music also unites consciousness with the invisible laws and energy patterns of nature. Music and dance are important to Aboriginal culture. They are used as part of everyday life and to mark special occasions. Songlines tell stories of the Creation and Dreamtime as Aboriginals made their journeys across the desert, while other sacred music is used in ceremonies. By singing the songs in the appropriate order indigenous Australians could navigate vast distances in the hostile desert environment.", "https://northernterritory.com/-/media/images/heroes/katherine-and-surrounds/a_performer_at_barunga_festival_near_katherine.jpg?bc=white&as=1&h=630&w=1200&crop=1&hash=E91EE8165789977337371C59DDB04E48", 7));
//        learnings.add(new Learnings(5, "<font size=\"22\"><b>Ceremonies/b></font>\n\n" +
//                "\nMusic is an integral part of Aboriginal ceremonies, also known as corroborees. Through mime and song they tell the mythical history of their tribe. There are sacred and non-sacred ceremonies. During sacred ceremonies people from outside of the community are not allowed to attend. Non-sacred ceremonies are usually performed at night in front of the men, women and children of the tribe. A group of adult men, seated around a small fire, chant one of their ancient songs. Others through dance and song, act out different elements of the myth they are telling. Each Tribe can have leaders in both song and dance. The ‘Songman’ composed songs to describe day-to-day events as well as singing ancient songs passed down through generations. Dancers were also very important -the best dancers being highly regarded. Traditional dancing involves arm, body and foot movements and a lot of foot stamping. Dances were often imitations of the movements of animals or birds.", "https://www.walangari.com.au/wp-content/uploads/2020/04/Diramu-at-ICC-e1587940447506-550x367.jpg", 7));
//        learnings.add(new Learnings(6, "<font size=\"22\"><b>Instruments</b></font>\n\n" +
//                "\nThe didgeridoo is a traditional Aboriginal instrument which is believed to be over 1,500 years old and the oldest wind instrument in the world. This is confirmed by its appearance in ancient paintings in caves and shelters. As part of Aboriginal culture it is used as an accompaniment to songs and chants. Traditionally, it is made from the Eucalyptus trees located in the North of Australia, which were hollowed out by termites. It consists of a long tube, without fingerholes, through which the player blows. Aboriginals try to replicate the sounds of nature like animals, wind, water, etc., within the droning sound of the didgeridoo.", "https://www.didgeproject.com/wp-content/uploads/2015/10/aboriginal-didgeridoo-player-e1451956216547.jpg", 7));
//        learnings.add(new Learnings(7, "The Wayambeh The Turtle story teaches us a number of values, including: respect and follow the guidance from your elders; to accept responsibility or deal with the consequences of your actions; if you do not abide by the laws of society you will be forced to choose another path that is different from your origin.", "https://www.kullillaart.com.au/assets/images/turtle.jpg ", 6));
//        learnings.add(new Learnings(8, "<font size=\"22\"><b>Language is survival</b></font>\n\n" +
//                "\"If our language survives, we survive as Warlpiri people. Our language keeping us strong. It’s always kept us strong.\"\n" +
//                "\nWarlpiri is a central Australian language spoken primarily in the communities of Yuendumu, Lajamanu, Nyirripi and Willowra. The 2006 Census recorded just over 2500 speakers, making it one of the most spoken languages in Australia in terms of number of speakers.", "https://www.themandarin.com.au/wp-content/uploads/2019/09/Aboriginal-Tent-Embassy-in-Canberra-Parliamentary-Zone-Australia-Capital-Territory.jpg", 6));
//        learnings.add(new Learnings(9, "<font size=\"22\"><b>Reviving language</b></font>\n\n" +
//                "Past government policies which saw people moved onto missions and children removed from families had a devastating impact on the transmission of languages and culture. In many communities the link between generations of speakers was broken and children had little or no knowledge of their first languages. Their parents were partial speakers and their grandparents were the remaining few speakers of a language that, as the Elders, they alone could pass down to the next generation.\n" +
//                "\nFor others the threat of being taken away from their families meant that language was kept secret. While languages may have been lying dormant they are never lost. By drawing on the memories of Elders and historical records, languages are being recovered and revitalised for future generations.", "https://live-production.wcms.abc-cdn.net.au/69c17cde4c46a6f2c44206e662a9b4d8?impolicy=wcms_crop_resize&cropH=437&cropW=783&xPos=387&yPos=0&width=862&height=485   ", 6));
//        learnings.add(new Learnings(10, "<font size=\"22\"><b>Language lives on</b></font>\n\n" +
//                "\nBeing able to pass on language to future generations is central to keeping language, identity and culture strong. As Tyronne Bell, Ngunnawal Traditional custodian explains, ‘You can have the stories and knowledge passed down from the elders but without language your whole cultural identity is incomplete.’ Speaking in language is also a powerful connection to ancestral spirits.", "https://www.didgeproject.com/wp-content/uploads/2015/10/aboriginal-didgeridoo-player-e1451956216547.jpg", 6));
//        learnings.add(new Learnings(11, "The Tiddalik story helps to teach a number of values: the importance of our environment and the preciousness of our water resources; the value of our Elders and the importance of listening to those whose life experiences can help us make good decisions; to share and not be greedy or selfish; and the importance of teamwork.\n" +
//                "\nThe story also tells of all of the animals following the instructions of a wise owl (an elder) and joining together in a ritual/ceremony in an attempt to make the frog laugh.\n" +
//                "\nRituals and ceremonies are intrinsic to the First Nations People’s expression of culture.", "https://www.kullillaart.com.au/assets/full/ARTP-GCARD-DKA-FROG.jpg?20200711031150", 1));
//        learnings.add(new Learnings(12, "<font size=\"22\"><b>Corroborees/b></font>\n\n" +
//                "A Corroboree is a ceremonial meeting of First Nations People, where they interact with the Dreamtime through music, costume, and dance. The English language doesn’t do justice to the profound epistemology of the Dreaming, which can be basically described as Aboriginal Australians’ religious-cultural worldview. The music and dancing at traditional ceremonies help pass down this rich cultural knowledge.", "https://img.theculturetrip.com/1440x/smart/wp-content/uploads/2018/05/indigenous-australians-perform-a-cultural-ceremony--malcolm-williams-_-flickr.jpg", 1));
//        learnings.add(new Learnings(13, "<font size=\"22\"><b>Smoking ceremonies</b></font>\n\n" +
//                "Smoking ceremonies are an ancient custom that involves burning native plants. The idea behind them is to acknowledge ancestors, ward off evil spirits, and heal and cleanse the place and the participants. Research has shown that heating the leaves of Eremophila longifolia (commonly known as the Berrigan emu bush), one of the plants favoured by Aboriginal people for smoking purposes, produces a smoke with significant antimicrobial effects.", "https://img.theculturetrip.com/1440x/smart/wp-content/uploads/2018/05/indigenous-ceremony--australian-heritage-festival.jpg", 1));
//        learnings.add(new Learnings(14, "<font size=\"22\"><b>Body art</b></font>\n\n" +
//                "Body art is an ancient tradition. Bright, creative body painting is another traditional custom that dates back millennia of Indigenous culture. The ornamentation reflects a person’s family, ancestors, social grouping and territory, and is a deeply spiritual practice, particularly around marriage ceremonies. The style of art varies greatly around the different nations that inhabit the Australian continent.\n" +
//                "\nUltimately, these ancient traditions bring communities together, represent the First Nations People’s unique identity and is a way of self expression that transcends language. It is an integral component of their wellbeing.", "https://img.theculturetrip.com/1440x/smart/wp-content/uploads/2018/05/australian-kids--roderick-eime_flickr.jpg", 1));
//        learnings.add(new Learnings(15, "Aboriginal people passed on stories orally as they knew no writing. Listening to the story teller was vital to reproduce the story accurately to the next generation of story-tellers. Deep listening describes the processes of deep and respectful listening to build community—a way of encouraging people to explore and learn from the ancient heritage of Aboriginal culture, knowledge and understanding.\n" +
//                "\nA beautiful expression from Central Australia is \"Can they bend the knees?\" It inquires if you can sit down and truly listen, prerequisite for effectively absorbing information, but also an allusion to how information is passed on in that area: by sitting on the red earth.", "https://images.squarespace-cdn.com/content/v1/5efa97c7b484f22b9fdb9704/1611621093867-XPSKWPGECH22IJ6C9EPN/Miriam-Rose+Ungunmerr+Baumann.jpg", 4));
//        learnings.add(new Learnings(16, "<font size=\"22\"><b>Dadirri</b></font>\n\n" +
//                "Deep listening is also called dadirri, a word from the Ngan'gikurunggurr and Ngen'giwumirri languages of the Aboriginal people of the Daly River region, 220 kilometres south of Darwin, NT. In the Wiradjuri language the word for meditation, deep listening, knowing and reflecting is Winhangadhurinya.\n" +
//                "\n\"Dadirri is in everyone. It is not just an Aboriginal thing.\" — Miriam-Rose Ungunmerr-Baumann, Aboriginal writer ", "https://live-production.wcms.abc-cdn.net.au/ec5a03c03aeedc76e963d702c6b89ea8?impolicy=wcms_crop_resize&cropH=1988&cropW=2991&xPos=0&yPos=0&width=862&height=575", 4));
//        learnings.add(new Learnings(17, "<font size=\"22\"><b>Modern uses for deep listening</b></font>\n\n" +
//                "Deep listening is at the basis of some therapeutic methods used in counselling \n" +
//                "\nJennifer Thompson, founder of the Jenwakka Indigenous Counselling Service, describes deep listening as \"tapping into her ancestors, constantly listening to spirits\". \"[Dadirri is] what non-Aboriginal people would call contemplation. It's the way we sit and take time and go in deep... The Dadirri is a way to take advantage of this [healing] knowledge. It requires people to stop, look, listen and learn.\" \n", "https://religionsforpeaceaustralia.org.au/wp-content/uploads/2019/01/meditatio.jpg", 4));
//        learnings.add(new Learnings(18, "<font size=\"22\"><b>How you can experience dadirri</b></font>\n\n" +
//                "Reserve a space regularly for about 5 minutes, in the morning or evening. Go outside if you can. Simply sit and look at and listen to the earth and environment that surrounds you.\n" +
//                "\nFocus on something specific, such as a bird, a blade of grass, a clump of soil, cracked earth, a flower, bush or leaf, a cloud in the sky or a body of water, whatever you can see.\n" +
//                "\nYou can also let something find you, be it a leaf, the sound of a bird, the feel of the breeze, the light on a tree trunk. There's no need to try, just wait a while.\n", "https://natureconservancy-h.assetsadobe.com/is/image/content/dam/tnc/nature/en/photos/MartuWesternAustralia.jpg?crop=240,0,2400,1320&wid=4000&hei=2200&scl=0.6", 4));
//        learnings.add(new Learnings(19, "The Girawu the Goanna story helps to teach a number of values, including: (1) the story represents the company’s Murrumbidgee-region heritage, its guiding principles of supporting the local Indigenous community and a focus on supporting, mentoring and placing women in male-dominated industries such as ICT; (2) do not be greedy with your resources, as abundant as they may be they may not last forever; (3) to share equally or be generous with your possession to foster a healthy family and community; (4) he principle of karma, what you give to others is what you will receive in return.", "https://s.japingkaaboriginalart.com/wp-content/uploads/Soloman-Jap-012495.jpg", 5));
//        learnings.add(new Learnings(20, "<font size=\"22\"><b>The Jin of Wirajiduri People</b></font>\n\n" +
//                "Spiritual beliefs were organised around sacred sites connected to heros known as jin. There are at least 18 Wiradjuri jin known, however it is likely that there were many more. Each is connected to an animal or plant and each person inherits their jin from their mother and is then responsible for caring for the sacred sites associated with the jin. People learnt the stories, songs and dances of their jin. Social practices including marriage were regulated by jin and people could not eat or damage their jin. Jin no longer regulates the marriage system, but the basic principle of preventing close marriage still applies. Also, many people still know their totems (jin animals) and avoid eating or damaging them. ", "https://s.japingkaaboriginalart.com/wp-content/uploads/Mary-Jap-011216-1.jpg", 5));
//        learnings.add(new Learnings(21, "Wiradjuri society was built around religion and spirituality. The creator gave the laws for behaviour and custodianship of the land. With the Wiradjuri kinship system being born of the Ancestors of the Dreaming and is amongst the most complex systems in the world. Based on the concept of reciprocity and are all-embracing, tying the human world to the physical world and sacred worlds. Defining an individual’s position within the immediate and extended family as well as the wider community, determine the rights, obligations and appropriate behaviours of kinship relations.", "https://maryknollogc.org/sites/default/files/field/image/miliwanga_photo.jpg", 5));
//        learnings.add(new Learnings(22, "It was the women of the group who were responsible for teaching the very young children. Children learnt about life and ceremonies as they helped with the daily work. They would learn how to hunt and gather food by helping the women and men. As the children grew older they were taught more and more of the group’s secrets.\n" +
//                "\nFor the boys initiation was carried out in a large ceremony. Invitations would be sent to neighbouring groups and even to other nations. Planning and preparation took many months. The ceremonial ground was prepared by clearing and marking trees. Guests arrived and camped facing their country. The young boys were taken into the bush for training, testing and initiation into the next level of knowledge. Each boy would go through several initiations in their life before adulthood.", "https://www.sbs.com.au/nitv/sites/sbs.com.au.nitv/files/styles/full/public/15-09-2015_2-19-44_pm.jpg?itok=ZqzZ9RI4", 5));
//

        return learnings;


    }


    }
