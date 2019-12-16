package Utilities;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import beans.CatalogoBean;
import beans.ProdottoBean;
import beans.TagliaBean;

public class ServletUtilities {
	static Logger log=Logger.getLogger("ServletUtilitiesDebugger");
	
	public static Set<ProdottoBean> simulateDB(){
		HashSet<TagliaBean> taglie=new HashSet<TagliaBean>();
		TagliaBean S=new TagliaBean();
		S.setMisura("S");
		taglie.add(S);
		TagliaBean M=new TagliaBean();
		M.setMisura("M");
		taglie.add(M);
		TagliaBean L=new TagliaBean();
		L.setMisura("L");
		taglie.add(L);
		
		HashSet<ProdottoBean> catalogo=new HashSet<ProdottoBean>();
		
		log.info("Metodo simulateDB -> aggiungo i prodotti per simulare il catalogo");

		ProdottoBean pOne=new ProdottoBean();
		pOne.setCodice("001");
		pOne.setTipo("Divisa");
		pOne.setNome("Divisa Home Real Madrid");
		pOne.setMarca("Adidas");
		pOne.setPrezzo(99.99);
		pOne.setQt(40);
		pOne.setDescrizione("Real Madrid Home Kit 2018, divisa ufficiale della stagione 2018/2019 della squadra calcistica Real Madrid");
		pOne.setTaglie(taglie);
		catalogo.add(pOne);
		
		ProdottoBean pTwo=new ProdottoBean();
		pTwo.setCodice("003");
		pTwo.setTipo("Divisa");
		pTwo.setNome("Divisa Home Napoli");
		pTwo.setMarca("Kappa");
		pTwo.setPrezzo(89.99);
		pTwo.setQt(40);
		pTwo.setDescrizione("Napoli Home kit 2018. Divisa ufficiale della stagione 2018/2019");
		catalogo.add(pTwo);
		
		ProdottoBean pThree=new ProdottoBean();
		pThree.setCodice("004");
		pThree.setTipo("Divisa");
		pThree.setNome("Divisa Away Real Madrid");
		pThree.setMarca("Adidas");
		pThree.setPrezzo(99.99);
		pThree.setQt(31);
		pThree.setDescrizione("Real Madrid Awat Kit 2018, divisa ufficiale della stagione 2018/2019 della squadra calcistica Real Madrid");
		catalogo.add(pThree);
		
		ProdottoBean pFour=new ProdottoBean();
		pFour.setCodice("005");
		pFour.setTipo("Divisa");
		pFour.setNome("Divisa Home Juventus");
		pFour.setMarca("Adidas");
		pFour.setPrezzo(99.99);
		pFour.setQt(38);
		pFour.setDescrizione("Juventus Home Kit 2018, divisa ufficiale della stagione 2018/2019 della squadra calcistica Juventus");
		catalogo.add(pFour);
		
		ProdottoBean pFifth=new ProdottoBean();
		pFifth.setCodice("002");
		pFifth.setTipo("Scarpe");
		pFifth.setNome("Mercurial Vapor");
		pFifth.setMarca("Nike");
		pFifth.setPrezzo(89.99);
		pFifth.setQt(46);
		pFifth.setDescrizione("Scarpe Nike originali. Serie Mercurial 2018/2019");
		catalogo.add(pFifth);
		
		ProdottoBean pSixth=new ProdottoBean();
		pSixth.setCodice("012");
		pSixth.setTipo("Pantaloncini");
		pSixth.setNome("Pantaloni Home Real Madrid");
		pSixth.setMarca("Adidas");
		pSixth.setPrezzo(49.99);
		pSixth.setQt(50);
		pSixth.setDescrizione("Pantolinci Real Madrid originali, anno 2018/2019");
		catalogo.add(pSixth);
		
		ProdottoBean pSeven=new ProdottoBean();
		pSeven.setCodice("013");
		pSeven.setTipo("Pantaloncini");
		pSeven.setNome("Pantaloni Home Juventus");
		pSeven.setMarca("Adidas");
		pSeven.setPrezzo(49.99);
		pSeven.setQt(44);
		pSeven.setDescrizione("Pantolinci Juventus originali, anno 2018/2019");
		catalogo.add(pSeven);
		
		return catalogo;
	}
	
	public static ProdottoBean searchProdottoByCodice(String codiceProdotto, CatalogoBean catalogo) {		
		for(ProdottoBean prodottoCercato: catalogo.getCatalogo()) {
			if(prodottoCercato.getCodice().equals(codiceProdotto))
				return prodottoCercato;
		}
		
		return null;
	}
}
