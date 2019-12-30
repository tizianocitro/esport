package topdown;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import beans.CatalogoBean;
import beans.ProdottoBean;

public class ProdottoModelStub {
	static Logger log=Logger.getLogger("ProdottoModelStubDebugger");
	
	public ProdottoModelStub() {
		
	}
	
	public Set<ProdottoBean> doRetrieveAll(){
		log.info("Metodo: doRetrieveAll -> ottengo le taglie");
		
		LinkedHashSet<ProdottoBean> catalogo=new LinkedHashSet<ProdottoBean>();
		TagliaModelStub tagliaModel=new TagliaModelStub();

		log.info("Aggiungo i prodotti per simulare il catalogo");

		ProdottoBean pOne=new ProdottoBean();
		pOne.setCodice("001");
		pOne.setTipo("Divisa");
		pOne.setNome("Divisa Home Real Madrid");
		pOne.setMarca("Adidas");
		pOne.setPrezzo(99.99);
		pOne.setQt(40);
		pOne.setIva(22);
		pOne.setTaglie(tagliaModel.doRetrieveByProdotto(pOne.getCodice(), pOne.getTipo()));
		pOne.setDescrizione("Real Madrid Home Kit 2018, divisa ufficiale della stagione 2018/2019 della squadra calcistica Real Madrid");
		catalogo.add(pOne);
		
		ProdottoBean pTwo=new ProdottoBean();
		pTwo.setCodice("003");
		pTwo.setTipo("Divisa");
		pTwo.setNome("Divisa Home Napoli");
		pTwo.setMarca("Kappa");
		pTwo.setPrezzo(89.99);
		pTwo.setQt(40);
		pTwo.setIva(22);
		pTwo.setTaglie(tagliaModel.doRetrieveByProdotto(pTwo.getCodice(), pTwo.getTipo()));
		pTwo.setDescrizione("Napoli Home kit 2018. Divisa ufficiale della stagione 2018/2019");
		catalogo.add(pTwo);
		
		ProdottoBean pThree=new ProdottoBean();
		pThree.setCodice("004");
		pThree.setTipo("Divisa");
		pThree.setNome("Divisa Away Real Madrid");
		pThree.setMarca("Adidas");
		pThree.setPrezzo(99.99);
		pThree.setQt(31);
		pThree.setIva(22);
		pThree.setTaglie(tagliaModel.doRetrieveByProdotto(pThree.getCodice(), pThree.getTipo()));
		pThree.setDescrizione("Real Madrid Awat Kit 2018, divisa ufficiale della stagione 2018/2019 della squadra calcistica Real Madrid");
		catalogo.add(pThree);
		
		ProdottoBean pFour=new ProdottoBean();
		pFour.setCodice("005");
		pFour.setTipo("Divisa");
		pFour.setNome("Divisa Home Juventus");
		pFour.setMarca("Adidas");
		pFour.setPrezzo(99.99);
		pFour.setQt(38);
		pFour.setIva(22);		
		pFour.setTaglie(tagliaModel.doRetrieveByProdotto(pFour.getCodice(), pFour.getTipo()));
		pFour.setDescrizione("Juventus Home Kit 2018, divisa ufficiale della stagione 2018/2019 della squadra calcistica Juventus");
		catalogo.add(pFour);
		
		ProdottoBean pFifth=new ProdottoBean();
		pFifth.setCodice("002");
		pFifth.setTipo("Scarpe");
		pFifth.setNome("Mercurial Vapor");
		pFifth.setMarca("Nike");
		pFifth.setPrezzo(89.99);
		pFifth.setQt(46);
		pFifth.setIva(22);		
		pFifth.setTaglie(tagliaModel.doRetrieveByProdotto(pFifth.getCodice(), pFifth.getTipo()));
		pFifth.setDescrizione("Scarpe Nike originali. Serie Mercurial 2018/2019");
		catalogo.add(pFifth);
		
		ProdottoBean pSixth=new ProdottoBean();
		pSixth.setCodice("012");
		pSixth.setTipo("Pantaloncini");
		pSixth.setNome("Pantaloni Home Real Madrid");
		pSixth.setMarca("Adidas");
		pSixth.setPrezzo(49.99);
		pSixth.setQt(50);
		pSixth.setIva(22);
		pSixth.setTaglie(tagliaModel.doRetrieveByProdotto(pSixth.getCodice(), pSixth.getTipo()));
		pSixth.setDescrizione("Pantolinci Real Madrid originali, anno 2018/2019");
		catalogo.add(pSixth);
		
		ProdottoBean pSeven=new ProdottoBean();
		pSeven.setCodice("013");
		pSeven.setTipo("Pantaloncini");
		pSeven.setNome("Pantaloni Home Juventus");
		pSeven.setMarca("Adidas");
		pSeven.setPrezzo(49.99);
		pSeven.setQt(44);
		pSeven.setIva(22);
		pSeven.setTaglie(tagliaModel.doRetrieveByProdotto(pSeven.getCodice(), pSeven.getTipo()));
		pSeven.setDescrizione("Pantolinci Juventus originali, anno 2018/2019");
		catalogo.add(pSeven);
		
		return catalogo;
	}
	
	public ProdottoBean doRetrieveByCodice(String codiceProdotto) {
		CatalogoBean catalogo=new CatalogoBean();
		catalogo.setCatalogo(doRetrieveAll());
		
		log.info("Cerco il prodotto");
		for(ProdottoBean prodotto: catalogo.getCatalogo()) {
			if(prodotto.getCodice().equals(codiceProdotto))
				return prodotto;
		}
		
		return null;
	}
	public Set<ProdottoBean> doRetrieveByTipo(String tipo){
		LinkedHashSet<ProdottoBean> temp=new LinkedHashSet<ProdottoBean>();
		
		CatalogoBean catalogo=new CatalogoBean();
		catalogo.setCatalogo(doRetrieveAll());
		
		log.info("Metodo doRetrieveByTipo -> filtro i prodotti per il catalogo");
		for(ProdottoBean prodotto: catalogo.getCatalogo()) {
			if(prodotto.getTipo().equalsIgnoreCase(tipo))
				temp.add(prodotto);
		}
		
		return temp;
	}
}
