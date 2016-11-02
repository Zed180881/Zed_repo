package sia.spitter.spitteremail;

import sia.spitter.spitterdomainjpa.Spittle;

public interface SpitterEmailService {
    void sendSpittleEmail(String to, Spittle spittle);
}
