import java.util.ArrayList;
import java.util.List;

public class AgriculturalProduct {
    private String productID;
    private String name;
    private String category;
    private double price;
    private int quantity;

    // Constructor
    public AgriculturalProduct(String productID, String name, String category, double price, int quantity) {
        this.productID = productID;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters for the attributes
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static void main(String[] args) {
        // Instantiate AgriculturalProduct
        AgriculturalProduct product = new AgriculturalProduct("P001", "Tomato", "Vegetables", 20.5, 100);
        System.out.println("Product Name: " + product.getName());
        System.out.println("Product Category: " + product.getCategory());
        System.out.println("Product Price: " + product.getPrice());
        System.out.println("Product Quantity: " + product.getQuantity());

        // Instantiate ProductCatalog
        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct(product);  // Add product to the catalog

        // Retrieve the product from the catalog by product ID
        AgriculturalProduct retrievedProduct = catalog.getProduct("P001");
        if (retrievedProduct != null) {
            System.out.println("Retrieved Product Name from Catalog: " + retrievedProduct.getName());
        }

        // Instantiate User
        User user = new User("U001", "JohnDoe", "password123", "customer", "johndoe@example.com");
        System.out.println("User Name: " + user.getUsername());

        // Instantiate Order
        Order order = new Order("O001", user.getUserID(), product.getProductID(), 2, product.getPrice() * 2, "2023-09-01");
        System.out.println("Order ID: " + order.getOrderID());
        System.out.println("Order Total Price: " + order.getTotalPrice());
    }
}

// ProductCatalog Class
class ProductCatalog {
    private List<AgriculturalProduct> products;

    public ProductCatalog() {
        this.products = new ArrayList<>();
    }

    public void addProduct(AgriculturalProduct product) {
        products.add(product);
    }

    public void removeProduct(String productID) {
        products.removeIf(product -> product.getProductID().equals(productID));
    }

    public AgriculturalProduct getProduct(String productID) {
        for (AgriculturalProduct product : products) {
            if (product.getProductID().equals(productID)) {
                return product;
            }
        }
        return null;
    }

    public List<AgriculturalProduct> searchProducts(String keyword) {
        List<AgriculturalProduct> results = new ArrayList<>();
        for (AgriculturalProduct product : products) {
            if (product.getName().contains(keyword) || product.getCategory().contains(keyword)) {
                results.add(product);
            }
        }
        return results;
    }
}

// User Class
class User {
    private String userID;
    private String username;
    private String password;
    private String role;
    private String contactInfo;

    public User(String userID, String username, String password, String role, String contactInfo) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.role = role;
        this.contactInfo = contactInfo;
    }

    // Getters and setters
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}

// Order Class
class Order {
    private String orderID;
    private String userID;
    private String productID;
    private int quantity;
    private double totalPrice;
    private String orderDate;

    public Order(String orderID, String userID, String productID, int quantity, double totalPrice, String orderDate) {
        this.orderID = orderID;
        this.userID = userID;
        this.productID = productID;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }

    // Getters and setters
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}