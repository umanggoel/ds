package com.company.design.htmlBuider;

public class HtmlBuilder {

    private String root;
    private HtmlElement rootElement;

    public HtmlBuilder(String root) {
        this.root = root;
        this.rootElement = HtmlElement.newHtmlElement().name(root).build();
    }

    public HtmlBuilder addChild(HtmlElement htmlElement){
        rootElement.getElements().add(htmlElement);
        return this;
    }

    public HtmlBuilder addChild(String elementName, String data){
        rootElement.getElements().add(HtmlElement.newHtmlElement()
                .data(data)
                .name(elementName)
                .build());
        return this;
    }

    public HtmlElement element() {
        return rootElement;
    }

    public void updateData(String data) {
        rootElement.updateData(data);
    }

    public void clear() {
        this.rootElement = HtmlElement.newHtmlElement()
                .name(root)
                .build();
    }

    @Override
    public String toString() {
        return rootElement.toString();
    }
}
