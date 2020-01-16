package bottomup.ordineModel;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class OrdineSuite {
	public static Test suite() {
		TestSuite suite=new TestSuite();

		suite.addTest(new OrdineModelTestCase("doSave"));
		suite.addTest(new OrdineModelTestCase("doRetrieveAll"));
		suite.addTest(new OrdineModelTestCase("doRetrieveByNumero"));
		suite.addTest(new OrdineModelTestCase("doRetrieveByUtente"));
		suite.addTest(new OrdineModelTestCase("doRetrieveIfAttivi"));
		suite.addTest(new OrdineModelTestCase("aggiornaStato"));
		
		return suite;
	}
	
	public static void main(String[] args) {
		TestRunner.run(suite());
	}
}
