package topdown;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import beans.TagliaBean;

public class TagliaModelStub {
	static Logger log=Logger.getLogger("©ModelStubDebugger");
	
	public TagliaModelStub() {
		
	}
	
	public Set<TagliaBean> doRetrieveAll(){
		LinkedHashSet<TagliaBean> taglie=new LinkedHashSet<TagliaBean>();

		TagliaBean S=new TagliaBean();
		S.setMisura("S");
		taglie.add(S);
		TagliaBean M=new TagliaBean();
		M.setMisura("M");
		taglie.add(M);
		TagliaBean L=new TagliaBean();
		L.setMisura("L");
		taglie.add(L);
		
		TagliaBean t39=new TagliaBean();
		t39.setMisura("39");
		taglie.add(t39);
		TagliaBean t40=new TagliaBean();
		t40.setMisura("40");
		taglie.add(t40);
		
		return taglie;
	}
	
	public Set<TagliaBean> doRetrieveByProdotto(){
		LinkedHashSet<TagliaBean> taglie=new LinkedHashSet<TagliaBean>();

		return taglie;
	}
}
