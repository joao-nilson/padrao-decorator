package decorator;

public class CompressaoDados extends VpnDecorator {
	public CompressaoDados(Vpn vpn) {
		super(vpn);
	}

	public float getPercentualVelocidade() {
		return 20.0f;
	}

	public String getNomeRecurso() {
		return "Compressao de Dados";
	}
}
