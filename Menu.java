import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ABB abb = new ABB();
        boolean continuar = true;
        int opcion;

        while (continuar) {
            System.out.println();
            System.out.println("1. Inicializar");
            System.out.println("2. Mostrar");
            System.out.println("3. Buscar");
            System.out.println("4. Insertar");
            System.out.println("5. Eliminar");
            System.out.println("6. Modificar");
            System.out.println("7. Créditos");
            System.out.println("8. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    abb.EliminarABB(abb.r);
                    System.out.println("Árbol inicializado.");
                    break;
                case 2:
                    System.out.println("Mostrar de forma:");
                    System.out.println("1. PreOrder");
                    System.out.println("2. InOrder");
                    System.out.println("3. PostOrder");
                    int forma = scanner.nextInt();
                    switch (forma) {
                        case 1:
                            abb.PreOrder(abb.r);
                            break;
                        case 2:
                            abb.InOrder(abb.r);
                            break;
                        case 3:
                            abb.PostOrder(abb.r);
                            break;
                        default:
                            System.out.println("Opción no disponible");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el valor a buscar:");
                    int valor = scanner.nextInt();
                    abb.BuscarMostrar(valor);
                    break;
                case 4:
                    System.out.println("Ingrese el valor a insertar:");
                    int insertar = scanner.nextInt();
                    abb.Insertar(abb.r, insertar);
                    break;
                case 5:
                    System.out.println("Ingrese el valor a eliminar:");
                    int valore = scanner.nextInt();
                    abb.Eliminar(valore);
                    break;
                case 6:
                    System.out.println("Ingrese el valor a modificar:");
                    int valorm = scanner.nextInt();
                    System.out.println("Ingrese el valor nuevo:");
                    int valorn = scanner.nextInt();
                    abb.Eliminar(valorm);
                    abb.Insertar(abb.r, valorn);
                    System.out.println("El valor " + valorm + " ha sido modificado a " + valorn + " en el árbol.");
                    break;
                case 7:
                    System.out.println("Créditos:");
                    System.out.println("Materia: Estructura de datos");
                    System.out.println("Integrantes del equipo:");
                    System.out.println("David Gomez Herrera 22170035");
                    System.out.println("Maria de los Angeles Rivera Villegas 21030227");
                    break;
                case 8:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }
}