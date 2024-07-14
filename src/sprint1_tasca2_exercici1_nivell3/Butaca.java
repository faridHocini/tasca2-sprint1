package sprint1_tasca2_exercici1_nivell3;

public class Butaca {
    private int fila;
    private int seient;
    private String persona;

    public Butaca(int fila, int seient, String persona) {
        this.fila = fila;
        this.seient = seient;
        this.persona = persona;
    }

    public int getFila() {
        return fila;
    }

    public int getSeient() {
        return seient;
    }

    public String getPersona() {
        return persona;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Butaca butaca = (Butaca) obj;
        return fila == butaca.fila && seient == butaca.seient;
    }

    @Override
    public String toString() {
        return "Fila: " + fila + ", Seient: " + seient + ", Persona: " + persona;
    }
}
