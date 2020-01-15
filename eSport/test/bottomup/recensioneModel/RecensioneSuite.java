package bottomup.recensioneModel;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class RecensioneSuite {
	public static Test suite() {
		TestSuite suite=new TestSuite();
		suite.addTest(new RecensioneModelTestCase("doRetrieveByProdotto"));
		suite.addTest(new RecensioneModelTestCase("doSave"));

		return suite;
	}
	
	public static void main(String[] args) {
		TestRunner.run(suite());
	}
}
