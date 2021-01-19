package com.example.khadamat;

public class Service {
    private String telephone,description,ville,type_service;

    public Service() {
    }

    public Service(String telephone, String description, String ville, String type_service) {
        this.telephone = telephone;
        this.description = description;
        this.ville = ville;
        this.type_service = type_service;
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
