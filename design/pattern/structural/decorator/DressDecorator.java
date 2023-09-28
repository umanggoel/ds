package design.pattern.structural.decorator;

public class DressDecorator {
    private Dress dress;
    public DressDecorator(Dress dress){
        this.dress = dress;
    }

    public void decoratorAssemble(){
        this.dress.assemble();
    }

}
