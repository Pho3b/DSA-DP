package Studying.design_patterns.proxy.remote_proxy;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class RepositoryProxy implements CompanyRepository {

    public static void main(String[] args) {
        try {
            CompanyRepository repoProxy = (CompanyRepository) Naming.lookup("rmi://localhost:5000/remoteRepo");
            System.out.println(repoProxy.pullNewCode("RMI remote Repository"));
            System.out.println(repoProxy.pushCode("My first commit"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String pullNewCode(String repoName) throws RemoteException {
        return null;
    }

    @Override
    public String pushCode(String commitName) throws RemoteException {
        return null;
    }
}
