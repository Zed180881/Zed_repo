package sia.spitter.remotingjaxwsstandalone;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sia.spitter.spitterdomainjpa.Spitter;
import sia.spitter.spitterdomainjpa.Spittle;
import sia.spitter.spitterservicecommon.SpitterService;

@Component
@WebService(serviceName = "SpitterService")
public class SpitterServiceEndpoint {
    @Autowired
    SpitterService spitterService;

    @WebMethod
    public void addSpittle(Spittle spittle) {
        spitterService.saveSpittle(spittle);
    }

    @WebMethod
    public void deleteSpittle(long spittleId) {
        spitterService.deleteSpittle(spittleId);
    }

    @WebMethod
    public List<Spittle> getRecentSpittles(int spittleCount) {
        return spitterService.getRecentSpittles(spittleCount);
    }

    @WebMethod
    public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
        return spitterService.getSpittlesForSpitter(spitter);
    }
}
