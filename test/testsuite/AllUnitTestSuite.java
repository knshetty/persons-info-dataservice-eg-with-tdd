package testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import models.PersonModelTest;
import datasources.CsvDataProviderTest;
import datasources.DummyDataProviderTest;

@RunWith(Suite.class)
@SuiteClasses({ PersonModelTest.class,
				CsvDataProviderTest.class, 
				DummyDataProviderTest.class})
public class AllUnitTestSuite {

}
