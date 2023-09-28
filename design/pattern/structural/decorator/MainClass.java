package design.pattern.structural.decorator;

public class MainClass {
    public static void main(String[] args) {
        Dress basicDress = new BasicDress();
        Dress sportyDress = new SportDress(basicDress);
        Dress fancy = new FancyDress(sportyDress);
        fancy.assemble();
        //sportyDress.assemble();
    }
}
