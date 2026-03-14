package designPattern.proxy;

class ProxyProductService1 implements ProductService1{
    private RealProductService1 realProductService1;
    public ProxyProductService1(){
        this.realProductService1 = new RealProductService1();
    }
    @Override
    public void viewProduct(){
        realProductService1.viewProduct();
    }
}
class Main3{
    public static void main(String[] args){
        ProductService1 productService1 = new ProxyProductService1();
        productService1.viewProduct();
    }
}
class RealProductService1 implements ProductService1{
    @Override
    public void viewProduct(){
        System.out.println("RealProductService1 view");
    }
}
interface ProductService1{
    void viewProduct();
}