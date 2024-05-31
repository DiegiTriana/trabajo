import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GestionRestauranteGUI extends JFrame {
    private ArrayList<Plato> menu = new ArrayList<>();

    public GestionRestauranteGUI() {
        setTitle("Gestión del Restaurante");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1)); // Cambiado a 6 filas

        JButton btnAgregar = new JButton("Agregar Plato");
        JButton btnBuscar = new JButton("Buscar Plato");
        JButton btnModificar = new JButton("Modificar Plato");
        JButton btnEliminar = new JButton("Eliminar Plato");
        JButton btnHistorial = new JButton("Historial"); // Botón Historial
        JButton btnSalir = new JButton("Salir");

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPlato();
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPlato();
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarPlato();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarPlato();
            }
        });

        btnHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarHistorial();
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(btnAgregar);
        add(btnBuscar);
        add(btnModificar);
        add(btnEliminar);
        add(btnHistorial); // Añadir el botón Historial
        add(btnSalir);
    }

    private void agregarPlato() {
        JTextField nombreField = new JTextField();
        JTextField precioField = new JTextField();

        Object[] message = {
            "Nombre:", nombreField,
            "Precio:", precioField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Agregar Plato", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String nombre = nombreField.getText();
            double precio = Double.parseDouble(precioField.getText());
            menu.add(new Plato(nombre, precio));
            JOptionPane.showMessageDialog(this, "Plato agregado con éxito.");
        }
    }

    private void buscarPlato() {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del plato a buscar:");
        for (Plato plato : menu) {
            if (plato.getNombre().equalsIgnoreCase(nombre)) {
                JOptionPane.showMessageDialog(this, "Plato encontrado: " + plato);
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Plato no encontrado.");
    }

    private void modificarPlato() {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del plato a modificar:");
        for (Plato plato : menu) {
            if (plato.getNombre().equalsIgnoreCase(nombre)) {
                JTextField nuevoNombreField = new JTextField(plato.getNombre());
                JTextField nuevoPrecioField = new JTextField(String.valueOf(plato.getPrecio()));

                Object[] message = {
                    "Nuevo Nombre:", nuevoNombreField,
                    "Nuevo Precio:", nuevoPrecioField
                };

                int option = JOptionPane.showConfirmDialog(this, message, "Modificar Plato", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    plato.setNombre(nuevoNombreField.getText());
                    plato.setPrecio(Double.parseDouble(nuevoPrecioField.getText()));
                    JOptionPane.showMessageDialog(this, "Plato modificado con éxito.");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Plato no encontrado.");
    }

    private void eliminarPlato() {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del plato a eliminar:");
        for (Plato plato : menu) {
            if (plato.getNombre().equalsIgnoreCase(nombre)) {
                menu.remove(plato);
                JOptionPane.showMessageDialog(this, "Plato eliminado con éxito.");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Plato no encontrado.");
    }

    private void mostrarHistorial() {
        JFrame historialFrame = new JFrame("Historial de Platos");
        historialFrame.setSize(300, 200);
        historialFrame.setLocationRelativeTo(this);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        for (Plato plato : menu) {
            textArea.append(plato.toString() + "\n");
        }

        historialFrame.add(new JScrollPane(textArea));
        historialFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GestionRestauranteGUI().setVisible(true);
            }
        });
    }
}

