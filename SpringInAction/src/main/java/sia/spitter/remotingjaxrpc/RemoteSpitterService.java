package sia.spitter.remotingjaxrpc;

import java.rmi.RemoteException;
import java.util.List;

import sia.spitter.spitterdomainjpa.Spitter;
import sia.spitter.spitterdomainjpa.Spittle;

interface RemoteSpitterService {
    void addSpittle(Spittle arg0) throws RemoteException;

    void deleteSpittle(long arg0) throws RemoteException;

    List<Spittle> getRecentSpittles(int arg0) throws RemoteException;

    List<Spittle> getSpittlesForSpitter(Spitter arg0) throws RemoteException;
}
