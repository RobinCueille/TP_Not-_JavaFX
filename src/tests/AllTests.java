package tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ CouleurTest.class, ModelGestionnaireTest.class})
public class AllTests {
}