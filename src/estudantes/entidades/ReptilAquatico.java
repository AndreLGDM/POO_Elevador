package estudantes.entidades;

public class ReptilAquatico extends Reptil {
    private int PACIENCIA_MAXIMA = 15;
    private String nadar;

    public ReptilAquatico(int id, String nome, String especie, int peso, int andarDesejado, int tempoDeEspera,
            int temperaturaIdeal, String nadar) {
        super(id, nome, especie, peso, andarDesejado, tempoDeEspera, temperaturaIdeal, nadar);
        this.nadar = nadar;
    }

    public String getNadar() {
        return nadar;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Nome: " + nome + " especie: " + especie + " paciencia: " + paciencia + " peso: " + peso
                + " Andar desejado: " + andarDesejado + " tempo de espera: " + tempoDeEspera + " temperatura ideal: "
                + temperaturaIdeal + " nadar: " + nadar;
    }

    @Override
    public boolean equals(Object reptil) {
        if (reptil == null) {
            return false;
        }
        if (this == reptil) {
            return true;
        }
        if (reptil instanceof Reptil) {
            return false;
        }
        ReptilAquatico outroReptil = (ReptilAquatico) reptil;
        if (this.id == outroReptil.id && this.nome == outroReptil.nome && this.especie == outroReptil.especie
                && this.paciencia == outroReptil.paciencia && this.peso == outroReptil.peso
                && this.andarDesejado == outroReptil.andarDesejado && this.tempoDeEspera == outroReptil.tempoDeEspera
                && this.temperaturaIdeal == outroReptil.temperaturaIdeal && this.nadar.equals(outroReptil.nadar)) {
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
