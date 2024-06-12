/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.com.unir.farmaciaunir.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/**
 *
 * @author ivanc
 */
public class ResumenPedidoFrame extends javax.swing.JFrame {

     public ResumenPedidoFrame(String distribuidor, Long unidades, String tipoMedicamento, String nombreMedicamento, String direccionFarmacia) {
        // Establecer el título de la ventana
        setTitle("Pedido al distribuidor " + distribuidor);

        // Inicializar componentes de la interfaz
        inicializarComponentes(distribuidor, unidades, tipoMedicamento, nombreMedicamento, direccionFarmacia);
    }

    private void inicializarComponentes(String distribuidor, Long unidades, String tipoMedicamento, String nombreMedicamento, String direccionFarmacia) {
        // Crear etiqueta con el título centrado
        JLabel titulo = new JLabel("CONFIRMACIÓN DE PEDIDO", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));

        // Crear separador
        JSeparator separator = new JSeparator(JSeparator.HORIZONTAL);

        // Crear panel para el título y separador
        JPanel panelTitulo = new JPanel(new BorderLayout());
        panelTitulo.add(titulo, BorderLayout.NORTH);
        panelTitulo.add(separator, BorderLayout.CENTER);

        // Crear etiquetas con la información del pedido
        JLabel distribuidorLabel = new JLabel("Pedido al distribuidor: " + distribuidor);
        JLabel unidadesLabel = new JLabel("Unidades: " + unidades);
        JLabel medicamentoLabel = new JLabel("Medicamento: " + tipoMedicamento + " " + nombreMedicamento);

        // Crear etiqueta para la dirección de la farmacia con posible salto de línea
        JLabel direccionLabel = new JLabel("<html>Dirección de la farmacia:<br>" + insertarSaltosDeLinea(direccionFarmacia) + "</html>");

        // Establecer fuente y bordes para el estilo de factura
        Font font = new Font("Arial", Font.BOLD, 14);
        distribuidorLabel.setFont(font);
        unidadesLabel.setFont(font);
        medicamentoLabel.setFont(font);
        direccionLabel.setFont(font);

        distribuidorLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        unidadesLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        medicamentoLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        direccionLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));

        // Crear imagen de código de barras
        JLabel codigoBarrasLabel = new JLabel();
        try {
            // Cargar el icono desde el directorio de recursos
            URL iconUrl = RegistroPedidoFrame.class.getResource("/images/codigoBarras.png");
            if (iconUrl != null) {
                ImageIcon icon = new ImageIcon(iconUrl);
                codigoBarrasLabel.setIcon(icon);
            } else {
                System.err.println("Icono no encontrado.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Crear panel central para etiquetas
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.add(panelTitulo); // Agregar título y separador
        panelCentral.add(distribuidorLabel);
        panelCentral.add(unidadesLabel);
        panelCentral.add(medicamentoLabel);
        panelCentral.add(direccionLabel);
        panelCentral.add(Box.createVerticalGlue()); // Espacio vertical
        panelCentral.add(codigoBarrasLabel);

        // Crear JScrollPane para el contenido
        JScrollPane scrollPane = new JScrollPane(panelCentral);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Crear panel para botones
        JButton cancelarButton = new JButton("Cancelar");
        JButton enviarButton = new JButton("Enviar");

        // Añadir ActionListener a los botones
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar el frame
                dispose();
            }
        });

        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para enviar el pedido (por ahora solo cierra el frame)
                System.out.println("Pedido enviado");
                JOptionPane.showMessageDialog(null, "Pedido enviado exitosamente.");
                dispose();
            }
        });

        JPanel panelBotones = new JPanel();
        panelBotones.add(cancelarButton);
        panelBotones.add(enviarButton);

        // Establecer layout del JFrame
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        // Configurar el tamaño y comportamiento del JFrame
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private String insertarSaltosDeLinea(String texto) {
        int maxCaracteresPorLinea = 30; // Máximo de caracteres por línea
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < texto.length()) {
            sb.append(texto, index, Math.min(index + maxCaracteresPorLinea, texto.length()));
            sb.append("<br>");
            index += maxCaracteresPorLinea;
        }
        return sb.toString();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
