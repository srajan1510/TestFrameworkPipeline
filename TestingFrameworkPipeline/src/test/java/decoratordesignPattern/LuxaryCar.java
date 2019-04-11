package decoratordesignPattern;

public class LuxaryCar extends Decorator{
    public LuxaryCar(Car car) {
        super(car);
    }

    @Override
    public void design(){
        super.design();
        System.out.println("Luxary Car Design");
    }
}
