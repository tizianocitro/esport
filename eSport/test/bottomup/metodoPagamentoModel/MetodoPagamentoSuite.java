package bottomup.metodoPagamentoModel;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class MetodoPagamentoSuite {
	public static Test suite() {
		TestSuite suite=new TestSuite();
		suite.addTest(new MetodoPagamentoModelTestCase("doRetrieveByUtente"));
		suite.addTest(new MetodoPagamentoModelTestCase("doSave"));
		suite.addTest(new MetodoPagamentoModelTestCase("doDelete"));

		return suite;
	}
	
	public static void main(String[] args) {
		TestRunner.run(suite());
	}
}
