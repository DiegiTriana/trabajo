import java.util.ArrayList;
import java.util.Scanner;

class Plato2 {
    private String nombre;
    private double precio;

    public Plato2(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Plato{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}

public class GestionRestaurante {
    private static ArrayList<Plato2> menu = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    agregarPlato(scanner);
                    break;
                case 2:
                    buscarPlato(scanner);
                    break;
                case 3:
                    modificarPlato(scanner);
                    break;
                case 4:
                    eliminarPlato(scanner);
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Gestión del Restaurante ---");
        System.out.println("1. Agregar Plato");
        System.out.println("2. Buscar Plato");
        System.out.println("3. Modificar Plato");
        System.out.println("4. Eliminar Plato");
        System.out.println("5. Salir");
    }

    private static void agregarPlato(Scanner scanner) {
        System.out.print("Ingrese el nombre del plato: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del plato: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();  // Consumir el salto de línea

        menu.add(new Plato2(nombre, precio));
        System.out.println("Plato agregado con éxito.");
    }

    private static void buscarPlato(Scanner scanner) {
        System.out.print("Ingrese el nombre del plato a buscar: ");
        String nombre = scanner.nextLine();

        for (Plato2 plato : menu) {
            if (plato.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Plato encontrado: " + plato);
                return;
            }
        }
        System.out.println("Plato no encontrado.");
    }

    private static void modificarPlato(Scanner scanner) {
        System.out.print("Ingrese el nombre del plato a modificar: ");
        String nombre = scanner.nextLine();

        for (Plato2 plato : menu) {
            if (plato.getNombre().equalsIgnoreCase(nombre)) {
                System.out.print("Ingrese el nuevo nombre del plato: ");
                String nuevoNombre = scanner.nextLine();
                System.out.print("Ingrese el nuevo precio del plato: ");
                double nuevoPrecio = scanner.nextDouble();
                scanner.nextLine();  // Consumir el salto de línea

                plato.setNombre(nuevoNombre);
                plato.setPrecio(nuevoPrecio);
                System.out.println("Plato modificado con éxito.");
                return;
            }
        }
        System.out.println("Plato no encontrado.");
    }

    private static void eliminarPlato(Scanner scanner) {
        System.out.print("Ingrese el nombre del plato a eliminar: ");
        String nombre = scanner.nextLine();

        for (Plato2 plato : menu) {
            if (plato.getNombre().equalsIgnoreCase(nombre)) {
                menu.remove(plato);
                System.out.println("Plato eliminado con éxito.");
                return;
            }
        }
        System.out.println("Plato no encontrado.");
    }
}

