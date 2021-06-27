package com.company.design.ocp;

public class Product {

    private Integer id;
    private ColorEnum color;
    private SizeEnum size;
    private PriceEnum price;

    public Product(Integer id, ColorEnum color, SizeEnum size, PriceEnum price) {
        this.id = id;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public ColorEnum getColor() {
        return color;
    }

    public SizeEnum getSize() {
        return size;
    }

    public PriceEnum getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", color=" + color +
                ", size=" + size +
                ", price=" + price +
                '}';
    }
}
