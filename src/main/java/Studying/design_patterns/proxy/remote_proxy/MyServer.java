package Studying.design_patterns.proxy.remote_proxy;

import java.rmi.*;

public class MyServer {
    public static void main(String[] args) {
        try {
            CompanyRepository stub = new RemoteRepository();
            Naming.rebind("rmi://localhost:5000/repo", stub);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}