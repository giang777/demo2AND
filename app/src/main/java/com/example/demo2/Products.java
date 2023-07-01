package com.example.demo2;

public class Products {
    private String _id;
    private String name;
    private int price;
    private String decs;
    private String image;
    private String description;
    private String id_cat;

    public Products() {
    }

    public Products(String _id, String name, int price, String decs, String image, String description, String id_cat) {
        this._id = _id;
        this.name = name;
        this.price = price;
        this.decs = decs;
        this.image = image;
        this.description = description;
        this.id_cat = id_cat;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDecs() {
        return decs;
    }

    public void setDecs(String decs) {
        this.decs = decs;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId_cat() {
        return id_cat;
    }

    public void setId_cat(String id_cat) {
        this.id_cat = id_cat;
    }
}
