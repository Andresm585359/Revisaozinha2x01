package revisaozinha2x01.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Main tululu = new Main();
		tululu.tururu();

	}

	private Map<Integer, Candangos> mapaDeCandangos = new HashMap<Integer, Candangos>();

	private void tururu() {
		int voto = 0;
		comecarProjeto();
		while (voto != -11) {
			voto = votacaoMardeta();
			if (voto != -1) {
				System.out.println("Voto para virar LENDA para o SimpLord numero " + voto);
				registrarVoto(voto);
			}
		}
		apurarVotos();
		System.out.println("GG");
	}

	private void apurarVotos() {

		List<Candangos> candangos = new ArrayList<Candangos>();

		for (Candangos candangos2 : mapaDeCandangos.values()) {
			candangos.add(candangos2);
		}
		candangos.sort((a, b) -> {
			return b.getVotos() - a.getVotos();
		});

		/*
		 * vamo fuçar pra deixar bunitin aqui em caso de empate
		 */

		List<Candangos> candangosRumoAoTetra = new ArrayList<Candangos>();
		{
			for (Candangos candangos2 : candangos) {
				if (candangos2.getVotos() == candangos.get(0).getVotos()) {
					candangosRumoAoTetra.add(candangos2);
				}
			}
		}
		if (candangosRumoAoTetra.size() > 1) {

			System.out.println("Os primeiros " + candangosRumoAoTetra.size() + " SimpLords2 empataram no primeiro lugar.");
			for (int i = 0; i < candangosRumoAoTetra.size(); i++) {
				Candangos candango = candangos.get(i);
				System.out.println("Lugar " + 1 + " " + candango.getNome() + " com " + candango.getVotos() + " SIMPS.");
			}
			for (int i = candangosRumoAoTetra.size(); i < candangos.size(); i++) {
				Candangos candango = candangos.get(i);
				System.out.println(
						"Lugar " + (i + 1) + " " + candango.getNome() + " com " + candango.getVotos() + " SIMPS.");
			}

		} else {
			Candangos aLenda = candangos.get(0);

			System.out.println("Uau vc ganhou como a LENDA senhor: " + aLenda.getNome() + "  votado por "
					+ aLenda.getVotos() + " simps.");

			for (int i = 0; i < candangos.size(); i++) {
				Candangos candango = candangos.get(i);
				System.out.println(
						"Lugar " + (i + 1) + " " + candango.getNome() + " com " + candango.getVotos() + " SIMPS.");
			}
		}
	}

	private void registrarVoto(int voto) {

		if (mapaDeCandangos.containsKey(voto)) {
			Candangos candango = mapaDeCandangos.get(voto);
			candango.addVoto();
			System.out.println("Voto para " + candango.getNome());
		} else {
			System.out.println("Candango nao existe.");
		}
	}

	private int votacaoMardeta() {

		System.out.println("Digita o voto seu rombado!(-11 pra cabar)");
		Scanner scan = new Scanner(System.in);
		try {
			return (scan.nextInt());
		} catch (Exception e) {
			scan.next();
			System.out.println("NUMEROS... animal... NUMEROS....");
			return -1;
		}

	}

	private void comecarProjeto() {
		Candangos jozias = new Candangos(0, "Jozias do Mar Togrosso");
		Candangos maria = new Candangos(1, "Maria Medalenha");
		Candangos lindomiro = new Candangos(2, "Lindomiro da Pamonha");
		Candangos pintassilgo = new Candangos(3, "Pintassilgo da Jirombola");
		Candangos indiano = new Candangos(4, "Indiano Jounes");

		mapaDeCandangos.put(jozias.getId(), jozias);
		mapaDeCandangos.put(maria.getId(), maria);
		mapaDeCandangos.put(lindomiro.getId(), lindomiro);
		mapaDeCandangos.put(pintassilgo.getId(), pintassilgo);
		mapaDeCandangos.put(indiano.getId(), indiano);
	}

}
