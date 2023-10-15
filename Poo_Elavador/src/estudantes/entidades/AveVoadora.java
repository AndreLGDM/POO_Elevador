package estudantes.entidades;

public class AveVoadora extends Ave {

    private int PACIENCIA_MAXIMA = 20;
    private String voar;

    public AveVoadora(int id, String nome, String especie, int andarDesejado, int peso, int temperatura,
            String cordepena) {
        super(id, nome, especie, andarDesejado, peso, temperatura, especie);
    }

    public void voar() {
        System.out.println("voando");
    }

    @Override
    public String toString() {
        return "Ave Voadora: " + "PACIENCIA_MAXIMA: " + PACIENCIA_MAXIMA + " ID: " + getId() + " Nome: " + getNome()
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
                && this.andar.equals(outrAve.andar)
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
        hash = hash * getNome().hashCode();
        hash = hash * getEspecie().hashCode();
        hash = hash * getId() * 17;
        hash = hash * getPeso() * 23;
        hash = hash * getAndarDesejado() * 29;
        hash = hash * getTemperaturaIdeal() * 31;
        hash = hash * getTempoDeEspera() * 37;
        return hash;
    }
}