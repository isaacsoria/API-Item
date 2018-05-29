package Domains;

public class Item {
    private String title;
    private String category_id;
    private String currency_id;
    private int avalible_quantity;
    private String buying_mode;
    private String listing_type_id;
    private String condition;
    private String description;
    private String video_id;
    private String warranty;
    private String[] pictures;

    public Item() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(String currency_id) {
        this.currency_id = currency_id;
    }

    public int getAvalible_quantity() {
        return avalible_quantity;
    }

    public void setAvalible_quantity(int avalible_quantity) {
        this.avalible_quantity = avalible_quantity;
    }

    public String getBuying_mode() {
        return buying_mode;
    }

    public void setBuying_mode(String buying_mode) {
        this.buying_mode = buying_mode;
    }

    public String getListing_type_id() {
        return listing_type_id;
    }

    public void setListing_type_id(String listing_type_id) {
        this.listing_type_id = listing_type_id;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String[] getPictures() {
        return pictures;
    }

    public void setPictures(String[] pictures) {
        this.pictures = pictures;
    }

    //    "title":"Item de test - No Ofertar",
//            "category_id":"MLA5529",
//            "price":10,
//            "currency_id":"ARS",
//            "available_quantity":1,
//            "buying_mode":"buy_it_now",
//            "listing_type_id":"bronze",
//            "condition":"new",
//            "description": "Item:,  Ray-Ban WAYFARER Gloss Black RB2140 901  Model: RB2140. Size: 50mm. Name: WAYFARER. Color: Gloss Black. Includes Ray-Ban Carrying Case and Cleaning Cloth. New in Box",
//            "video_id": "YOUTUBE_ID_HERE",
//            "warranty": "12 months by Ray Ban",
//            "pictures":[
//    {"source":"http://upload.wikimedia.org/wikipedia/commons/f/fd/Ray_Ban_Original_Wayfarer.jpg"},
//    {"source":"http://en.wikipedia.org/wiki/File:Teashades.gif"}
//  ]

}
