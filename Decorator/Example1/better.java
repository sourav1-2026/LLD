package LLD_Khauf_coder.Decorator.Example1;

public class better {

    interface NotificationSender {
        void send(String message);
    }

    //Base class
    class EmailNotification implements NotificationSender {

        public void send(String message){
            System.out.println("Email Sent: " + message);
        }
    }

    // Decorator class

    abstract class NotificationDecorator implements NotificationSender {

        protected NotificationSender notifier;

        public NotificationDecorator(NotificationSender notifier){
            this.notifier = notifier;
        }
    }


    class SMSNotification extends NotificationDecorator {

        public SMSNotification(NotificationSender notifier){
            super(notifier);
        }

        public void send(String message){
            notifier.send(message);
            System.out.println("SMS Sent: " + message);
        }
    }

    class BasicNotification implements NotificationSender {
        public void send(String message) {
            // do nothing
        }
    }

    public void main(String[] args) {

        NotificationSender notifier =
                new SMSNotification(
                        new EmailNotification());

        notifier.send("Server Down");
    }

}
