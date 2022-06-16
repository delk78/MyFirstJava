package delk.baseJave.edu.streamapi;

public interface Sendable<T> {
    String getFrom();

    String getTo();

    T getContent();
}