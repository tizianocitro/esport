package bottomup.prodottoModel;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class ProdottoSuite {
	public static Test suite() {
		TestSuite suite=new TestSuite();

		suite.addTest(new ProdottoModelTestCase("doSave"));
		suite.addTest(new ProdottoModelTestCase("doRetrieveByTipo"));
		suite.addTest(new ProdottoModelTestCase("doRetrieveByCodice"));
		suite.addTest(new ProdottoModelTestCase("doUpdate"));
		suite.addTest(new ProdottoModelTestCase("doDelete"));
		
		return suite;
	}
	
	public static void main(String[] args) {
		TestRunner.run(suite());
	}
}
