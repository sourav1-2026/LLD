package LLD_Khauf_coder.Abstract_factory.Example2;

public class Better {

    interface Course{
        void display();
    }

    class shreyanshLLD implements Course {
        public void display(){
            System.out.println("This is shreyansh's LLD");
        }
    }

    class shreyanshHLD implements Course {
        public void display(){
            System.out.println("This is shreyansh's HLD");
        }
    }

    class GauravLLD implements Course {
        public void display(){
            System.out.println("This is Gaurav's LLD");
        }
    }

    class GauravHLD implements Course {
        public void display() {
            System.out.println("This is Gaurav's HLD");
        }
    }

    class Factory {
        public Course createCourse(String creator, String contentType) {
            if(creator.equals("shreyansh")){
                if(contentType.equals("LLD")){
                    return new shreyanshLLD();
                } else if(contentType.equals("HLD")){
                    return new shreyanshHLD();
                }
            } else if(creator.equals("gaurav")){
                if(contentType.equals("LLD")){
                    return new GauravLLD();
                } else if(contentType.equals("HLD")){
                    return new GauravHLD();
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        String creator="";
        String contentType="";

        Factory factory = new Better().new Factory();
        Course course = factory.createCourse(creator, contentType);
        if(course != null) {
            course.display();
        } else {
            System.out.println("Invalid creator or content type");
        }
    }




}
