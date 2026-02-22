package LLD_Khauf_coder.Bridge.Example1;

public class example {

    interface NotificationSender{
        void send(String message);
    }

    class EmailSender implements NotificationSender{

        @Override
        public void send(String message) {
            System.out.println("Sending Email: " + message);
        }
    }

    class SmsSender implements NotificationSender{

        @Override
        public void send(String message) {
            System.out.println("Sending SMS: " + message);
        }
    }

    static void AlertEmailNotification(NotificationSender sender, String message){
        sender.send(message);
    }

    static void AlertSMSNotification(NotificationSender sender, String message){
//        NotificationSender sender = new example().new SmsSender();
        sender.send(message);
    }

    public static void main(String[] args) {

        NotificationSender emailSender = new example().new EmailSender();
        NotificationSender smsSender = new example().new SmsSender();

        AlertEmailNotification(emailSender,"This is an email alert!");
        AlertSMSNotification(smsSender ,"This is an SMS alert!");
    }
}
