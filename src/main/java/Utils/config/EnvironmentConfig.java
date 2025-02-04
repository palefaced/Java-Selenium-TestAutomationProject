package Utils.config;

import java.util.List;

public class EnvironmentConfig {
    private String baseUrl;
    private String browser;
    private boolean headless;
    public List<String> arguments;

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBrowser(){
        return  this.browser;
    }

    public void setBrowser(String browser){
        this.browser = browser;
    }

    public boolean getHeadless(){
        return this.headless;
    }

    public void setHeadless(boolean headless) {
        this.headless = headless;
    }

    public List<String> getArguments() {
        return arguments;
    }

    public void setArguments(List<String> arguments){
        this.arguments = arguments;
    }
}
