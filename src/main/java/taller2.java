import java.util.Random;
import java.util.Scanner;

public class taller2 {
    public static void main(String[] args) {
        double[][] notas = new double[50][5];
        menu(notas);
    }

    private static void menu(double[][] notas){
        Scanner teclado = new Scanner(System.in);
        System.out.println("MENU");
        System.out.println("Que accion desea realizar? Ingrese el numero correspondiente");
        System.out.println("[1] Agregar Estudiante");
        System.out.println("[2] Mostrar Estudiantes Aprobados");
        System.out.println("[3] Mostrar Estudiantes Reprobados");
        System.out.println("[4] Mostrar Estudiantes que van a examen");
        System.out.println("[5] Mostrar estado de Estudiantes");
        System.out.println("[6] Salir");
        String respuesta = teclado.next();

        switch (respuesta){
            case "1": agregarEstudiante(notas);
                break;
            case "2": estudiantesAprobados(notas);
                break;
            case "3": estudiantesReprobados(notas);
                break;
            case "4": estudiantesAExamen(notas);
                break;
            case "5": estadoEstudiantes(notas);
                break;
            case "6": System.exit(0);
                break;
            default:
                System.out.println("Ingrese una opcion valida");
                menu(notas);
                break;
        }
        menu(notas);
    }

    private static void estadoEstudiantes(double[][] notas) {
        double[] ponderaciones = {0.25, 0.25, 0.25, 0.15, 0.10};
        for (int i = 0; i < 50; i++) {
            double suma = 0;
            if (notas[i][0]!=0)
                for (int j = 0; j < 5; j++) {
                    suma += notas[i][j]*ponderaciones[j];
                }

            if (notas[i][0]!=0){
                System.out.println("Notas estudiante #"+(i+1));
                for (int j = 0; j < 5; j++) {
                    System.out.println(notas[i][j]);
                }
                System.out.println("Promedio estudiante #"+(i+1));
                System.out.println(suma);
            }
            suma = 0;
        }

    }


    private static void estudiantesAExamen(double[][] notas) {
        double[] ponderaciones = {0.25, 0.25, 0.25, 0.15, 0.10};

        for (int i = 0; i < 50; i++) {
            double suma = 0;
            if (notas[i][0]!=0)
                for (int j = 0; j < 5; j++) {
                    suma += notas[i][j]*ponderaciones[j];
                }
            if (suma<4.0&&suma>=3.6) {
                System.out.println("Estudiante #" + (i + 1) + " va a Examen");
            }
            suma = 0;
        }
    }

    private static void estudiantesReprobados(double[][] notas) {
        double[] ponderaciones = {0.25, 0.25, 0.25, 0.15, 0.10};

        for (int i = 0; i < 50; i++) {
            double suma = 0;
            if (notas[i][0]!=0)
                for (int j = 0; j < 5; j++) {
                    suma += notas[i][j]*ponderaciones[j];
                }
            if (suma<4.0&&suma>0.5) {
                System.out.println("Estudiante #" + (i + 1) + " Reprobó");
            }
            suma = 0;
        }

    }

    private static void agregarEstudiante(double[][] notas) {
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            if (notas[i][0] == 0) {
                for (int j = 0; j < 5; j++) {
                    notas[i][j] = random.nextDouble(1.0, 7.0);
                }
                System.out.println("Numeros de estudiantes ingresados: " + (i + 1));
                break;
            }
        }
    }

    private static void estudiantesAprobados(double[][] notas){
        double[] ponderaciones = {0.25, 0.25, 0.25, 0.15, 0.10};

        for (int i = 0; i < 50; i++) {
            double suma = 0;
            if (notas[i][0]!=0)
                for (int j = 0; j < 5; j++) {
                    suma += notas[i][j]*ponderaciones[j];
                }
            if (suma>=4.0) {
                    System.out.println("Estudiante #" + (i + 1) + " Aprobo");
            }
            suma = 0;
        }
    }
}



