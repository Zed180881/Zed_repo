package sia.spitter.remotingjaxrpc;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.remoting.jaxrpc.ServletEndpointSupport;

import sia.spitter.spitterdomainjpa.Spitter;
import sia.spitter.spitterdomainjpa.Spittle;
import sia.spitter.spitterservicecommon.SpitterService;

@SuppressWarnings("deprecation")
public class SpitterServiceEndpoint extends ServletEndpointSupport
        implements RemoteSpitterService {

    private SpitterService spitterService;

    protected void onInit() {
        spitterService =
                getApplicationContext().getBean(SpitterService.class);
    }

    ;

    public void addSpittle(Spittle spittle) throws RemoteException {
        spitterService.saveSpittle(spittle);
    }

    public void deleteSpittle(long spittleId) throws RemoteException {
        spitterService.deleteSpittle(spittleId);
    }

    public List<Spittle> getRecentSpittles(int spittleCount)
            throws RemoteException {
        return spitterService.getRecentSpittles(spittleCount);
    }

    public List<Spittle> getSpittlesForSpitter(Spitter spitter)
            throws RemoteException {
        return spitterService.getSpittlesForSpitter(spitter);
    }
}
