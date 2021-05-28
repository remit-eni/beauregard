package fr.acme.beauregardproject.forms;

import fr.acme.beauregardproject.entities.Brand;
import fr.acme.beauregardproject.entities.Category;
import fr.acme.beauregardproject.entities.VAT;

public class ProductForm {

    private String reference;
    private String label;
    private String description;
    private float priceExclTax;
    private String picture;
    private int stockQuantity;
    private Category category;
    private VAT vat;
    private Brand brand;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public VAT getVat() {
        return vat;
    }

    public void setVat(VAT vat) {
        this.vat = vat;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPriceExclTax() {
        return priceExclTax;
    }

    public void setPriceExclTax(float priceExclTax) {
        this.priceExclTax = priceExclTax;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
