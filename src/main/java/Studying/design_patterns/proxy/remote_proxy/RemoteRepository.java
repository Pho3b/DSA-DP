package Studying.design_patterns.proxy.remote_proxy;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteRepository extends UnicastRemoteObject implements CompanyRepository {

    public RemoteRepository() throws RemoteException {
        super();
    }

    @Override
    public String pullNewCode(String repoName) throws RemoteException {
        return "Pulling code from the repo: " + repoName;
    }

    @Override
    public String pushCode(String commitName) throws RemoteException {
        return "Pushing the " + commitName + " commit";
    }
}
