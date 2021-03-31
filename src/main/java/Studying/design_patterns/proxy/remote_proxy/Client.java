package Studying.design_patterns.proxy.remote_proxy;

public class Client {
    CompanyRepository repo;

    public Client(CompanyRepository repo) {
        this.repo = repo;

        System.out.println();
        this.repo.pushCode("Heap data structure");
    }
}
