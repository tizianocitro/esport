package bottomup.carrelloBean;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class CarrelloSuite {
	public static Test suite() {
		TestSuite suite=new TestSuite();

		suite.addTest(new CarrelloBeanTestCase("getProdotto"));
		suite.addTest(new CarrelloBeanTestCase("addProdotto"));
		suite.addTest(new CarrelloBeanTestCase("reAddProdotto"));
		suite.addTest(new CarrelloBeanTestCase("removeProdotto"));
		suite.addTest(new CarrelloBeanTestCase("modificaQt"));
		suite.addTest(new CarrelloBeanTestCase("contains"));
		suite.addTest(new CarrelloBeanTestCase("svuotaCarrello"));

		return suite;
	}
	
	public static void main(String[] args) {
		TestRunner.run(suite());
	}
}
