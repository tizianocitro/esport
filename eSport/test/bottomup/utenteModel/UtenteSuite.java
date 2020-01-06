package bottomup.utenteModel;

import junit.framework.*;
import junit.textui.TestRunner;

public class UtenteSuite {
	public static Test suite() {
		TestSuite suite=new TestSuite();

		suite.addTest(new UtenteModelTestCase("doSaveCorretto"));
		suite.addTest(new UtenteModelTestCase("doSaveErrato"));
		suite.addTest(new UtenteModelTestCase("doRetrieveByUsernameCorretto"));
		suite.addTest(new UtenteModelTestCase("doRetrieveByUsernameErrato"));
		suite.addTest(new UtenteModelTestCase("validateCorretto"));
		suite.addTest(new UtenteModelTestCase("validateErrato"));
		suite.addTest(new UtenteModelTestCase("doUpdateCorretto"));
		suite.addTest(new UtenteModelTestCase("doUpdateErrato"));
		suite.addTest(new UtenteModelTestCase("doDeleteCorretto"));
		
		return suite;
	}
	
	public static void main(String[] args) {
		TestRunner.run(suite());
	}
}
