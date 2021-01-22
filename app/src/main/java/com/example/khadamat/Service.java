package com.example.khadamat;

public class Service {
    private String full_name,telephone,description,ville,type_service,rating;
    private String price;
    private int imageId;

    public Service() {
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getRating() {
        return rating;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Service(String full_name, String telephone, String description, String ville, String type_service, String price,int imageId) {
        this.full_name=full_name;
        this.telephone = telephone;
        this.description = description;
        this.ville = ville;
        this.type_service = type_service;
        this.price=price;
        this.imageId=imageId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getType_service() {
        return type_service;
    }

    public void setType_service(String type_service) {
        this.type_service = type_service;
    }
}
