package bottomup.indirizzoModel;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class IndirizzoSuite {
	public static Test suite() {
		TestSuite suite=new TestSuite();
		suite.addTest(new IndirizzoModelTestCase("doRetrieveByUtente"));
		suite.addTest(new IndirizzoModelTestCase("doSave"));
		suite.addTest(new IndirizzoModelTestCase("doDelete"));

		return suite;
	}
	
	public static void main(String[] args) {
		TestRunner.run(suite());
	}
}
