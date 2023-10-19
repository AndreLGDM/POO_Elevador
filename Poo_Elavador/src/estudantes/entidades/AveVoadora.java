package estudantes.entidades;

public class AveVoadora extends Ave {

<<<<<<< HEAD
    public int PACIENCIA_MAXIMA = 20;
=======
    private int PACIENCIA_MAXIMA = 20;
>>>>>>> 732492a791dee9b09ececea63e607a3e2fc318c4

    public AveVoadora(int id, String nome, String especie, int andarDesejado, int peso, int temperatura,
            String cordepena) {
        super(id, nome, especie, andarDesejado, peso, temperatura, especie);
    }

    public String voar() {
        return "voando";
    }

    @Override
    public String toString() {
        return "Ave Voadora: " + "PACIENCIA_MAXIMA: " + PACIENCIA_MAXIMA + " ID: " + getId() + " Nome: " + getNome()
                + " especie: "
                + getEspecie() + " peso: " + getPeso()
                + " Andar desejado: " + getAndarDesejado() + " tempo de espera: " + getTempoDeEspera()
                + " temperatura ideal: "
                + getTemperaturaIdeal() + " cor das penas: " + getCorDasPenas();
    }

    @Override
    public boolean equals(Object ave) {
        if (ave == null) {
            return false;
        }
        if (this == ave) {
            return true;
        }
        if (!(ave instanceof AveVoadora)) {
            return false;
        }
        AveVoadora outrAve = (AveVoadora) ave;
        if (this.getId() == outrAve.getId()
                && this.getNome() == outrAve.getNome()
                && this.getEspecie() == outrAve.getEspecie()
                && this.getPeso() == outrAve.getPeso()
                && this.getAndarDesejado() == outrAve.getAndarDesejado()
                && this.getTempoDeEspera() == outrAve.getTempoDeEspera()
                && this.getTemperaturaIdeal() == outrAve.getTemperaturaIdeal()
<<<<<<< HEAD
                && this.getCorDasPenas().equals(outrAve.getCorDasPenas())) {
=======
                && this.corDasPenas.equals(outrAve.corDasPenas)) {
>>>>>>> 732492a791dee9b09ececea63e607a3e2fc318c4
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 13;
<<<<<<< HEAD
        hash = hash + getCorDasPenas().hashCode();
        hash = hash + getNome().hashCode();
        hash = hash + getEspecie().hashCode();
        hash = hash + getId() * 17;
        hash = hash + getPeso() * 23;
        hash = hash + getAndarDesejado() * 29;
        hash = hash + getTemperaturaIdeal() * 31;
        hash = hash + getTempoDeEspera() * 37;
=======
        hash = hash * corDasPenas.hashCode();
        hash = hash * getNome().hashCode();
        hash = hash * getEspecie().hashCode();
        hash = hash * getId() * 17;
        hash = hash * getPeso() * 23;
        hash = hash * getAndarDesejado() * 29;
        hash = hash * getTemperaturaIdeal() * 31;
        hash = hash * getTempoDeEspera() * 37;
>>>>>>> 732492a791dee9b09ececea63e607a3e2fc318c4
        return hash;
    }
}