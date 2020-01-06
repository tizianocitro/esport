package bottomup.ruoloModel;

import junit.framework.*;
import junit.textui.TestRunner;

public class RuoloSuite {

	public static Test suite() {
		TestSuite suite=new TestSuite();
		suite.addTest(new RuoloModelTestCase("doRetrieveByUtenteCorretto"));
		suite.addTest(new RuoloModelTestCase("doRetrieveByUtenteErrato"));
		suite.addTest(new RuoloModelTestCase("doSaveCorretto"));
		suite.addTest(new RuoloModelTestCase("doSaveErrato"));

		return suite;
	}
	
	public static void main(String[] args) {
		TestRunner.run(suite());
	}
}
