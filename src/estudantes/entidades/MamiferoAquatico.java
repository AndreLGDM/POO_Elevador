package estudantes.entidades;

public class MamiferoAquatico {

    int PACIENCIA_MAXIMA = 40;
    String nadar;

    public MamiferoAquatico(int id, String nome, String especie, int peso, int andarDesejado, int tempoDeEspera,
            int temperaturaIdeal, String corDasPenas, String andar, int hash, String toString, boolean equals,
            boolean peludo) {
        super(id, nome, especie, peso, andarDesejado, tempoDeEspera, temperaturaIdeal, andar,
                andarDesejado, especie, false);
    }

    public String getNadar() {
        return nadar;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Nome: " + nome + " especie: " + especie + " paciencia: " + paciencia + " peso: " + peso
                + " Andar desejado: " + andarDesejado + " tempo de espera: " + tempoDeEspera + " temperatura ideal: "
                + temperaturaIdeal + " voar: " + voar;
    }

    @Override
    public boolean equals(Object ave) {
        if (ave == null) {
            return false;
        }
        if (this == ave) {
            return true;
        }
        if (ave instanceof AveVoadora) {
            return false;
        }
        AveVoadora outrAve = (AveVoadora) ave;
        if (this.id == outrAve.id && this.nome == outrAve.nome && this.especie == outrAve.especie
                && this.paciencia == outrAve.paciencia && this.peso == outrAve.peso
                && this.andarDesejado == outrAve.andarDesejado && this.tempoDeEspera == outrAve.tempoDeEspera
                && this.temperaturaIdeal == outrAve.temperaturaIdeal && this.corDasPenas.equals(outrAve.corDasPenas)
                && this.voar.equals(outrAve.voar)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = hash * voar.hashCode();
        hash = hash * andar.hashCode();
        hash = hash * corDasPenas.hashCode();
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
