package decorator;

public class Criptografia extends VpnDecorator {
	public Criptografia(Vpn vpn) {
		super(vpn);
	}

	public float getPercentualVelocidade() {
		return -10.0f;
	}

	public String getNomeRecurso() {
		return "Criptografia";
	}
}
