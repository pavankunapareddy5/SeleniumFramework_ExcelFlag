package listener;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import utils.TestUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {
    int count = 0;
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
            try {
                if (count == 0) {
                    TestUtils.getRunStatus();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
             for(int i=0;i<TestUtils.testCases.size();i++) {
                 if(testMethod.getName().equalsIgnoreCase(TestUtils.testCases.get(i))) {
                     annotation.setDataProvider("dataProviderForIterations");
                     annotation.setDataProviderClass(TestUtils.class);
                     annotation.setPriority(Integer.parseInt(TestUtils.priority.get(i)));
                     annotation.setDescription(TestUtils.testDescription.get(i));
                     annotation.setInvocationCount(Integer.parseInt(TestUtils.invocationCount.get(i)));
                     //sets the invocation count for all the test cases based on the excel sheet input
                     if(TestUtils.runStatus.get(i).equalsIgnoreCase("no")) {
                         annotation.setEnabled(false);
                         break;
                     }
                 }
             }
             count++;
    }
}
