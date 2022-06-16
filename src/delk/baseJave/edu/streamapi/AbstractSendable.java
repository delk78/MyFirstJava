package delk.baseJave.edu.streamapi;

public class AbstractSendable<T> implements Sendable<T> {
    protected String to;
    protected String from;
    T content;
    public AbstractSendable(String from, String to, T content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }
    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public T getContent() {
        return content;
    }
}
