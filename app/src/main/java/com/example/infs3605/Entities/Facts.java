package com.example.infs3605.Entities;

import java.util.ArrayList;

public class Facts {

    private int factId;
    private String fact;

    public Facts (){

    }

    public Facts(int factId, String fact) {
        this.factId = factId;
        this.fact = fact;
    }

    public int getFactId() {
        return factId;
    }

    public void setFactId(int factId) {
        this.factId = factId;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    //dummy data - change once BAs have got proper data
    public static ArrayList<Facts> getFacts(){

        ArrayList<Facts> facts = new ArrayList<>();

        facts.add(new Facts(0, "The Aboriginal and Torres Strait Islander population go back to at least 50,000 years. Some argue that it is even longer than that and one theory says they migrated to Australia in boats."));
        facts.add(new Facts (1, "The earliest Indigenous art was paintings or engravings on the walls of rock shelters and caves which is called rock art. Red ochre was being used for painting at least 30,000 years ago in central Australia."));
        facts.add(new Facts (2, "The Aboriginal Flag was designed in the 1970s and its colours represent different aspects of Aboriginal life. The black symbolises Aboriginal people, the yellow represents the sun and the red represents the earth and the relationship between people and the land."));
        facts.add(new Facts (3, "First Nations People are not one homogenous group – they are a diverse group of hundreds of nations and clans within those nations. It has been estimated that around 250 languages and 600 dialects were spoken at the time of colonial invasion in 1788."));
        facts.add(new Facts (4, "Aboriginal and Torres Strait Islander art is among the oldest forms of art in the world. First Nations art has a different meaning for different groups. Colours and styles differ from one nation to another, as do the messages in the stories."));
        facts.add(new Facts (5, "The earliest Indigenous art was paintings or engravings on the walls of rock shelters and caves which is called rock art. Red ochre was being used for painting at least 30,000 years ago in central Australia."));
        facts.add(new Facts (6, "The earliest Indigenous art was paintings or engravings on the walls of rock shelters and caves which is called rock art. Red ochre was being used for painting at least 30,000 years ago in central Australia."));
        facts.add(new Facts (7, "The Dreamtime is a general term used to describe the complex network of Aboriginal spiritual beliefs, creation and existence on earth. This knowledge is passed down through generations through different stories, songs, dances and ceremonies."));
        facts.add(new Facts (8, "Torres Strait Islanders are united by their connection to the Tagai. The Tagai is the spiritual belief system that connects people to the order of the world, stating that everything has its place."));
        facts.add(new Facts (9, "One common thread that runs through Indigenous culture is reverence for the land. It’s believed that ancestor beings travelled across the country forming landmarks and places of interest out of the previously shapeless landscape."));
        facts.add(new Facts (10, "Aboriginal rock painting is the longest unbroken art tradition on Earth, with creations in the Narwala Gabarnmang rock shelter in Arnhem Land in the Northern Territory dated at 28,000 years."));
        facts.add(new Facts (11, "Djabwurrung and Jardwadjali people in Victoria had been playing Marn Grook – a variety of football using a possum hide as the ball – for years before it inspired the invention of Australian rules football."));
        facts.add(new Facts (12, "Australian Aboriginal people have no written language of their own, and so the important stories central to the people's culture are based on the traditional icons (symbols)  and information in the artwork, which go hand in hand with recounted stories, dance or song, helping to pass on vital information and preserve their culture."));
        facts.add(new Facts (13, "There are usually three different levels to an Indigenous Australian language; the children’s or ‘public’ version, a general version, and then a ceremonial/spiritual level (which can sometimes have a further three levels within that!)"));
        facts.add(new Facts (14, "Ever wonder how the U-shape came about in Aboriginal art to represent a person? It’s quite simple really – if you sit cross legged in the sand, the mark left does look a lot like a U! That’s why you will see this symbol used a lot in art from the desert."));

        return facts;
    }

}
