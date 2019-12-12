package beans;

import java.util.ArrayList;

public class CatalogoBean {
	public CatalogoBean() {
		this.catalogo=new ArrayList<ProdottoBean>();
	}
	
	public CatalogoBean(ArrayList<ProdottoBean> catalogo) {
		this.catalogo=catalogo;
	}
	
	public ArrayList<ProdottoBean> getCatalogo() {
		return catalogo;
	}


	public void setCatalogo(ArrayList<ProdottoBean> catalogo) {
		this.catalogo=catalogo;
	}

	public void addProdotto(ProdottoBean p) {
		catalogo.add(p);
	}
	
	private ArrayList<ProdottoBean> catalogo;
}
