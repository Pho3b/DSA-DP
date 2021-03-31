package Studying.design_patterns.proxy.remote_proxy;

public interface CompanyRepository {
    public String pullNewCode(String repoName);

    public String pushCode(String commitName);
}
