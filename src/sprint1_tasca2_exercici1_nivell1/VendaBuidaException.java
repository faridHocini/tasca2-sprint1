package sprint1_tasca2_exercici1_nivell1;

public class VendaBuidaException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5993881362429680597L;

	public VendaBuidaException() {
        super("Per fer una venda primer has d’afegir productes");
    }
}
