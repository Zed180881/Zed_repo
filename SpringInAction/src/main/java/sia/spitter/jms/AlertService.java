package sia.spitter.jms;

import sia.spitter.spitterdomainjpa.Spittle;

public interface AlertService {
    void sendSpittleAlert(Spittle spittle);
}
