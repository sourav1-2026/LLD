package LLD_Khauf_coder.Facade;

class Customer{
    String name;
    boolean active;

    public Customer(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public boolean validate(){
        return active;
    }
}


class Product{
    String name;
    int stock;
    double price ;

    public Product(String name, int stock, double price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public  boolean isInStock(){
        return stock>0;
    }

    public void reduceStock(){
        if(stock>0){
            stock--;
        }
    }
}

class Order{
    Customer customer;
    Product product;
    double finalPrice;

    public Order(Customer customer, Product product) {
        this.customer = customer;
        this.product = product;
    }
}

class DiscountService{
    public double applyDiscount(Product product){
        // Apply some discount logic
        return product.price * 0.9; // 10% discount
    }
}


class PaymentService{

    public boolean makePayment(double amount){
        System.out.println("Payment successful: " + amount);
        return true;
    }
}

class OrderRepository{
    public void save(Order order){
        System.out.println("Order saved for customer: " + order.customer.name);
    }
}






public class Without_facade {

    public void placeOrder(Customer customer, Product product){

        if(!customer.validate()){
            System.out.println("Customer validation failed.");
            return;
        }

        if(!product.isInStock()){
            System.out.println("Product is out of stock.");
            return;
        }

        DiscountService discountService = new DiscountService();
        double finalPrice = discountService.applyDiscount(product);

        PaymentService paymentService=new PaymentService();
        paymentService.makePayment(finalPrice);

        product.reduceStock();

        Order order = new Order(customer, product);
        OrderRepository orderRepository = new OrderRepository();

        orderRepository.save(order);

    }
}
