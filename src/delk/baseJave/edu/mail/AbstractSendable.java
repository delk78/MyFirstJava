package delk.baseJave.edu.mail;

public abstract class AbstractSendable implements Sendable {
    protected final String to;
    protected final String from;
    public AbstractSendable (String to, String from) {
        this.to = to;
        this.from = from;
    }
    @Override
    public String getTo () {
        return this.to;
    }
    @Override
    public String getFrom () {
        return this.from;
    }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass() ) return false;
        AbstractSendable that = (AbstractSendable) o;
        return (this.from.equals(that.from)) && (this.to.equals(that.to));
    }
}
