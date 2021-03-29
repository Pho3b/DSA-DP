package Studying.design_patterns.proxy.remote_proxy;

import java.rmi.RemoteException;

public class RepositoryProxy implements CompanyRepository {
    @Override
    public String pullNewCode(String repoName) throws RemoteException {
        return null;
    }

    @Override
    public String pushCode(String commitName) throws RemoteException {
        return null;
    }
}
