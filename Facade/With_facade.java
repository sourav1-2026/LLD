package LLD_Khauf_coder.Facade;


class OrderFacade {

    private DiscountService discountService =
            new DiscountService();

    private PaymentService paymentService =
            new PaymentService();

    private OrderRepository repository =
            new OrderRepository();

    public void placeOrder(Customer customer, Product product) {

        if (!customer.validate()) {
            System.out.println("Customer not valid");
            return;
        }

        if (!product.isInStock()) {
            System.out.println("Product out of stock");
            return;
        }

        double discount =
                discountService.applyDiscount(product);

        double finalPrice = product.price - discount;

        paymentService.makePayment(finalPrice);

        product.reduceStock();

        Order order =
                new Order(customer, product);

        repository.save(order);
    }
}


public class With_facade {

}
