package LLD_Khauf_coder.Abstract_factory;

public class AbstractExample1 {
    interface Pizza{
        void prepare();
    }
    interface GarlicPizza{
        void prepare();
    }

    class IndianPizza implements Pizza{

        @Override
        public void prepare(){
            System.out.println("Preparing Indian Pizza");
        }
    }

    class IndianGarlicBreadPizza implements GarlicPizza{
        @Override
        public void prepare(){
            System.out.println("Preparing Indian Garlic Bread");
        }
    }

    class ItalianPizza implements Pizza{
        @Override
        public void prepare(){
            System.out.println("Preparing Italian Pizza");
        }
    }

    class ItalianGarlicBreadPizza implements GarlicPizza{
        @Override
        public void prepare(){
            System.out.println("Preparing Italian Garlic Bread");
        }
    }


    interface factory{
        Pizza createPizza();
        GarlicPizza createGarlicBread();
    }

        class IndianFactory implements factory{

            @Override
            public Pizza createPizza() {
                return new IndianPizza();
            }

            @Override
            public GarlicPizza createGarlicBread() {
                return new IndianGarlicBreadPizza();
            }
        }

        class ItalianFactory implements factory{

            @Override
            public Pizza createPizza() {
                return new ItalianPizza();
            }

            @Override
            public GarlicPizza createGarlicBread() {
                return new ItalianGarlicBreadPizza();
            }
        }

        class FactoryProducer{
            public factory getFactory(String country){
                if(country=="India"){
                    return new IndianFactory();
                } else if(country=="Italy"){
                    return new ItalianFactory();
                }
                return null;
            }
        }


    public static void main(String[] args) {
        String country = "India";
        FactoryProducer factoryProducer = new AbstractExample1().new FactoryProducer();
        factory pizzaFactory = factoryProducer.getFactory(country);
        Pizza pizza = pizzaFactory.createPizza();
        pizza.prepare();
        GarlicPizza garlicBread = pizzaFactory.createGarlicBread();
        garlicBread.prepare();
    }


}
