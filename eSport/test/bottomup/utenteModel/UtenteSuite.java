package bottomup.utenteModel;

import junit.framework.*;
import junit.textui.TestRunner;

public class UtenteSuite {
	public static Test suite() {
		TestSuite suite=new TestSuite();

		suite.addTest(new UtenteModelTestCase("doSave"));
		suite.addTest(new UtenteModelTestCase("doRetrieveByUsername"));
		suite.addTest(new UtenteModelTestCase("validate"));
		suite.addTest(new UtenteModelTestCase("doUpdate"));
		suite.addTest(new UtenteModelTestCase("doDelete"));
		
		return suite;
	}
	
	public static void main(String[] args) {
		TestRunner.run(suite());
	}
}
