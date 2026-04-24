public class Main {
    public static void main(String[] args) {
        
        Battery myBattery = new Battery(50);

        System.out.println("충전 전: " + myBattery.capacity);

        myBattery.charge(10);
        System.out.println("충전 후: " + myBattery.capacity);
    }
}
