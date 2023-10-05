package estudantes.entidades;

public class MamiferoAquatico extends Mamifero {

    private int PACIENCIA_MAXIMA = 40;
    private String nadar;

    public MamiferoAquatico(int id, String nome, String especie, int peso, int andarDesejado, int tempoDeEspera,
            int temperaturaIdeal, boolean peludo, String nadar) {
        super(id, nome, especie, peso, andarDesejado, tempoDeEspera, temperaturaIdeal, nome, especie, peludo);
    }

    public String getNadar() {
        return nadar;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Nome: " + nome + " especie: " + especie + " paciencia: " + paciencia + " peso: " + peso
                + " Andar desejado: " + andarDesejado + " tempo de espera: " + tempoDeEspera + " temperatura ideal: "
                + temperaturaIdeal + "nadar: " + nadar;
    }

    @Override
    public boolean equals(Object mamiferoaquatico) {
        if (mamiferoaquatico == null) {
            return false;
        }
        if (this == mamiferoaquatico) {
            return true;
        }
        if (mamiferoaquatico instanceof MamiferoAquatico) {
            return false;
        }
        MamiferoAquatico outromamifero = (MamiferoAquatico) mamiferoaquatico;
        if (this.id == outromamifero.id && this.nome == outromamifero.nome && this.especie == outromamifero.especie
                && this.paciencia == outromamifero.paciencia && this.peso == outromamifero.peso
                && this.andarDesejado == outromamifero.andarDesejado
                && this.tempoDeEspera == outromamifero.tempoDeEspera
                && this.temperaturaIdeal == outromamifero.temperaturaIdeal && this.nadar.equals(outromamifero.nadar)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = hash * nadar.hashCode();
        hash = hash * nome.hashCode();
        hash = hash * especie.hashCode();
        hash = hash * id * 17;
        hash = hash * paciencia * 19;
        hash = hash * peso * 23;
        hash = hash * andarDesejado * 29;
        hash = hash * temperaturaIdeal * 31;
        hash = hash * tempoDeEspera * 37;
        return hash;
    }
}
