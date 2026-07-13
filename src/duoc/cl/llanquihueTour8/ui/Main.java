import duoc.cl.llanquihueTour8.model.GuiaTuristico;
import duoc.cl.llanquihueTour8.model.IRegistrable;
import duoc.cl.llanquihueTour8.model.ServicioTuristico;
import duoc.cl.llanquihueTour8.model.Vehiculo;
import duoc.cl.llanquihueTour8.service.GestorDatos;
import duoc.cl.llanquihueTour8.service.GestorEntidades;
import javax.swing.*;
import duoc.cl.llanquihueTour8.model.*;

import java.awt.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaUsuario().setVisible(true));
    }
}


    //Clase Ventana usuario para interactuar con el usuario
        class VentanaUsuario extends JFrame {
            private final GestorEntidades gestor = new GestorEntidades();
            private final JComboBox<String> comboTipo = new JComboBox<>(
                    new String[]{"Guía Turístico", "Colaborador Externo", "Vehículo"});
            private final JLabel lblCampo1 = new JLabel("Nombre:");
            private final JLabel lblCampo2 = new JLabel("Especialidad:");
            private final JTextField txtCampo1 = new JTextField(15);
            private final JTextField txtCampo2 = new JTextField(15);
            private final JTextArea areaEntidades = new JTextArea();

            public VentanaUsuario() {
                //Se dan tamaño y estilos a la ventana
                super("Llanquihue Tour - Registro de Entidades");
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setSize(700, 500);
                setLocationRelativeTo(null);
                setLayout(new BorderLayout(15, 15));
                add(crearPanelFormulario(), BorderLayout.NORTH);
                add(crearPanelLista(), BorderLayout.CENTER);

                comboTipo.addActionListener(e -> actualizarEtiquetas());
                actualizarEtiquetas();
                actualizarArea();
            }

            private JPanel crearPanelFormulario() {
                JPanel panel = new JPanel(new GridBagLayout());
                panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 20, 20));
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(6, 6, 6, 6);
                gbc.fill = GridBagConstraints.HORIZONTAL;

                agregarFila(panel, gbc, 0, new JLabel("Tipo de entidad:"), comboTipo);
                agregarFila(panel, gbc, 1, lblCampo1, txtCampo1);
                agregarFila(panel, gbc, 2, lblCampo2, txtCampo2);

                JButton btnGuardar = new JButton("Guardar");
                btnGuardar.setBackground(new Color(46, 139, 87));
                btnGuardar.setForeground(Color.WHITE);
                btnGuardar.setOpaque(true);
                btnGuardar.setBorderPainted(false);
                btnGuardar.addActionListener(e -> guardarEntidad());

                JButton btnLimpiar = new JButton("Limpiar");
                btnLimpiar.addActionListener(e -> limpiarCampos());

                JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
                panelBotones.add(btnGuardar);
                panelBotones.add(btnLimpiar);

                gbc.gridx = 0;
                gbc.gridy = 3;
                gbc.gridwidth = 2;
                panel.add(panelBotones, gbc);

                return panel;
            }

            //Se crean las filas de para solicitar al usuario que agregue la info: nombre --- *escribe le nombre*
            private void agregarFila(JPanel panel, GridBagConstraints gbc, int fila, JComponent label, JComponent campo) {
                gbc.gridx = 0;
                gbc.gridy = fila;
                gbc.weightx = 0;
                gbc.gridwidth = 1;
                panel.add(label, gbc);
                gbc.gridx = 1;
                gbc.weightx = 1;
                panel.add(campo, gbc);
            }

            private JPanel crearPanelLista() {
                areaEntidades.setEditable(false);
                areaEntidades.setLineWrap(true);
                areaEntidades.setWrapStyleWord(true);

                JScrollPane scroll = new JScrollPane(areaEntidades);
                scroll.setBorder(BorderFactory.createTitledBorder("Entidades registradas"));

                JPanel panel = new JPanel(new BorderLayout());
                panel.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));
                panel.add(scroll, BorderLayout.CENTER);
                return panel;
            }

            //Con este metodo se va cambiando la opcion que elija el usuario de lo que quiere registrar
            private void actualizarEtiquetas() {
                switch ((String) comboTipo.getSelectedItem()) {
                    case "Guía Turístico" -> {
                        lblCampo1.setText("Nombre:");
                        lblCampo2.setText("Especialidad:");
                    }
                    case "Colaborador Externo" -> {
                        lblCampo1.setText("Nombre:");
                        lblCampo2.setText("Rol:");
                    }
                    case "Vehículo" -> {
                        lblCampo1.setText("Patente:");
                        lblCampo2.setText("Tipo de vehículo:");
                    }
                }
            }

            private void guardarEntidad() {
                String valor1 = txtCampo1.getText().trim();
                String valor2 = txtCampo2.getText().trim();

                if (valor1.isEmpty() || valor2.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Debe completar todos los campos.",
                            "Datos incompletos", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                IRegistrable entidad = switch ((String) comboTipo.getSelectedItem()) {
                    case "Guía Turístico" -> new GuiaTuristico(valor1, valor2);
                    case "Colaborador Externo" -> new ColaboradorExterno(valor1, valor2);
                    case "Vehículo" -> new Vehiculo(valor1, valor2);
                    default -> null;
                };
                if (entidad == null) return;

                gestor.agregarEntidad(entidad);
                actualizarArea();
                limpiarCampos();
            }

            private void actualizarArea() {
                StringBuilder sb = new StringBuilder();
                for (IRegistrable e : gestor.obtenerEntidades()) {
                    sb.append(gestor.formatearLinea(e)).append("\n");
                }
                areaEntidades.setText(sb.toString());
            }

            private void limpiarCampos() {
                txtCampo1.setText("");
                txtCampo2.setText("");
                txtCampo1.requestFocus();
            }
        }


       /* GestorEntidades entidad = new GestorEntidades();
        List<IRegistrable> lista = entidad.obtenerEntidades();


        // Imprime el resumen base de cada clase hija
        for (IRegistrable r : lista) {
            r.mostrarResumen();

            System.out.println("\n--------***--------");
        }

        // Imprime busquedas específicas
        for (IRegistrable r : lista) {
            if (r instanceof GuiaTuristico g) {
                System.out.println("Especialidad: " + g.getEspecialidad());
            } else if (r instanceof Vehiculo v) {
                System.out.println("Tipo: " + v.getTipo());
            }


        }

    }*/
