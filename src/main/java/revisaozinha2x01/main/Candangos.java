package revisaozinha2x01.main;

public class Candangos {

	public Candangos(int id, String nome) {
		this.id = id;
		this.nome = nome;
		this.votos = 0;
	}

	private int id;
	private String nome;
	private int votos;

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getVotos() {
		return votos;
	}

	public void addVoto() {
		this.votos++;
	}

}
