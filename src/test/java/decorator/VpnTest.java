package decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VpnTest {

	private static final float DELTA = 0.01f;


	@Test
	void deveRetornarVelocidadeVpnBasico() {
		Vpn vpn = new VpnBasico(100.0f);

		assertEquals(100.0f, vpn.getVelocidade(), DELTA);
	}

	@Test
	void deveRetornarVelocidadeVpnComCriptografia() {
		Vpn vpn = new Criptografia(new VpnBasico(100.0f));

		assertEquals(90.0f, vpn.getVelocidade(), DELTA);
	}

	@Test
	void deveRetornarVelocidadeVpnComOfuscacao() {
		Vpn vpn = new Ofuscacao(new VpnBasico(100.0f));

		assertEquals(80.0f, vpn.getVelocidade(), DELTA);
	}

	@Test
	void deveRetornarVelocidadeVpnComCompressaoDados() {
		Vpn vpn = new CompressaoDados(new VpnBasico(100.0f));

		assertEquals(120.0f, vpn.getVelocidade(), DELTA);
	}

	@Test
	void deveRetornarVelocidadeVpnComCriptografiaMaisOfuscacao() {
		Vpn vpn = new Ofuscacao(new Criptografia(new VpnBasico(100.0f)));

		assertEquals(72.0f, vpn.getVelocidade(), DELTA);
	}

	@Test
	void deveRetornarVelocidadeVpnComCriptografiaMaisCompressaoDados() {
		Vpn vpn = new CompressaoDados(new Criptografia(new VpnBasico(100.0f)));

		assertEquals(108.0f, vpn.getVelocidade(), DELTA);
	}

	@Test
	void deveRetornarVelocidadeVpnComOfuscacaoMaisCompressaoDados() {
		Vpn vpn = new CompressaoDados(new Ofuscacao(new VpnBasico(100.0f)));

		assertEquals(96.0f, vpn.getVelocidade(), DELTA);
	}

	@Test
	void deveRetornarVelocidadeVpnComCriptografiaMaisOfuscacaoMaisCompressaoDados() {
		Vpn vpn = new CompressaoDados(new Ofuscacao(new Criptografia(new VpnBasico(100.0f))));

		assertEquals(86.4f, vpn.getVelocidade(), DELTA);
	}

	@Test
	void deveRetornarMesmaVelocidadeIndependenteDaOrdemDosDecorators() {
		Vpn criptografiaPorFora = new Criptografia(new Ofuscacao(new VpnBasico(100.0f)));
		Vpn ofuscacaoPorFora = new Ofuscacao(new Criptografia(new VpnBasico(100.0f)));

		assertEquals(criptografiaPorFora.getVelocidade(), ofuscacaoPorFora.getVelocidade(), DELTA);
	}

	@Test
	void deveRetornarVelocidadeZeroQuandoVelocidadeBaseForZero() {
		Vpn vpn = new CompressaoDados(new Ofuscacao(new Criptografia(new VpnBasico(0.0f))));

		assertEquals(0.0f, vpn.getVelocidade(), DELTA);
	}


	@Test
	void deveRetornarRecursosVpnBasico() {
		Vpn vpn = new VpnBasico(100.0f);

		assertEquals("Conexão padrão", vpn.getRecursos());
	}

	@Test
	void deveRetornarRecursosVpnComCriptografia() {
		Vpn vpn = new Criptografia(new VpnBasico(100.0f));

		assertEquals("Conexão padrão/Criptografia", vpn.getRecursos());
	}

	@Test
	void deveRetornarRecursosVpnComOfuscacao() {
		Vpn vpn = new Ofuscacao(new VpnBasico(100.0f));

		assertEquals("Conexão padrão/Ofuscacao", vpn.getRecursos());
	}

	@Test
	void deveRetornarRecursosVpnComCompressaoDados() {
		Vpn vpn = new CompressaoDados(new VpnBasico(100.0f));

		assertEquals("Conexão padrão/Compressao de Dados", vpn.getRecursos());
	}

	@Test
	void deveRetornarRecursosVpnComCriptografiaMaisOfuscacao() {
		Vpn vpn = new Ofuscacao(new Criptografia(new VpnBasico(100.0f)));

		assertEquals("Conexão padrão/Criptografia/Ofuscacao", vpn.getRecursos());
	}

	@Test
	void deveRetornarRecursosVpnComOfuscacaoMaisCriptografia() {
		Vpn vpn = new Criptografia(new Ofuscacao(new VpnBasico(100.0f)));

		assertEquals("Conexão padrão/Ofuscacao/Criptografia", vpn.getRecursos());
	}

	@Test
	void deveRetornarRecursosVpnComCriptografiaMaisOfuscacaoMaisCompressaoDados() {
		Vpn vpn = new CompressaoDados(new Ofuscacao(new Criptografia(new VpnBasico(100.0f))));

		assertEquals("Conexão padrão/Criptografia/Ofuscacao/Compressao de Dados", vpn.getRecursos());
	}


	@Test
	void deveRetornarPercentualENomeDaCriptografia() {
		VpnDecorator decorator = new Criptografia(new VpnBasico(100.0f));

		assertEquals(-10.0f, decorator.getPercentualVelocidade(), DELTA);
		assertEquals("Criptografia", decorator.getNomeRecurso());
	}

	@Test
	void deveRetornarPercentualENomeDaOfuscacao() {
		VpnDecorator decorator = new Ofuscacao(new VpnBasico(100.0f));

		assertEquals(-20.0f, decorator.getPercentualVelocidade(), DELTA);
		assertEquals("Ofuscacao", decorator.getNomeRecurso());
	}

	@Test
	void deveRetornarPercentualENomeDaCompressaoDados() {
		VpnDecorator decorator = new CompressaoDados(new VpnBasico(100.0f));

		assertEquals(20.0f, decorator.getPercentualVelocidade(), DELTA);
		assertEquals("Compressao de Dados", decorator.getNomeRecurso());
	}
}
