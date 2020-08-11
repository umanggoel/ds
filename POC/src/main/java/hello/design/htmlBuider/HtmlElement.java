package com.company.design.htmlBuider;

import java.util.ArrayList;
import java.util.List;

public class HtmlElement {

    private String name;
    private List<HtmlElement> elements;
    private String data;

    private HtmlElement(Builder builder) {
        this.name = builder.name;
        this.elements = builder.elements;
        this.data = builder.data;
    }

    public static Builder newHtmlElement() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public List<HtmlElement> getElements() {
        return elements;
    }

    public String getData() {
        return data;
    }

    public void updateData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HtmlElement{" +
                "name='" + name + '\'' +
                ", elements=" + elements +
                ", data='" + data + '\'' +
                '}';
    }

    public static final class Builder {
        private String name;
        private List<HtmlElement> elements = new ArrayList<>();
        private String data;

        private Builder() {
        }

        public HtmlElement build() {
            return new HtmlElement(this);
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder elements(List<HtmlElement> elements) {
            this.elements = elements;
            return this;
        }

        public Builder data(String data) {
            this.data = data;
            return this;
        }
    }
}
