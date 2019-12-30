package topdown;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import beans.TagliaBean;

public class TagliaModelStub {
	static Logger log=Logger.getLogger("©ModelStubDebugger");
	
	public TagliaModelStub() {
		
	}
	
	public Set<TagliaBean> doRetrieveByProdotto(String codiceProdotto, String tipo){
		LinkedHashSet<TagliaBean> taglie=new LinkedHashSet<TagliaBean>();

		if(tipo.equals("Scarpe")) {
			TagliaBean t=new TagliaBean();
			t.setMisura("39");
			taglie.add(t);
			
			TagliaBean tOne=new TagliaBean();
			tOne.setMisura("40");
			taglie.add(tOne);
		}
		else {
			TagliaBean S=new TagliaBean();
			S.setMisura("S");
			taglie.add(S);
			
			TagliaBean M=new TagliaBean();
			M.setMisura("M");
			taglie.add(M);
			
			TagliaBean L=new TagliaBean();
			L.setMisura("L");
			taglie.add(L);
		}
		
		return taglie;
	}
}
