package Utils.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class RetryListener implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        // Use getRetryAnalyzer(ITestResult) instead of the deprecated getRetryAnalyzer()
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}

