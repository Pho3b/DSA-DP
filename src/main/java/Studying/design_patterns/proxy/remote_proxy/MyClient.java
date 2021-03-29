package Studying.design_patterns.proxy.remote_proxy;

import java.rmi.*;

public class MyClient {
    public static void main(String[] args) {
        try {
            CompanyRepository repo = (CompanyRepository) Naming.lookup("rmi://localhost:5000/repo");
            System.out.println(repo.pullNewCode("RMI remote Repository"));
            System.out.println(repo.pushCode("My first commit"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}