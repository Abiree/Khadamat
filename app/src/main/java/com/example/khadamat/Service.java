package com.example.khadamat;

import android.media.Image;

public class Service {
    private String full_name,telephone,description,ville,type_service,rating,servicename,localisation,ImageProfile;
    private String price;
    private int imageId;

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getImageProfile() {
        return ImageProfile;
    }

    public void setImageProfile(String imageProfile) {
        ImageProfile = imageProfile;
    }

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

    public Service(String full_name, String telephone, String description, String ville, String type_service, String price,int imageId,String servicename,String localisation,String ImageProfile) {
        this.full_name=full_name;
        this.telephone = telephone;
        this.description = description;
        this.ville = ville;
        this.type_service = type_service;
        this.price=price;
        this.imageId=imageId;
        this.servicename=servicename;
        this.localisation=localisation;
        this.ImageProfile = ImageProfile;
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
