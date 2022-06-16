package delk.baseJave.edu.mail;

/**
 * Message with message text;
 */
public class MailMessage extends AbstractSendable {
    private final String message;
    public MailMessage (String from, String to, String message) {
        super (from, to);
        this.message = message;
    }
    public String getMessage () {
        return this.message;
    }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MailMessage that = (MailMessage) o;

        return message != null ? message.equals(that.message) : that.message == null;
    }
}
