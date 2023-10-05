package estudantes.entidades;

public class MamiferoVoador extends Mamifero {
    private final int PACIENCIA_MAXIMA = 15;
    private String voar;

    public MamiferoVoador(int id, String nome, String especie, int peso, int andarDesejado, int tempoDeEspera,
            int temperaturaIdeal, boolean peludo, String voar) {
        super(id, nome, especie, peso, andarDesejado, tempoDeEspera, temperaturaIdeal, especie, voar, peludo);
        this.voar = voar;
    }

    public String getVoar() {
        return voar;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Nome: " + nome + " especie: " + especie + " paciencia: " + paciencia + " peso: " + peso
                + " Andar desejado: " + andarDesejado + " tempo de espera: " + tempoDeEspera + " temperatura ideal: "
                + temperaturaIdeal + "voar: " + voar;
    }

    @Override
    public boolean equals(Object mamiferovoador) {
        if (mamiferovoador == null) {
            return false;
        }
        if (this == mamiferovoador) {
            return true;
        }
        if (mamiferovoador instanceof MamiferoVoador) {
            return false;
        }
        MamiferoVoador outromamifero = (MamiferoVoador) mamiferovoador;
        if (this.id == outromamifero.id && this.nome == outromamifero.nome && this.especie == outromamifero.especie
                && this.paciencia == outromamifero.paciencia && this.peso == outromamifero.peso
                && this.andarDesejado == outromamifero.andarDesejado
                && this.tempoDeEspera == outromamifero.tempoDeEspera
                && this.temperaturaIdeal == outromamifero.temperaturaIdeal && this.voar.equals(outromamifero.voar)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = hash * voar.hashCode();
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
