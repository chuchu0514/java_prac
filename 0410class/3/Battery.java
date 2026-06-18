public class Battery {
    int capacity;

    public Battery(int capacity){
        this.capacity = capacity;
    }
    public void charge(int num){
        this.capacity = capacity + num;
    }
}
