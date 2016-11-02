package sia.spitter.remotingclients;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sia.spitter.spitterdomainjpa.Spitter;
import sia.spitter.spitterdomainjpa.Spittle;
import sia.spitter.spitterservicecommon.SpitterService;

public class SpitterRmiClient {

    public List<Spittle> getSpittles(String userName) {
        Spitter spitter = spitterService.getSpitter(userName);
        return spitterService.getSpittlesForSpitter(spitter);
    }

    @Autowired
    SpitterService spitterService;

}
