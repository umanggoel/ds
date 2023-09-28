package design.pattern.structural.decorator;

public class FancyDress extends DressDecorator implements Dress {

    public FancyDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.decoratorAssemble();
        System.out.println("Fancy Dress assembled!");
    }
}
