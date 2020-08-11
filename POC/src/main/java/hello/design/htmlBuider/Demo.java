package com.company.design.htmlBuider;

public class Demo {
    public static void main(String[] args) {
        HtmlBuilder builder = new HtmlBuilder("ul");
        builder.updateData("hello");
        HtmlBuilder nestedElement = new HtmlBuilder("ul");
        nestedElement.updateData("world");
        HtmlBuilder b =  new HtmlBuilder("li");
        b.updateData("this is deepest part of ocean");

        builder.addChild(nestedElement.addChild(b.element()).element());
        System.out.println(builder);
    }
}
