package LLD_Khauf_coder.Bridge.Example1;

public class better {

    // HOW it is done
    interface NotificationSender {
        void send(String message);
    }

    class EmailSender implements NotificationSender {
        public void send(String message) {
            System.out.println("Sending Email: " + message);
        }
    }

    class SMSSender implements NotificationSender {
        public void send(String message) {
            System.out.println("Sending SMS: " + message);
        }
    }

    // WHAT to be done
    abstract class Notification {

        protected NotificationSender sender;

        public Notification(NotificationSender sender) {
            this.sender = sender;
        }

        abstract void notifyUser(String message);
    }

    class AlertNotification extends Notification{

        public AlertNotification(NotificationSender sender){
            super(sender);
        }

        @Override
        void notifyUser(String message) {
            sender.send(message);
        }
    }

    class ReminderNotification extends Notification{

        public ReminderNotification(NotificationSender sender){
            super(sender);
        }

        @Override
        void notifyUser(String message) {
            sender.send(message);
        }
    }

    public static void main(String[] args) {
        better example = new better();

        NotificationSender emailSender = example.new EmailSender();
        NotificationSender smsSender = example.new SMSSender();

        Notification alertEmail = example.new AlertNotification(emailSender);
        Notification alertSMS = example.new AlertNotification(smsSender);

        alertEmail.notifyUser("This is an email alert!");
        alertSMS.notifyUser("This is an SMS alert!");
    }
}
