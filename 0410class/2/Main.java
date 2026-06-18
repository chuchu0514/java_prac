public class Main {
    public static void main(String[] args) {
        Cat [] cats;
        cats = new Cat[8];

        for(int i = 0;i < 8; i++){
            cats[i] = new Cat("나비"+(i+1));
            System.out.println(cats[i].name);

        }
    }    
}
