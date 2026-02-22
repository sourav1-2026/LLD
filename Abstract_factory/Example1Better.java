package LLD_Khauf_coder.Abstract_factory;

public class Example1Better {
    interface  Pizza{
        void prepare();
    }

    class IndianPizza implements Pizza{

        @Override
        public void prepare(){
            System.out.println("Preparing Indian Pizza");
        }
    }

    class IndianGarlicBreadPizza implements Pizza{
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


    class ItalianGarlicBreadPizza implements Pizza{
        @Override
        public void prepare(){
            System.out.println("Preparing Italian Garlic Bread");
        }
    }


    class PizzaFactory{
        public Pizza createPizza(String country, String category){
            if(country=="India") {
                if (category == "Pizza") {
                    Example1.IndianPizza pizza = new Example1().new IndianPizza();
                    pizza.prepare();
                } else if (category == "GarlicBread") {
                    Example1.IndianGarlicBreadPizza garlicBread = new Example1().new IndianGarlicBreadPizza();
                    garlicBread.prepare();
                }
            }
            else if(country=="Italy") {
                if (category == "Pizza") {
                    Example1.ItalianPizza pizza = new Example1().new ItalianPizza();
                    pizza.prepare();
                } else if (category == "GarlicBread") {
                    Example1.ItalianGarlicBreadPizza garlicBread = new Example1().new ItalianGarlicBreadPizza();
                    garlicBread.prepare();
                }
            }
            return null;
        }
    }

}
