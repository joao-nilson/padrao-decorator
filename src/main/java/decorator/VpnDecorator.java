package decorator;

public abstract class VpnDecorator implements Vpn {

	private Vpn vpn;
	public String recursos;

	public VpnDecorator(Vpn vpn) {
		this.vpn = vpn;
	}

	public Vpn getVpn() {
		return vpn;
	}

	public void setVpn(Vpn vpn) {
		this.vpn = vpn;
	}

	public abstract float getPercentualVelocidade();

	public float getVelocidade() {
		return this.vpn.getVelocidade() * (1 + (this.getPercentualVelocidade() / 100));
	}

	public abstract String getNomeRecurso();

	public String getRecursos() {
		return this.vpn.getRecursos() + "/" + this.getNomeRecurso();
	}

	public void setRecursos(String recursos) {
		this.recursos = recursos;
	}
}
