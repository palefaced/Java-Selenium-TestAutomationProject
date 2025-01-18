package Utils.config;

public class AppConfig {
    private EnvironmentConfig environment;
    private TimeoutsConfig timeouts;
    private TestDataConfig testData;

    public EnvironmentConfig getEnvironment(){
        return this.environment;
    }

    public void setEnvironment(EnvironmentConfig environment) {
        this.environment = environment;
    }

    public TimeoutsConfig getTimeouts() {
        return timeouts;
    }

    public void setTimeouts(TimeoutsConfig timeouts){
        this.timeouts = timeouts;
    }

    public TestDataConfig getTestData() {
        return testData;
    }

    public void setTestData(TestDataConfig testData) {
        this.testData = testData;
    }
}
