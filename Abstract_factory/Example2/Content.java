package LLD_Khauf_coder.Abstract_factory.Example2;

public class Content {

    class shreyanshLLD {
        public void display(){
            System.out.println("This is shreyansh's LLD");
        }
    }

    class shreyanshHLD{
        public void display(){
            System.out.println("This is shreyansh's HLD");
        }
    }

    class GauravLLD {
        public void display(){
            System.out.println("This is Gaurav's LLD");
        }
    }

    class GauravHLD {
        public void display() {
            System.out.println("This is Gaurav's HLD");
        }
    }

    public static void main(String[] args) {
        String creator="";
        String contentType="";

        if(creator=="shreyansh"){
            if(contentType=="LLD"){
                shreyanshLLD shreyanshLLD = new Content().new shreyanshLLD();
                shreyanshLLD.display();
            } else if(contentType=="HLD"){
                shreyanshHLD shreyanshHLD = new Content().new shreyanshHLD();
                shreyanshHLD.display();
            }
        } else if(creator=="gaurav"){
            if(contentType=="LLD"){
                GauravLLD gauravLLD = new Content().new GauravLLD();
                gauravLLD.display();
            } else if(contentType=="HLD"){
                GauravHLD gauravHLD = new Content().new GauravHLD();
                gauravHLD.display();
            }
        }
    }
}
