package beans;

public class OrdineBean {
	public OrdineBean() {	
	}

	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getPrezzotot() {
		return prezzotot;
	}
	
	public void setPrezzotot(double prezzotot) {
		this.prezzotot = prezzotot;
	}
	
	public String getDataord() {
		return dataord;
	}
	
	public void setDataord(String dataord) {
		this.dataord = dataord;
	}
	
	public String getUsrutente() {
		return usrutente;
	}
	
	public void setUsrutente(String usrutente) {
		this.usrutente = usrutente;
	}
	
	public String getPassutente() {
		return passutente;
	}
	
	public void setPassutente(String passutente) {
		this.passutente = passutente;
	}
	
	private String numero;
	private String nome;
	private double prezzotot;
	private String dataord;
	private String usrutente;
	private String passutente;
}
