package Utils.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

//This class implements IAnnotationTransformer from TestNG.
// The transform method is invoked for each test annotation
// It checks if the test already has a RetryAnalyzer attached, and if not, it attaches the RetryAnalyzer.
// This ensures that the retry logic is applied to your tests.
//Register the listener in testing.xml to relate it to your tests !
public class RetryListener implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}

