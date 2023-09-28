package design.pattern.structural.decorator;

public class BasicDress implements Dress {

    @Override
    public void assemble() {
        System.out.println("Basic Dress assembled!");
    }
}
