class Product {
    private String name;
    private int price;
    private int quantity;
    static int totalProduct = 0;
    // Parameterless constructor
    Product() {
        name = "No name";
        price = 0;
        quantity = 0;
        counter();
    }
    // Parameterized constructor
    Product(String n, int p, int q) {
        name = n;
        price = p;
        quantity = q;
        counter();
    }
    // Display product information
    void getData() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
    // Increase product count
    static void counter() {
        totalProduct++;
    }
    // Return total products
    static int countProduct() {
        return totalProduct;
    }
}
public class Task03 {
    public static void main(String[] args) {
        Product p1 = new Product("Pen", 50, 10);
        Product p2 = new Product("Book", 200, 5);
        Product p3 = new Product();
        p1.getData();
        p2.getData();
        p3.getData();
        System.out.println("Total products: " + Product.countProduct());
    }
}
