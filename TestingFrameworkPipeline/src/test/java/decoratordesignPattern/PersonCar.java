package decoratordesignPattern;

public class PersonCar {

    public static void main(String[] args){
        BasicCar basicCar= new BasicCar();

        Car passengerCar = new PassengerCar(basicCar);
        passengerCar.design();

        Car luxaryCar = new LuxaryCar(passengerCar);
        luxaryCar.design();




    }






}
