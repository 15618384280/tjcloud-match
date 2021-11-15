package com.tjcloud.face.utils;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public final class TopicProducer {

    public static final  String QUEUE_NAME = "mq.schoolattendance.edualarm.msg.topic";
    public static final String MQ_URL =
            "failover:tcp://180.166.84.65:61616" //sywgy
            //"failover:tcp://139.196.250.208:61616"  //njjpsyxx
            ;

    private static final TopicProducer INSTANCE = new TopicProducer();
    private TopicProducer(){}
    public static TopicProducer getInstance(){
        return INSTANCE;
    }
    private int count = 0;

    public String producer(String message) throws JMSException {
        ConnectionFactory factory = null;
        Connection connection = null;
        Session session = null;
        MessageProducer producer = null;
        try {

            factory = new ActiveMQConnectionFactory("admin ","admin",MQ_URL);

            connection = factory.createConnection();

            connection.start();

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createTopic(QUEUE_NAME);
            producer = session.createProducer(destination);
            TextMessage textMessage = session.createTextMessage(message );

            producer.send(textMessage);
            return "msg send succ";
        } catch(Exception ex){
            throw ex;
        } finally {
            if(producer != null){
                producer.close();
            }

            if(session != null){
                session.close();
            }

            if(connection != null){
                connection.close();
            }
        }
    }
}
