package LLD_Khauf_coder.Abstract_factory.Example2;

public class Abstract {

    interface LLD{
        void display();
    }

    interface HLD{
        void display();
    }

        class shreyanshLLD implements LLD {
            public void display(){
                System.out.println("This is shreyansh's LLD");
            }
        }

        class shreyanshHLD implements HLD {
            public void display(){
                System.out.println("This is shreyansh's HLD");
            }
        }

        class GauravLLD implements LLD {
            public void display(){
                System.out.println("This is Gaurav's LLD");
            }
        }

        class GauravHLD implements HLD {
            public void display() {
                System.out.println("This is Gaurav's HLD");
            }
        }

        interface CourseFactory {
            LLD createLLD();
            HLD createHLD();
        }

        class ShreyanshFactory implements CourseFactory {
            public LLD createLLD() {
                return new shreyanshLLD();
            }
            public HLD createHLD() {
                return new shreyanshHLD();
            }
        }


        class GauravFactory implements CourseFactory {
            public LLD createLLD() {
                return new GauravLLD();
            }
            public HLD createHLD() {
                return new GauravHLD();
            }
        }

        class factoryProducer {
            public CourseFactory getFactory(String creator) {
                if(creator.equals("shreyansh")){
                    return new ShreyanshFactory();
                } else if(creator.equals("gaurav")){
                    return new GauravFactory();
                }
                return null;
            }

            public static void main(String[] args) {
                String creator="";
                String contentType="";

                factoryProducer producer = new Abstract().new factoryProducer();
                CourseFactory factory = producer.getFactory(creator);

                if(factory != null) {
                    if(contentType.equals("LLD")) {
                        LLD lld = factory.createLLD();
                        lld.display();
                    } else if(contentType.equals("HLD")) {
                        HLD hld = factory.createHLD();
                        hld.display();
                    } else {
                        System.out.println("Invalid content type");
                    }
                } else {
                    System.out.println("Invalid creator");
                }
            }
    }


}
