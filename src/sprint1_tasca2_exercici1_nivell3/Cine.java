package sprint1_tasca2_exercici1_nivell3;

import java.util.Scanner;

public class Cine {
    private int nombreFiles;
    private int nombreSeients;
    private GestioButaques gestioButaques;

    public Cine() {
        gestioButaques = new GestioButaques();
        demanarDadesInicials();
    }

    public void iniciar() throws ExcepcioNomPersonaIncorrecte {
        boolean sortir = false;
        while (!sortir) {
            int opcio = menu();
            switch (opcio) {
                case 1:
                    mostrarButaques();
                    break;
                case 2:
                    mostrarButaquesPersona();
                    break;
                case 3:
                    reservarButaca();
                    break;
                case 4:
                    anularReserva();
                    break;
                case 5:
                    anularReservaPersona();
                    break;
                case 0:
                    sortir = true;
                    break;
                default:
                    System.out.println("Opció no vàlida.");
            }
        }
    }

    public int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.- Mostrar totes les butaques reservades.");
        System.out.println("2.- Mostrar les butaques reservades per una persona.");
        System.out.println("3.- Reservar una butaca.");
        System.out.println("4.- Anul·lar la reserva d’una butaca.");
        System.out.println("5.- Anul·lar totes les reserves d’una persona.");
        System.out.println("0.- Sortir.");
        System.out.print("Trieu una opció: ");
        return scanner.nextInt();
    }

    public void mostrarButaques() {
        if (gestioButaques.getButaques().isEmpty()) {
            System.out.println("No hi ha butaques reservades.");
        } else {
            for (Butaca butaca : gestioButaques.getButaques()) {
                System.out.println(butaca);
            }
        }
    }

    public void mostrarButaquesPersona() throws ExcepcioNomPersonaIncorrecte {
        String persona = introduirPersona();
        boolean found = false;
        for (Butaca butaca : gestioButaques.getButaques()) {
            if (butaca.getPersona().equalsIgnoreCase(persona)) {
                System.out.println(butaca);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Aquesta persona no té butaques reservades.");
        }
    }

    public void reservarButaca() throws ExcepcioNomPersonaIncorrecte {
        try {
            int fila = introduirFila();
            int seient = introduirSeient();
            String persona = introduirPersona();
            gestioButaques.afegirButaca(new Butaca(fila, seient, persona));
            System.out.println("Butaca reservada correctament.");
        } catch (ExcepcioButacaOcupada | ExcepcioFilaIncorrecta | ExcepcioSeientIncorrecte e) {
            System.out.println(e.getMessage());
        }
    }

    public void anularReserva() {
        try {
            int fila = introduirFila();
            int seient = introduirSeient();
            gestioButaques.eliminarButaca(fila, seient);
            System.out.println("Reserva anul·lada correctament.");
        } catch (ExcepcioButacaLliure | ExcepcioFilaIncorrecta | ExcepcioSeientIncorrecte e) {
            System.out.println(e.getMessage());
        }
    }

    public void anularReservaPersona() throws ExcepcioNomPersonaIncorrecte {
        String persona = introduirPersona();
        gestioButaques.getButaques().removeIf(butaca -> butaca.getPersona().equalsIgnoreCase(persona));
        System.out.println("Totes les reserves d'aquesta persona han estat anul·lades.");
    }

    public String introduirPersona() throws ExcepcioNomPersonaIncorrecte {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix el nom de la persona: ");
        String persona = scanner.nextLine();
        scanner.close();
        if (!persona.matches("[a-zA-Z\\s]+")) {
            throw new ExcepcioNomPersonaIncorrecte("El nom de la persona és incorrecte.");
        }
        return persona;
    }

    public void demanarDadesInicials() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix el nombre de files: ");
        nombreFiles = scanner.nextInt();
        System.out.print("Introdueix el nombre de seients per fila: ");
        nombreSeients = scanner.nextInt();
        scanner.close();
    }

    public int introduirFila() throws ExcepcioFilaIncorrecta {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix el número de fila: ");
        int fila = scanner.nextInt();
        scanner.close();
        if (fila < 1 || fila > nombreFiles) {
            throw new ExcepcioFilaIncorrecta("El número de fila és incorrecte.");
           
        }
        return fila;
    }

    public int introduirSeient() throws ExcepcioSeientIncorrecte {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix el número de seient: ");
        int seient = scanner.nextInt();
        scanner.close();
        if (seient < 1 || seient > nombreSeients) {
            throw new ExcepcioSeientIncorrecte("El número de seient és incorrecte.");
        }
        return seient;
    }
}