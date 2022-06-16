package delk.baseJave.edu.streamapi;

public class MailMessage  extends AbstractSendable<String> { //просто говорим, что MailMessage это sendable, который параметризован строкой.


 public MailMessage(String from, String to, String content) {

        super (from, to, content);
    }

}
