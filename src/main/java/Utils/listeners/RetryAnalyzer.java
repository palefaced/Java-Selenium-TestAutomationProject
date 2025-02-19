package Utils.listeners;

import Utils.constants.Constants_Listeners;
import Utils.loggers.LoggerUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


//Този клас е отговорен за това колко пъти ще се повтори даден тест !
public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            LoggerUtils.log.info(Constants_Listeners.RETRY_TEST_MSG, iTestResult.getName(), retryCount);
            //System.out.println("Retrying test: " + iTestResult.getName() + " Attempt " + retryCount + " failed !");
            return true;
        }
        return false;
    }
}
