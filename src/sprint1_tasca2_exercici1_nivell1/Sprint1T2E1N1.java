package sprint1_tasca2_exercici1_nivell1;

public class Sprint1T2E1N1 {

	public static void main(String[] args) {
        // Crear productes
        Producte p1 = new Producte("Llibre", 12.99);
        Producte p2 = new Producte("Bolígraf", 1.29);

        // Crear venda i afegir productes
        Venda venda = new Venda();

        try {
            // Intentar calcular el total sense afegir productes
            venda.calcularTotal();
        } catch (VendaBuidaException e) {
            System.out.println(e.getMessage());
        }

        // Afegir productes a la venda
        venda.afegirProducte(p1);
        venda.afegirProducte(p2);

        try {
            // Calcular el total amb productes afegits
            venda.calcularTotal();
            System.out.println("Preu total de la venda: " + venda.getPreuTotal());
        } catch (VendaBuidaException e) {
            System.out.println(e.getMessage());
        }

        // Generar i capturar ArrayIndexOutOfBoundsException
        try {
            int[] array = {1, 2, 3};
            // Accedir a un índex fora dels límits
            int valor = array[4];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("S'ha capturat una excepció ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}
