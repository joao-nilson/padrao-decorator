package decorator;

public class VpnBasico implements Vpn {
	public float velocidade;

	public VpnBasico(float velocidade) {
		this.velocidade = velocidade;
	}

	public float getVelocidade() {
		return velocidade;
	}

	public String getRecursos() {
		return "Conexão padrão";
	}
}
