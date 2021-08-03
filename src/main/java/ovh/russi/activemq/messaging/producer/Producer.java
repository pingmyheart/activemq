package ovh.russi.activemq.messaging.producer;

public interface Producer<T> {

    void produce(T t);
}
