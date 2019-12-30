package bottomup.ruoloModel;

import junit.framework.*;
import junit.textui.TestRunner;

public class RuoloTests {

	public static Test suite() {
		TestSuite suite=new TestSuite();
		suite.addTest(new RuoloModelTests("doRetrieveByUtente"));
		suite.addTest(new RuoloModelTests("doSave"));

		return suite;
	}
	
	public static void main(String[] args) {
		TestRunner.run(suite());
	}
}
