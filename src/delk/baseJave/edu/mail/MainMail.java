package delk.baseJave.edu.mail;

public class MainMail {
    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    public static void main(String[] args) {
        Package aPackage = new Package("This one contains " + WEAPONS + "!", 20);
        MailPackage mailPackage = new MailPackage("delkTo", "delkFrom", aPackage);
        Inspector inspector = new Inspector();
        Sendable newPackage  = inspector.processMail(mailPackage);
    }
}
