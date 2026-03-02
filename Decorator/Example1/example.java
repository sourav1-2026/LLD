package LLD_Khauf_coder.Decorator.Example1;


public class example {

    public interface NotificationSender{
        void send(String message);
    }
    
    public class EmailNotification implements NotificationSender{
        
        @Override
        public void send(String message) {
            System.out.println("Sending email notification: " + message);
        }
    }
    
    public class SMSNotification implements NotificationSender{
        
        @Override
        public void send(String message) {
            System.out.println("Sending SMS notification: " + message);
        }
    }
    
    abstract class Notification{
        private NotificationSender notificationSender;

        public Notification(NotificationSender notificationSender){
            this.notificationSender = notificationSender;
        }

        abstract void sendNotification(String message);
    }
    
    public class AlertNotification extends Notification{

        public AlertNotification(NotificationSender notificationSender) {
            super(notificationSender);
        }
        
        @Override
        void sendNotification(String message) {
            System.out.println("Email Notification Manager: ");
            super.notificationSender.send(message);
        }
    }
    
    public class ReminderNotification extends Notification{

        public ReminderNotification(NotificationSender notificationSender) {
            super(notificationSender);
        }
        
        @Override
        void sendNotification(String message) {
            System.out.println("SMS Notification Manager: ");
            super.notificationSender.send(message);
        }
    }
    
    //

    public static void main(String[] args) {
        example example = new example();
        NotificationSender emailNotification = example.new EmailNotification();
        NotificationSender smsNotification = example.new SMSNotification();

        AlertNotification alertEmail=example.new AlertNotification(emailNotification);
         AlertNotification alertSMS = example.new AlertNotification(smsNotification);


        alertEmail.sendNotification("This is an email alert!");
        alertSMS.sendNotification("This is an SMS alert!");
        
    }
    
}
