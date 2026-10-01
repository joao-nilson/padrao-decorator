package decorator;

public class Ofuscacao extends VpnDecorator {
	public Ofuscacao(Vpn vpn) {
		super(vpn);
	}

	public float getPercentualVelocidade() {
		return -20.0f;
	}

	public String getNomeRecurso() {
		return "Ofuscacao";
	}
}
