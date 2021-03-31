package Studying.design_patterns.proxy.remote_proxy;

import java.rmi.RemoteException;

public class RemoteRepository implements CompanyRepository {

    @Override
    public String pullNewCode(String repoName) {
        return "Pulling code from the repo: " + repoName;
    }

    @Override
    public String pushCode(String commitName) {
        return "Pushing the " + commitName + " commit";
    }
}
