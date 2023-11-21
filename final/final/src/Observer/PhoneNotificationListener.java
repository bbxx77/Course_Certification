package Observer;

public class PhoneNotificationListener implements EventListener {
    private String phone;

    public PhoneNotificationListener(String phone) {
        this.phone = phone;
    }

    @Override
    public void update(String eventType, String res) {
        System.out.println("Save to log " + phone + ": Someone has performed " + eventType + " operation with the following file: " + res);
    }
}