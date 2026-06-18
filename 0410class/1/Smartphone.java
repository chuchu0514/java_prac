public class Smartphone {
    String model;
    String maker;
    int price;

    public Smartphone(String model, String maker, int price){
        this.model = model;
        this.maker = maker;
        this.price = price;
    }

    public Smartphone(String model, String maker){
        this.model = model;
        this.maker = maker;
        this.price = 1000000;
    }

    public void showinfo(){
        System.out.println("제조사: " + maker + ", 모델: " + model + ", 가격: " + price + "원");
    }


}
