package estudantes.entidades;

public class MamiferoTerrestre extends Mamifero {
    private final int PACIENCIA_MAXIMA = 35;
    private String andar;

    public MamiferoTerrestre(int id, String nome, String especie, int andarDesejado, int peso, int temperatura,
            boolean peludo) {
        super(id, nome, especie, andarDesejado, peso, temperatura, peludo);
        this.andar = andar;
    }

    public String getAndar() {
        return andar;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Nome: " + nome + " especie: " + especie + " paciencia: " + paciencia + " peso: " + peso
                + " Andar desejado: " + andarDesejado + " tempo de espera: " + tempoDeEspera + " temperatura ideal: "
                + temperaturaIdeal + "andar: " + andar;
    }

    @Override
    public boolean equals(Object mamiferoterrestre) {
        if (mamiferoterrestre == null) {
            return false;
        }
        if (this == mamiferoterrestre) {
            return true;
        }
        if (mamiferoterrestre instanceof MamiferoTerrestre) {
            return false;
        }
        MamiferoTerrestre outromamifero = (MamiferoTerrestre) mamiferoterrestre;
        if (this.id == outromamifero.id && this.nome == outromamifero.nome && this.especie == outromamifero.especie
                && this.paciencia == outromamifero.paciencia && this.peso == outromamifero.peso
                && this.andarDesejado == outromamifero.andarDesejado
                && this.tempoDeEspera == outromamifero.tempoDeEspera
                && this.temperaturaIdeal == outromamifero.temperaturaIdeal && this.andar.equals(outromamifero.andar)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = hash * andar.hashCode();
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
