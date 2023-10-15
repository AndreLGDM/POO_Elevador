package estudantes.entidades;

abstract class Mamifero extends Animal {

    protected boolean peludo;

    public Mamifero(int id, String nome, String especie, int andarDesejado, int peso, int temperatura, boolean peludo) {
        super(id, nome, especie, andarDesejado, peso, temperatura);
        this.peludo = peludo;
    }

    public boolean isPeludo() {
        return peludo;
    }

    @Override
    public boolean equals(Object mamifero) {
        if (mamifero == null) {
            return false;
        }
        if (this == mamifero) {
            return true;
        }
        if (!(mamifero instanceof Mamifero)) {
            return false;
        }
        Mamifero outroMamifero = (Mamifero) mamifero;
        if (this.getId() == outroMamifero.getId()
                && this.getNome() == outroMamifero.getNome()
                && this.getEspecie() == outroMamifero.getEspecie()
                && this.getPeso() == outroMamifero.getPeso()
                && this.getAndarDesejado() == outroMamifero.getAndarDesejado()
                && this.getTempoDeEspera() == outroMamifero.getTempoDeEspera()
                && this.getTemperaturaIdeal() == outroMamifero.getTemperaturaIdeal()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 13;
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
