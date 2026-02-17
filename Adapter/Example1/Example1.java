package LLD_Khauf_coder.Adapter.Example1;


// New interface jo client expect kar raha hai
interface Notifier{
    void send(String message, String receiverId);
}

// ConcreteClass jo Notifier interface implement karta hai

class EmailNotifier implements Notifier{
    @Override
    public void send(String message, String receiverId) {
        // Email sending logic
        System.out.println("Email sent to "
                + receiverId
                + " | Message: "
                + message);
    }
}


class SMSNotifier implements Notifier{
    @Override
    public void send(String message, String receiverId) {
        // SMS sending logic
        System.out.println("SMS sent to "
                + receiverId
                + " | Message: "
                + message);
    }
}


// Legacy class jiska method signature different hai
class SlackClient{
    public void sendSlackMessage(String channelId, String botToken, String message){
        // Slack API call logic
        System.out.println("Slack message sent to "
                + channelId
                + " with token "
                + botToken
                + " | Message: "
                + message);
    }
}



// Adapter class jo Notifier interface implement karta hai aur SlackClient ka reference rakhta hai

class SlackAdapter implements Notifier{

    // SlackCLient can be @Autowired bhi kar sakte hai Spring me, but for simplicity we are using constructor injection here
    private SlackClient slackClient;
    private String botToken;

    // Either botToken constructor me pass karo
//    public SlackAdapter(@Value("${slack.bot.token}") String botToken) {
//        this.slackClient = new SlackClient();
//        this.botToken = botToken;
//    }

    public SlackAdapter(SlackClient slackClient) {
        this.slackClient = slackClient;
    }


//    or hardcode kr do
//    private String botToken="xys"

    @Override
    public void send(String message, String receiverId) {
        // Adapter method jo Notifier interface ke hisab se signature translate karta hai
        // aur SlackClient ke method ko call karta hai
        slackClient.sendSlackMessage(receiverId, botToken, message);
    }
}










// client

public class Example1 {

    // Notification service

    private Notifier notifier;
    public Example1(Notifier notifier) {
        this.notifier = notifier;
    }

    public void sendNotification(String message, String receiverId){
        notifier.send(message, receiverId);
    }

    public static void main(String[] args) {
        // Email notifier use karna hai
        Notifier emailNotifier = new EmailNotifier();
        Example1 emailExample = new Example1(emailNotifier);
        emailExample.sendNotification("Hello via Email!", "145863" );

        // SMS notifier use karna hai
        Notifier smsNotifier = new SMSNotifier();
        Example1 smsExample = new Example1(smsNotifier);
        smsExample.sendNotification("Hello via SMS!", "9876543210" );

        // Slack notifier use karna hai
        Notifier slackNotifier = new SlackAdapter(new SlackClient());
        Example1 slackExample = new Example1(slackNotifier);
        slackExample.sendNotification("Hello via Slack!", "general" );


    }

}
