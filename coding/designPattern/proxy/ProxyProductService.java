package designPattern.proxy;

class ProxyProductService implements ProductService {

    private RealProductService realService;
    private String userRole; // e.g. "ADMIN" or "USER"

    public ProxyProductService(String userRole) {
        this.userRole = userRole;
        this.realService = new RealProductService();
    }

    @Override
    public void viewProduct(String productId) {
        // Everyone can view
        System.out.println("[LOG] viewProduct called");
        realService.viewProduct(productId);
    }

    @Override
    public void updatePrice(String productId, double price) {
        System.out.println("[LOG] updatePrice called");

        if ("ADMIN".equalsIgnoreCase(userRole)) {
            realService.updatePrice(productId, price);
        } else {
            System.out.println("❌ Access Denied: Only ADMIN can update price");
        }
    }
}

class Main2{
    public static void main(String[] args){
        ProductService productService = new ProxyProductService("USER");
        productService.viewProduct("P1001");
        productService.updatePrice("P1001", 999.0);

        System.out.println("----");

        ProductService adminService = new ProxyProductService("ADMIN");
        adminService.viewProduct("P1001");
        adminService.updatePrice("P1001", 999.0);
    }
}
class RealProductService implements ProductService {

    @Override
    public void viewProduct(String productId) {
        System.out.println("Viewing product: " + productId);
    }

    @Override
    public void updatePrice(String productId, double price) {
        System.out.println("Updating price of " + productId + " to " + price);
    }
}
interface ProductService {
    void viewProduct(String productId);
    void updatePrice(String productId, double price);
}