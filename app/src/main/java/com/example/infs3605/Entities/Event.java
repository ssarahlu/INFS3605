package com.example.infs3605.Entities;

import com.example.infs3605.R;

import java.util.ArrayList;

public class Event {

    private int eventId;
    private String eventImage;
    private String eventName;
    private String eventDate;
    private String eventLink;
    private String eventDesc;
    private String eventLoc;


    public Event (int eventId, String eventImage, String eventName, String eventDate, String eventLink, String eventDesc, String eventLoc) {
        this.eventId = eventId;
        this.eventImage = eventImage;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLink = eventLink;
        this.eventDesc = eventDesc;
        this.eventLoc = eventLoc;
    }

    public int getEventId() {return eventId;}

    public void setEventId (int eventId) {this.eventId = eventId;}

    public String getEventImage() {
        return eventImage;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventLink() {
        return eventLink;
    }

    public void setEventLink(String eventLink) {
        this.eventLink = eventLink;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public String getEventLoc() {
        return eventLoc;
    }

    public void setEventLoc(String eventLoc) {
        this.eventLoc = eventLoc;
    }



    public static ArrayList<Event> getEventList() {
        ArrayList<Event> eventList = new ArrayList<>();

        eventList.add(new Event(1,
                "National%20Aboriginal%20and%20Torres%20Strait%20Islander%20Children%27s%20Day.jpg?itok=k9KobBbH",
                "National Children's Day","4 Aug 2021",
                "national-aboriginal-and-torres-strait-islander-childrens-day",
                "The Children's Day 2021 theme highlights the importance of supporting strong family and community connections to help Indigenous children achieve strong spiritual and cultural wellbeing and to form proud cultural identities.\n" +
                        "\n" +
                        "Children's Day is a time to for Aboriginal and Torres Strait Islander families to celebrate the strengths and culture of their children. It is an opportunity for all Australians to show their support for Aboriginal and Torres Strait Islander children, as well as learn about the crucial impact that culture, family and community play in the life of every child.",
                "Indigenous Business Australia, Goulburn Street, Sydney NSW"));
        eventList.add(new Event(2,
                "NIMA.JPG?itok=omlsyPup",
                "National Indigenous Music Awards","7 Aug 2021",
                "national-indigenous-music-awards-0",
                "Join us for an amazing line up of some of the countries leading musicians to celebrate live the achievements of Australia's First Nation Musicians.\n" +
                        "\n" +
                        "The National Indigenous Music Awards (NIMAs) are recognised as one of Australia’s most prominent Indigenous music awards and have been celebrating Australian music for 16 years.\n" +
                        "\n" +
                        "The NIMAs showcase the rich musical landscape of Australia and highlight the music coming from all corners of the country. The Awards bring together acts who are yet to make their mark on the world alongside those who have achieved international acclaim, such as Gurrumul & Jessica Mauboy.\n" +
                        "\n" +
                        "Held annually under the stars at Darwin’s historic Amphitheatre, The NIMAS bring audiences from all over Australia together to applaud the winners, enjoy the performances and soak up the ambiance of a night for music lovers of all ages and all cultures. Musicians such as Yothu Yindi, Gurrumul, The Tableland Drifters, Warren H. Williams and Arnhem Land rockstars Saltwater Band have performed and won awards as well.",
                "Darwin Amphitheatre, Geranium Street, The Gardens NT"));
        eventList.add(new Event(3,
                "Grace-Rosendale-Seed-Pods-1400.jpg?itok=RkP8iPQw",
                "Piinpi: Contemporary Indigenous Fashion","20 Feb 2021 to 8 Aug 2021",
                "piinpi-contemporary-indigenous-fashion",
                "Featuring the work of around 60 Indigenous artists and designers from the inner city to remote desert art centres, Piinpi: Contemporary Indigenous Fashion celebrates Australia’s leading First Nations creatives.\n" +
                        "\n" +
                        "Originally curated by Bendigo Art Gallery, this exhibition is currently on display at the National Museum of Australia as part of its national tour.\n" +
                        "\n" +
                        "Piinpi is an expression that Kanichi Thampanyu (First Nations people from the East Cape York Peninsula) use to describe changes in the landscape across time and space. The exhibition explores the way understandings of Country and culture are reflected in and inspire contemporary Indigenous textile and fashion design.\n" +
                        "\n" +
                        "Piinpi: Contemporary Indigenous Fashion will be on display in the Focus Gallery at the National Museum of Australia from 19 February until 8 August 2021. Entry is free.",
                "National Museum of Australia, Lawson Crescent, Acton ACT"));
        eventList.add(new Event(4,
                "DAAF%232-min.jpg?itok=_b6eOAO9",
                "Darwin Aboriginal Art Fair","6 Aug 2021 to 11 Aug 2021",
                "darwin-aboriginal-art-fair-0",
                "The Digital Fair will be open to the public from 10am ACST on Friday, 6 August, through to 5pm ACST on Wednesday, 11 August.\n" +
                        "\n" +
                        "The public program will continue, reimagined in the digital space with online Artist Masterclasses and more. Updated details and timings are to come. Ticket holders for any of the Artist Masterclasses will be contacted directly.\n" +
                        "\n" +
                        "At this point, we are hopeful that we can continue to deliver the National Indigenous Fashion Awards and Country to Couture runway as vibrant and COVID Safe events. These will go ahead, subject to advice from the relevant authorities.",
                "Sydney Harbour Bridge, Sydney Harbour Bridge, Sydney NSW"));
        eventList.add((new Event(5,
                "20210105_SLQ_Shirts_0916lr.jpg?itok=Fe93D4Wt",
                "Deadly Threads: Where did you get that shirt?","16 Apr 2021 to 11 Aug 2021",
                "deadly-threads-where-did-you-get-shirt",
                "Deadly Threads is a showcase examining Indigenous shirts – born from protests in the 1970s and evolving as permanent mainstays in wardrobes across Australia.  \n" +
                        "\n" +
                        "In Deadly Threads, see over 190 Aboriginal and Torres Strait Islander designed singlets, t-shirts, polo shirts, and jerseys. \n" +
                        "\n" +
                        "From colourful sporting jerseys to protest and artists' shirts, Deadly Threads looks at how the shirts have helped people freely express views, support community, show allegiances and champion causes.  \n" +
                        "\n" +
                        "Explore the origins and significance of the shirts and how they have become important symbols of identity, celebration and unity. Also, learn more about the regional companies and artists that have emerged as part of the flourishing Indigenous shirt business. ",
                "State Library of Queensland, Stanley Place, South Brisbane QLD")));
        eventList.add((new Event(6,
                "INDIGOV15%20%281%29.png?itok=CsM0YU4T",
                "Developing Northern Australia","16 Aug 2021 to 18 Aug 2021",
                "2021-developing-northern-australia-conference",
                "The Developing Northern Australia Conference provides a platform to unite leaders, decision makers, industry representatives and community members working to advance our northern regions.\n" +
                        "\n" +
                        "This long-standing event is designed for you to network with key industry leaders, and share research, developments and case-studies contributing to the advancement of northern Australia.\n" +
                        "\n" +
                        "Place yourself before key decision makers and share your successes, challenges, and ideas for change.",
                "Darwin Convention Centre, Stokes Hill Road, Darwin City NT")));
        eventList.add((new Event(7,
                "Untitled%20design%20%283%29_0.png?itok=rQEhcZvG",
                "Cairns Indigenous Art Fair","17 Aug 2021 to 22 Aug 2021",
                "cairns-indigenous-art-fair-1",
                "The Cairns Indigenous Art Fair will go ahead this August!\n" +
                        "\n" +
                        "From the 17-22 August, delight in discovering the richness of Queensland’s Aboriginal and Torres Strait Islander cultures in a series of art installations, performances and festivals across Cairns.\n" +
                        "\n" +
                        "From the Art Fair and Market, to cultural dances and performances, to the Pitchas After Dark Film Festival and a staging of Othello, there is something for everyone to immerse themselves in.\n" +
                        "\n" +
                        "Most of the activations are free; however, some will have ticketed entry.",
                "Cairns QLD")));
        eventList.add((new Event(8,
                "ILF%202021%20-%20thumbnail.jpg?itok=Sbn-FZ-Z",
                "Indigenous Literacy Day","1 Sep 2021",
                "event/indigenous-literacy-day-0",
                "In 2021, we are extending this incredible celebration to a full day of events and activities. Mark Wednesday 1 September in your calendar and we'll be releasing an event program shortly.\n" +
                        "\n" +
                        "If you missed the celebrations in 2020, you can still access the two Indigenous Literacy Day events on our YouTube channel here. An estimated Australian wide audience of over 500,000 tuned in on Indigenous Literacy Day 2020 - a record-breaking event for a charity who pre-COVID, had hosted the annual celebration at the Sydney Opera House with a few hundred participants including students from remote communities.\n" +
                        "\n" +
                        "The ILD Main Event is a 40-minute visual story, sharing insights from ILF ambassadors and supporters such as Anita Heiss, Andy Griffiths and Archie Roach and a stunning performance of My Island Home by Jessica Mauboy. Viewers can access the full video or short segments of the video on our YouTube Channel."
                ,"Sydney Opera House, Bennelong Point, Sydney NSW")));



        /*
        new insert template
        eventList.add((new Event(
                "",
                "","",
                "",
                "")));
         */

        return eventList;
    }


}

