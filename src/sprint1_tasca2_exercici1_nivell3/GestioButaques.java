package sprint1_tasca2_exercici1_nivell3;

import java.util.ArrayList;

public class GestioButaques {
    private ArrayList<Butaca> butaques;

    public GestioButaques() {
        butaques = new ArrayList<>();
    }

    public ArrayList<Butaca> getButaques() {
        return butaques;
    }

    public void afegirButaca(Butaca butaca) throws ExcepcioButacaOcupada {
        if (cercarButaca(butaca.getFila(), butaca.getSeient()) != -1) {
            throw new ExcepcioButacaOcupada("La butaca ja està ocupada.");
        }
        butaques.add(butaca);
    }

    public void eliminarButaca(int fila, int seient) throws ExcepcioButacaLliure {
        int index = cercarButaca(fila, seient);
        if (index == -1) {
            throw new ExcepcioButacaLliure("La butaca ja està lliure.");
        }
        butaques.remove(index);
    }

    public int cercarButaca(int fila, int seient) {
        for (int i = 0; i < butaques.size(); i++) {
            Butaca butaca = butaques.get(i);
            if (butaca.getFila() == fila && butaca.getSeient() == seient) {
                return i;
            }
        }
        return -1;
    }
}
