package dsa_dp.design_patterns;

import dsa_dp.design_patterns.proxy.remote_proxy.CompanyRepository;

import dsa_dp.design_patterns.proxy.remote_proxy.RepositoryProxy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProxyTest {

    @Test
    public void compositeIllustrativeTest() {
        CompanyRepository repo = new RepositoryProxy();

        Assertions.assertEquals(repo.pullNewCode("Data structures"),
                "Pulling code from the repo: Data structures");
        Assertions.assertEquals(repo.pushCode("Heap data structure"),
                "Pushing the Heap data structure commit");
    }
}
