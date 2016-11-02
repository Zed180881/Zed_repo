package sia.spitter.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.core.support.JmsGatewaySupport;

import sia.spitter.spitterdomainjpa.Spittle;

public class AlertServiceGateway extends JmsGatewaySupport
        implements AlertService {
    public void sendSpittleAlert(final Spittle spittle) {
        getJmsTemplate().send("spittle.alert.queue",
                new MessageCreator() {
                    public Message createMessage(Session session)
                            throws JMSException {
                        return session.createObjectMessage(spittle);
                    }
                });
    }
}
