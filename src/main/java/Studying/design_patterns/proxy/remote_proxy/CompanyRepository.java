package Studying.design_patterns.proxy.remote_proxy;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CompanyRepository extends Remote {
    public String pullNewCode(String repoName) throws RemoteException;

    public String pushCode(String commitName) throws RemoteException;
}
