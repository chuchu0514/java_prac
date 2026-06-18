public class Product {
    private int id;
    private String name;
    private int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;         
        if (!(obj instanceof Product)) return false;  
        Product other = (Product) obj;         
        return this.id == other.id;            
    }

    @Override
    public int hashCode() {
        return id;
    }
}