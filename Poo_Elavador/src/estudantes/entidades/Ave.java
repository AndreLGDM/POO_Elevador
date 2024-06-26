package estudantes.entidades;

public class Ave extends Animal {

    public final int PACIENCIA_MAXIMA = 30;
    private String corDasPenas;

    public Ave(int id, String nome, String especie, int andarDesejado, int peso, int temperatura, String corDaPena) {
        super(id, nome, especie, andarDesejado, peso, temperatura);
        this.corDasPenas = corDaPena;
    }

    public String getCorDasPenas() {
        return corDasPenas;
    }

    public String andar() {
        return "andando";
    }

    @Override
    public String toString() {
        return "Ave: " + "PACIENCIA_MAXIMA: " + PACIENCIA_MAXIMA + " ID: " + getId() + " Nome: " + getNome()
                + " especie: "
                + getEspecie() + " peso: " + getPeso()
                + " Andar desejado: " + getAndarDesejado() + " tempo de espera: " + getTempoDeEspera()
                + " temperatura ideal: "
                + getTemperaturaIdeal();
    }

    @Override
    public boolean equals(Object ave) {
        if (ave == null) {
            return false;
        }
        if (this == ave) {
            return true;
        }
        if (!(ave instanceof Ave)) {
            return false;
        }
        Ave outrAve = (Ave) ave;
        if (this.getId() == outrAve.getId() && this.getNome() == outrAve.getNome()
                && this.getEspecie() == outrAve.getEspecie()
                && this.getPeso() == outrAve.getPeso()
                && this.getAndarDesejado() == outrAve.getAndarDesejado()
                && this.getTempoDeEspera() == outrAve.getTempoDeEspera()
                && this.getTemperaturaIdeal() == outrAve.getTemperaturaIdeal()
                && this.corDasPenas.equals(outrAve.corDasPenas)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = hash + corDasPenas.hashCode();
        hash = hash + getNome().hashCode();
        hash = hash + getEspecie().hashCode();
        hash = hash + getId() * 17;
        hash = hash + getPeso() * 23;
        hash = hash + getAndarDesejado() * 29;
        hash = hash + getTemperaturaIdeal() * 31;
        hash = hash + getTempoDeEspera() * 37;
        return hash;
    }
}
