package Utils.listeners;

import Utils.constants.Constants_Listeners;
import Utils.loggers.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


//Този клас е отговорен за това колко пъти ще се повтори даден тест !
public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            Logger.log.info(Constants_Listeners.RETRY_TEST_MSG, result.getName(), this.retryCount);
            return true;
        }
        return false;
    }
}
