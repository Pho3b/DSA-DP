package Studying.design_patterns.proxy.remote_proxy;

/**
 * Some of the most common Proxy patterns:
 * - Remote Proxy
 * - Caching Proxy
 * - Security Proxy
 */
public class RepositoryProxy implements CompanyRepository {
    CompanyRepository remoteRepo;

    /**
     * The remoteRepo object could be a computationally expensive one to retrieve,
     * or a very time consuming one either.
     * This proxy object can accomplish various tasks depending on the situation.
     */
    public RepositoryProxy() {
        this.remoteRepo = new RemoteRepository();
    }

    @Override
    public String pullNewCode(String repoName) {
        return this.remoteRepo.pullNewCode(repoName);
    }

    @Override
    public String pushCode(String commitName) {
        return this.remoteRepo.pushCode(commitName);
    }
}
