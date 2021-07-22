package com.example.infs3605.Entities;

import java.util.ArrayList;

public class Rewards {
    private int rewardId;
    private String shop;
    private String url;
    private String offer;
    private String detail;
    private String qrCode;
    private int stars;

    public Rewards() {
    }

    public Rewards(int rewardId, String shop, String url, String offer, String detail, String qrCode, int stars) {
        this.rewardId = rewardId;
        this.shop = shop;
        this.url = url;
        this.offer = offer;
        this.detail = detail;
        this.qrCode = qrCode;
        this.stars = stars;
    }

    public int getRewardId() {
        return rewardId;
    }

    public void setRewardId(int rewardId) {
        this.rewardId = rewardId;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }


    public static ArrayList<Rewards> getRewards(){
        ArrayList<Rewards> rewards = new ArrayList<>();
        rewards.add(new Rewards(0, "Milbi Designs", "https://northernriverscreative.com.au/wp-content/uploads/2020/05/3584web-900xVariable.1.jpg","10% off when you spend $50 or more", "Anthony Walker is an award-winning visual artist of Queensland Aboriginal descent, a member of the Yiman and Gurreng Gurreng peoples. Through his work, he engages with the natural environment and seeks to raise awareness about the preservation of native flora and fauna. \n \nAnthony's arts practice includes painting, printmaking, photography, design, and public art. His work has been critically acclaimed for its light-hearted design and blend of colour and movement. Notable achievements include: participating in Wesfarmers Indigenous Arts Leadership Program (National Gallery of Australia), undertaking a curatorial residency at the Museum of Contemporary Art (MCA - Sydney), winning the Gold Coast Aboriginal and Torres Strait Islander Art Award, and having a solo exhibition at Melbourne’s Koorie Heritage Trust Centre.", "15023361582234017", 5));
        rewards.add(new Rewards(1, "Mara May Art", "https://images.squarespace-cdn.com/content/v1/5c3d3770d274cb951bb30455/1553937889077-ZT6ICW7Q54DRPQLQ551Y/2.Free+Spirit+2.jpg?format=1000w","15% off your first purchase", "At Mara May Art we create beautiful contemporary Aboriginal art. \n \nWhether it be an already beautifully created piece of art which Tamara was inspired to create or a commission piece you would love created that represented you, your family or your business - Mara May Art can help provide the finishing touches for you home or office. \n \nTamara wants her art to help break down barriers between indigenous and non-indigenous Australians. She hopes she can help educate and contribute to a more peaceful world where our children can all walk as one, hand in hand, no matter their skin colour or cultural identity.", "93728741683402234", 10));
        rewards.add(new Rewards(2, "Inkuntji Artists Gallery", "https://s.japingkaaboriginalart.com/wp-content/uploads/1-Eunice-Jack-Ikuntji.jpg","2 entry passes", "Ikuntji Artists is an Indigenous owned and run art centre in Haasts Bluff, Central Australia. Ikuntji Artists are represented in many national and international galleries and institutions, with artists exhibiting regularly across Australia and internationally. Their art is famous for bold colour choice, decisive brush strokes and a long legacy of internationally renowned artists. Ikuntji Artists work in an ever-expanding range of mediums, including; acrylic painting, limited edition prints, screen-printed textiles and hand-made fashion, native seed jewellery and ethical fair-trade merchandise. Ikuntji Artists currently work with numberous ethical fashion and merchandise brands, and in public art and instalations.", "18927401827363340", 20));
        rewards.add(new Rewards(3, "Dreams of Creation", "https://mk0zeqasupac6pr2dyn5.kinstacdn.com/wp-content/uploads/2015/07/big-slider-pic-test.jpg","30% off selected paintings", "Dreams of Creation provide solutions for clients when engaging with Indigenous artists and communities. Core services are Aboriginal Art leasing, Aboriginal Art commissioning, licensing, Aboriginal Art gifts & awards, Bespoke Aboriginal Art stationery. \n \nDreams of Creation have developed an approach to engaging Indigenous artists and artworks for cultural sensitivities, appropriateness, and due diligence as a guiding framework to best practice, ethical and moral standing for Indigenous Cultural Intellectual Properties and our communities. \n \nDreams of Creation is the only company in Australia that lease only Indigenous artworks that inject Culture within your workplace through the arts. This unique offering underpinning cultural communications within your workplace. Dreams of Creation proudly displays it's products as Australian Made.", "20483472356924872", 30));
        rewards.add(new Rewards(4, "Blaklash Projects", "https://static.wixstatic.com/media/4d5c06_30fa92164c6c49b99c5944699b73b290~mv2_d_6947_3168_s_4_2.png/v1/fit/w_2500,h_1330,al_c/4d5c06_30fa92164c6c49b99c5944699b73b290~mv2_d_6947_3168_s_4_2.png","30% of all graphic design services", "Blaklash Projects are a 100% Aboriginal owned creative agency that specialises in the development and delivery of exhibitions, events and bespoke creative projects that profile Aboriginal and Torres Strait Islander stories. \n \nThe team made up of Troy Casey (Kamilaroi) and Amanda Hayman (Wakka Wakka, Kalkadoon) combine their passions for the arts, events and business development to deliver custom initiatives and outcomes for clients spanning the corporate, government and higher education sectors.", "50973948710984736", 40));
        rewards.add(new Rewards(5, "mimmim", "https://i.pinimg.com/originals/f0/00/32/f0003299fbf6edef96085ac68445cc13.jpg","40% off when you spend $100 or more", "Mim Cole, a Larrakia, Wardaman and Karajarri woman, is a visual artist from Darwin, Northern Territory. Mim has been creating art since a teenager, learning techniques through practice and observation of the art-making of her mother, uncles and large artistic family. Mim is a natural artist who experiments with and applies her traditional and abstract compositions to a variety of media including painting, printmaking and a wide range of design work. Her sense of composition is particularly inspired by the rawness of ancient Aboriginal art. Mim’s creative practice, licensed under the name of Mimmim, holds a strong connection to identity, family, country, nature and community which she channels intuitively into her art. Mim enjoys pushing the boundaries of her arts practice using a mix of vibrant colours with a traditional palette to express dynamic movement in each painting and design.", "35927309398573485", 50));
        return rewards;

    }




}
