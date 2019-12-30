package bottomup.ruoloModel;

import junit.framework.*;
import junit.textui.TestRunner;

public class RuoloSuite {

	public static Test suite() {
		TestSuite suite=new TestSuite();
		suite.addTest(new RuoloModelTestCase("doRetrieveByUtente"));
		suite.addTest(new RuoloModelTestCase("doSave"));

		return suite;
	}
	
	public static void main(String[] args) {
		TestRunner.run(suite());
	}
}
