package estudantes.entidades;

public class AveVoadora extends Ave {

    private int PACIENCIA_MAXIMA = 20;
    private String voar;

    public AveVoadora(int id, String nome, String especie, int andarDesejado, int peso, int temperatura,
            String cordepena) {
        super(id, nome, especie, andarDesejado, peso, temperatura, especie);
        this.voar = voar;
    }

    public String getVoar() {
        return voar;
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
                && this.temperaturaIdeal == outrAve.temperaturaIdeal && this.andar.equals(outrAve.andar)
                && this.corDasPenas.equals(outrAve.corDasPenas)
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