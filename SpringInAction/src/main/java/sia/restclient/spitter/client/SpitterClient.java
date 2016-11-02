package sia.restclient.spitter.client;

import sia.spitter.spitterdomainjpa.Spitter;
import sia.spitter.spitterdomainjpa.Spittle;

public interface SpitterClient {
    Spittle[] retrieveSpittlesForSpitter(String username);

    String postSpitter(Spitter spitter);
}
