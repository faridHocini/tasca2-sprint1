package sprint1_tasca2_exercici1_nivell2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {
    private static Scanner scanner = new Scanner(System.in);

    public static byte llegirByte(String missatge) {
        byte valor = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.println(missatge);
                valor = scanner.nextByte();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Error de format. Introduïu un valor byte.");
                scanner.next(); // Neteja l'entrada incorrecta
            }
        }
        return valor;
    }

    public static int llegirInt(String missatge) {
        int valor = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.println(missatge);
                valor = scanner.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Error de format. Introduïu un valor enter.");
                scanner.next(); // Neteja l'entrada incorrecta
            }
        }
        return valor;
    }

    public static float llegirFloat(String missatge) {
        float valor = 0.0f;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.println(missatge);
                valor = scanner.nextFloat();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Error de format. Introduïu un valor float.");
                scanner.next(); // Neteja l'entrada incorrecta
            }
        }
        return valor;
    }

    public static double llegirDouble(String missatge) {
        double valor = 0.0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.println(missatge);
                valor = scanner.nextDouble();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Error de format. Introduïu un valor double.");
                scanner.next(); // Neteja l'entrada incorrecta
            }
        }
        return valor;
    }

    public static char llegirChar(String missatge) {
        char valor = ' ';
        boolean valid = false;
        while (!valid) {
            try {
                System.out.println(missatge);
                String input = scanner.next();
                if (input.length() == 1) {
                    valor = input.charAt(0);
                    valid = true;
                } else {
                    throw new Exception("Error de format. Introduïu un sol caràcter.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return valor;
    }

    public static String llegirString(String missatge) {
        String valor = "";
        boolean valid = false;
        while (!valid) {
            try {
                System.out.println(missatge);
                valor = scanner.next();
                valid = true;
            } catch (Exception e) {
                System.out.println("Error de format. Introduïu una cadena de text.");
            }
        }
        return valor;
    }

    public static boolean llegirSiNo(String missatge) {
        boolean valor = false;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.println(missatge + " (s/n)");
                String input = scanner.next().toLowerCase();
                if (input.equals("s")) {
                    valor = true;
                    valid = true;
                } else if (input.equals("n")) {
                    valor = false;
                    valid = true;
                } else {
                    throw new Exception("Error de format. Introduïu 's' o 'n'.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return valor;
    }

    public static void main(String[] args) {
        // Exemples d'ús dels mètodes
        byte edat = llegirByte("Introdueix la teva edat:");
        int numero = llegirInt("Introdueix un número enter:");
        float altura = llegirFloat("Introdueix la teva altura en metres:");
        double pes = llegirDouble("Introdueix el teu pes en kg:");
        char inicial = llegirChar("Introdueix la inicial del teu nom:");
        String nom = llegirString("Introdueix el teu nom:");
        boolean resposta = llegirSiNo("Vols continuar?");
        
        // Mostrar els resultats
        System.out.println("Edat: " + edat);
        System.out.println("Número sencer: " + numero);
        System.out.println("Altura: " + altura);
        System.out.println("Pes: " + pes);
        System.out.println("Inicial: " + inicial);
        System.out.println("Nom: " + nom);
        System.out.println("Resposta: " + (resposta ? "Sí" : "No"));
    }
}