package estudantes.entidades;

public class Ave extends Animal {

    private final int PACIENCIA_MAXIMA = 30;
    protected String corDasPenas;
    protected String andar;

    public Ave(int id, String nome, String especie, int andarDesejado, int peso, int temperatura, String cordapena) {
        super(id, nome, especie, andarDesejado, peso, temperatura);
        this.corDasPenas = corDasPenas;
        this.andar = andar;

    }

    public String getCorDasPenas() {
        return corDasPenas;
    }

    public String getandar() {
        return andar;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Nome: " + nome + " especie: " + especie + " paciencia: " + paciencia + " peso: " + peso
                + " Andar desejado: " + andarDesejado + " tempo de espera: " + tempoDeEspera + " temperatura ideal: "
                + temperaturaIdeal;
    }

    @Override
    public boolean equals(Object ave) {
        if (ave == null) {
            return false;
        }
        if (this == ave) {
            return true;
        }
        if (ave instanceof Ave) {
            return false;
        }
        Ave outrAve = (Ave) ave;
        if (this.id == outrAve.id && this.nome == outrAve.nome && this.especie == outrAve.especie
                && this.paciencia == outrAve.paciencia && this.peso == outrAve.peso
                && this.andarDesejado == outrAve.andarDesejado && this.tempoDeEspera == outrAve.tempoDeEspera
                && this.temperaturaIdeal == outrAve.temperaturaIdeal && this.corDasPenas.equals(outrAve.corDasPenas)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 13;
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
