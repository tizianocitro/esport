package topdown;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import beans.ComposizioneBean;
import beans.OrdineBean;
import beans.UtenteBean;

public class OrdineModelStub {
	static Logger log=Logger.getLogger("OrdineModelStubDebugger");
	public static String ELABORAZIONE="In elaborazione";
	public static String SPEDIZIONE="In spedizione";
	public static String CONSEGNATO="Consegnato";
	
	public OrdineModelStub() {
		
	}
	
	public Set<OrdineBean> doRetrieveAll() {	
		LinkedHashSet<OrdineBean> ordini=new LinkedHashSet<OrdineBean>();
		
		OrdineBean ordOne=createOrdine("root", "000001", ELABORAZIONE);	
		ordini.add(ordOne);
		
		OrdineBean ordTwo=createOrdine("PaoloG", "000002", SPEDIZIONE);	
		ordini.add(ordTwo);
		
		OrdineBean ordThree=createOrdine("PaoloG", "000003", CONSEGNATO);	
		ordini.add(ordThree);
		
		return ordini;
	}
	
	public Set<OrdineBean> doRetrieveOrdiniByUtente(UtenteBean utente) {
		LinkedHashSet<OrdineBean> ordini=new LinkedHashSet<OrdineBean>();
		ordini=(LinkedHashSet<OrdineBean>) doRetrieveAll();
		
		LinkedHashSet<OrdineBean> ordiniUtente=new LinkedHashSet<OrdineBean>();
		
		for(OrdineBean ordine: ordini)
			if(ordine.getUsername().equals(utente.getUsername()))
				ordiniUtente.add(ordine);
		
		return ordiniUtente;
	}
	
	private OrdineBean createOrdine(String user, String numero, String stato) {
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
		ComposizioneModelStub composizioneModel=new ComposizioneModelStub();
		LinkedHashSet<ComposizioneBean> comp=(LinkedHashSet<ComposizioneBean>) 
				composizioneModel.doRetrieveByOrdine(ordOne);
		
		double totale=0;
		for(ComposizioneBean cb: comp)
			totale+=cb.getPrezzoVen();
		
		ordOne.setTotale(totale);
		ordOne.setComposizione(comp);
		
		return ordOne;
	}
}
