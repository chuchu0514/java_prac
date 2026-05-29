public class Main {
    public static void main(String[] args) {

        Product p1 = new Product(1001, "노트북", 1500000);
        Product p2 = new Product(1001, "게이밍 노트북", 1800000);

        if (p1.equals(p2)) {
            System.out.println("p1과 p2는 같은 상품입니다.");
        } else {
            System.out.println("p1과 p2는 다른 상품입니다.");
        }

        System.out.println("p1 hashCode : " + p1.hashCode());
        System.out.println("p2 hashCode : " + p2.hashCode());
    }
}