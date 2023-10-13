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
        if (mamifero instanceof Mamifero) {
            return false;
        }
        Mamifero outroMamifero = (Mamifero) mamifero;
        if (this.id == outroMamifero.id && this.nome == outroMamifero.nome && this.especie == outroMamifero.especie
                && this.paciencia == outroMamifero.paciencia && this.peso == outroMamifero.peso
                && this.andarDesejado == outroMamifero.andarDesejado
                && this.tempoDeEspera == outroMamifero.tempoDeEspera
                && this.temperaturaIdeal == outroMamifero.temperaturaIdeal) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 13;
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
