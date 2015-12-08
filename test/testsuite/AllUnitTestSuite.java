package testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import models.PersonModelTest;
import datasources.CsvDataProviderTest;
import datasources.MockDataProviderTest;

@RunWith(Suite.class)
@SuiteClasses({ PersonModelTest.class,
				CsvDataProviderTest.class, 
				MockDataProviderTest.class})
public class AllUnitTestSuite {

}
