package sia.spitter.jmsrpc;

import sia.spitter.spitterdomainjpa.Spittle;

public interface AlertService {
    void sendSpittleAlert(Spittle spittle);
}
