package design.pattern.structural.decorator;

public class SportDress extends DressDecorator implements Dress {

    public SportDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.decoratorAssemble();
        System.out.println("Sport Dress assembled!");
    }
}
