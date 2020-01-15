package bottomup.tagliaModel;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class TagliaSuite {
	public static Test suite() {
		TestSuite suite=new TestSuite();
		suite.addTest(new TagliaModelTestCase("doRetrieveByProdotto"));
		suite.addTest(new TagliaModelTestCase("doSave"));

		return suite;
	}
	
	public static void main(String[] args) {
		TestRunner.run(suite());
	}
}
