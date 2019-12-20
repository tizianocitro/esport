package Utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import beans.CarrelloBean;
import beans.CarrelloItem;
import beans.CatalogoBean;
import beans.ComposizioneBean;
import beans.OrdineBean;
import beans.ProdottoBean;
import beans.TagliaBean;
import beans.UtenteBean;

public class ServletUtilities {
	static Logger log=Logger.getLogger("ServletUtilitiesDebugger");
	public static String ELABORAZIONE="In elaborazione";
	public static String SPEDIZIONE="In spedizione";
	public static String CONSEGNATO="Consegnato";
	
	public static Set<ProdottoBean> simulateDB(){
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
		
		LinkedHashSet<TagliaBean> taglieScarpe=new LinkedHashSet<TagliaBean>();
		TagliaBean t=new TagliaBean();
		t.setMisura("39");
		taglieScarpe.add(t);
		TagliaBean tOne=new TagliaBean();
		tOne.setMisura("40");
		taglieScarpe.add(tOne);
		
		LinkedHashSet<ProdottoBean> catalogo=new LinkedHashSet<ProdottoBean>();
		
		log.info("Metodo simulateDB -> aggiungo i prodotti per simulare il catalogo");

		ProdottoBean pOne=new ProdottoBean();
		pOne.setCodice("001");
		pOne.setTipo("Divisa");
		pOne.setNome("Divisa Home Real Madrid");
		pOne.setMarca("Adidas");
		pOne.setPrezzo(99.99);
		pOne.setQt(40);
		pOne.setIva(22);
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
		pTwo.setTaglie(taglie);
		catalogo.add(pTwo);
		
		ProdottoBean pThree=new ProdottoBean();
		pThree.setCodice("004");
		pThree.setTipo("Divisa");
		pThree.setNome("Divisa Away Real Madrid");
		pThree.setMarca("Adidas");
		pThree.setPrezzo(99.99);
		pThree.setQt(31);
		pThree.setDescrizione("Real Madrid Awat Kit 2018, divisa ufficiale della stagione 2018/2019 della squadra calcistica Real Madrid");
		pThree.setTaglie(taglie);
		catalogo.add(pThree);
		
		ProdottoBean pFour=new ProdottoBean();
		pFour.setCodice("005");
		pFour.setTipo("Divisa");
		pFour.setNome("Divisa Home Juventus");
		pFour.setMarca("Adidas");
		pFour.setPrezzo(99.99);
		pFour.setQt(38);
		pFour.setDescrizione("Juventus Home Kit 2018, divisa ufficiale della stagione 2018/2019 della squadra calcistica Juventus");
		pFour.setTaglie(taglie);
		catalogo.add(pFour);
		
		ProdottoBean pFifth=new ProdottoBean();
		pFifth.setCodice("002");
		pFifth.setTipo("Scarpe");
		pFifth.setNome("Mercurial Vapor");
		pFifth.setMarca("Nike");
		pFifth.setPrezzo(89.99);
		pFifth.setQt(46);
		pFifth.setDescrizione("Scarpe Nike originali. Serie Mercurial 2018/2019");
		pFifth.setTaglie(taglieScarpe);
		catalogo.add(pFifth);
		
		ProdottoBean pSixth=new ProdottoBean();
		pSixth.setCodice("012");
		pSixth.setTipo("Pantaloncini");
		pSixth.setNome("Pantaloni Home Real Madrid");
		pSixth.setMarca("Adidas");
		pSixth.setPrezzo(49.99);
		pSixth.setQt(50);
		pSixth.setDescrizione("Pantolinci Real Madrid originali, anno 2018/2019");
		pSixth.setTaglie(taglie);
		catalogo.add(pSixth);
		
		ProdottoBean pSeven=new ProdottoBean();
		pSeven.setCodice("013");
		pSeven.setTipo("Pantaloncini");
		pSeven.setNome("Pantaloni Home Juventus");
		pSeven.setMarca("Adidas");
		pSeven.setPrezzo(49.99);
		pSeven.setQt(44);
		pSeven.setDescrizione("Pantolinci Juventus originali, anno 2018/2019");
		pSeven.setTaglie(taglie);
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
	
	public static CarrelloItem searchProdottoByCodice(String codiceProdotto, CarrelloBean carrello) {		
		for(CarrelloItem item: carrello.getCarrello()) {
			if(item.getProdotto().getCodice().equals(codiceProdotto))
				return item;
		}
		
		return null;
	}
	
	public static OrdineBean simulateOrdine(String user, String numero, String stato) {		
		OrdineBean ordOne=new OrdineBean();
		ordOne.setUsername(user);
		ordOne.setNumero(numero);
		ordOne.setStato(stato);
		ordOne.setPagamento("1378134767340924");
		
		log.info("Imposto la data di sottomissione come la data odierna");
		Date d=Calendar.getInstance().getTime();
		String format="yyyy-MM-dd";
		DateFormat df=new SimpleDateFormat(format);
		String date=df.format(d);
		ordOne.setSottomissione(date);
		
		log.info("Imposto la data di consegna");
    	String data=ordOne.getSottomissione();
    	Calendar cal=Calendar.getInstance();
    	cal.add(Calendar.DATE, 3);
    	String formatOne="yyyy-MM-dd";
		DateFormat dfOne=new SimpleDateFormat(formatOne);
		String dateOne=dfOne.format(cal.getTime());
		ordOne.setConsegna(dateOne);
		
		log.info("Ottengo i prodotti che compongono l'ordine");
		LinkedHashSet<ComposizioneBean> comp=(LinkedHashSet<ComposizioneBean>) simulateComposizione(ordOne);
		double totale=0;
		for(ComposizioneBean cb: comp)
			totale+=cb.getPrezzoVen();
		
		ordOne.setTotale(totale);
		ordOne.setComposizione(comp);
				
		return ordOne;
	}
	
	public static Set<ComposizioneBean> simulateComposizione(OrdineBean ordine){
		LinkedHashSet<ComposizioneBean> comp=new LinkedHashSet<ComposizioneBean>();
		
		ComposizioneBean compOne=new ComposizioneBean();
		compOne.setOrdine(ordine.getNumero());
		compOne.setProdotto("001");
		compOne.setNomeProdotto("Divisa Home Real Madrid");
		compOne.setPrezzoVen(99.99);
		compOne.setIvaVen(22);
		compOne.setQt(1);
		compOne.setTaglia("S");
		comp.add(compOne);
		
		return comp;
	}
	
	public static Set<OrdineBean> filtraOrdiniByUtente(UtenteBean utente, Set<OrdineBean> ordini) {
		LinkedHashSet<OrdineBean> ordiniUtente=new LinkedHashSet<OrdineBean>();
		
		for(OrdineBean ordine: ordini)
			if(ordine.getUsername().equals(utente.getUsername()))
				ordiniUtente.add(ordine);
		
		return ordiniUtente;
	}
}
