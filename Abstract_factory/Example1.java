package LLD_Khauf_coder.Abstract_factory;

import OOPS.Interface.Interface;



public class Example1 {


    class IndianPizza{
        public void prepare(){
            System.out.println("Preparing Indian Pizza");
        }
    }

    class IndianGarlicBreadPizza{
        public void prepare(){
            System.out.println("Preparing Indian Garlic Bread");
        }
    }

    class ItalianPizza{
        public void prepare(){
            System.out.println("Preparing Italian Pizza");
        }
    }

    class ItalianGarlicBreadPizza{
        public void prepare(){
            System.out.println("Preparing Italian Garlic Bread");
        }
    }

    public static void main(String[] args) {
        String country = "India";
        String category="";

        if(country=="India" &&  category=="Pizza"){
            IndianPizza pizza = new Example1().new IndianPizza();
            pizza.prepare();
        } else if(country=="India" && category=="GarlicBread"){
            IndianGarlicBreadPizza garlicBread = new Example1().new IndianGarlicBreadPizza();
            garlicBread.prepare();
        } else if(country=="Italy" && category=="Pizza"){
            ItalianPizza pizza = new Example1().new ItalianPizza();
            pizza.prepare();
        } else if(country=="Italy" && category=="GarlicBread"){
            ItalianGarlicBreadPizza garlicBread = new Example1().new ItalianGarlicBreadPizza();
            garlicBread.prepare();

        }


        // 2nd way of if else statement
        if(country=="India") {
            if (category == "Pizza") {
                IndianPizza pizza = new Example1().new IndianPizza();
                pizza.prepare();
            } else if (category == "GarlicBread") {
                IndianGarlicBreadPizza garlicBread = new Example1().new IndianGarlicBreadPizza();
                garlicBread.prepare();
            }
        }
        else{
            if (category == "Pizza") {
                ItalianPizza pizza = new Example1().new ItalianPizza();
                pizza.prepare();
            } else if (category == "GarlicBread") {
                ItalianGarlicBreadPizza garlicBread = new Example1().new ItalianGarlicBreadPizza();
                garlicBread.prepare();
            }
        }


    }
}
