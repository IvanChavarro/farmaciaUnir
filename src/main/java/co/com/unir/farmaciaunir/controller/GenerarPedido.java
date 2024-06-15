/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.unir.farmaciaunir.controller;

import co.com.unir.farmaciaunir.model.Pedido;
import co.com.unir.farmaciaunir.view.RegistroPedidoFrame;
import co.com.unir.farmaciaunir.view.ResumenPedidoFrame;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 *
 * @author ivanc
 */
public class GenerarPedido {

    private final String DIR_PRINCIPAL = "Calle de la Rosa n. 28";
    private final String DIR_SECUNDARIA = "Calle Alcazabilla n.3";

    private static final String SUCURSAL_PRINCIPAL = "Principal";
    private static final String SUCURSAL_SECUNDARIA = "Secundaria";

    /**
     * Crea un resumen del pedido y muestra una ventana de confirmación.
     *
     * @param dto Objeto Pedido que contiene la información del pedido a
     * confirmar.
     */
    public void crearPedido(Pedido dto) {
        String direccion;
        // Determina la dirección basada en las sucursales seleccionadas
        if (dto.getSucursal().size() > 1) {
            direccion = DIR_PRINCIPAL + " y para la situada en " + DIR_SECUNDARIA;
        } else if (dto.getSucursal().get(0).equalsIgnoreCase("principal")) {
            direccion = DIR_PRINCIPAL;
        } else {
            direccion = DIR_SECUNDARIA;
        }
        // Crea y configura la ventana de resumen del pedido
        ResumenPedidoFrame resumenPedido = new ResumenPedidoFrame(dto.getNombreDistribuidor(), dto.getCantidadMedicamento(), dto.getTipoMedicamento(), dto.getNombreMedicamento(), direccion);
        resumenPedido.setLocationRelativeTo(null);
        resumenPedido.setResizable(false);
        resumenPedido.setTitle("Confirmar pedido");
        try {
            // Cargar el icono desde el directorio de recursos
            URL iconUrl = RegistroPedidoFrame.class.getResource("/images/unirPharmacy.png");
            if (iconUrl != null) {
                ImageIcon icon = new ImageIcon(iconUrl);
                resumenPedido.setIconImage(icon.getImage());
            } else {
                System.err.println("Icono no encontrado.");
            }
        } catch (Exception ex) {
            Logger.getLogger(RegistroPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        resumenPedido.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resumenPedido.setVisible(true);
    }

    /**
     * Valida los datos ingresados para un pedido antes de confirmarlo.
     *
     * @param medicamento Nombre del medicamento ingresado.
     * @param cantidad Cantidad requerida del medicamento.
     * @param bg Grupo de botones que representa los distribuidores disponibles.
     * @param sucursalPrincipal Indica si se seleccionó la sucursal principal.
     * @param sucursalSecundaria Indica si se seleccionó la sucursal secundaria.
     * @param tipoMedicamentoComboBox ComboBox que contiene los tipos de
     * medicamento disponibles.
     * @return true si todos los datos están correctamente ingresados y se puede
     * proceder con el pedido, false de lo contrario.
     */
    public static boolean validarDatosIngresados(String medicamento, String cantidad, ButtonGroup bg, boolean sucursalPrincipal, boolean sucursalSecundaria, JComboBox<String> tipoMedicamentoComboBox) {
        // Validar que todos los campos requeridos estén llenos
        if (medicamento.isBlank() || cantidad.isBlank() || bg.getSelection() == null || (!sucursalPrincipal && !sucursalSecundaria)) {
            return false;
        } else {
            // Crear el objeto Pedido con los datos ingresados
            List<String> sucursal = new ArrayList<>();
            if (sucursalPrincipal) {
                sucursal.add(SUCURSAL_PRINCIPAL);
            }
            if (sucursalSecundaria) {
                sucursal.add(SUCURSAL_SECUNDARIA);
            }
            Pedido pedido = new Pedido();
            pedido.setNombreMedicamento(medicamento);
            pedido.setTipoMedicamento(tipoMedicamentoComboBox.getSelectedItem().toString());
            pedido.setCantidadMedicamento(Long.parseLong(cantidad));
            pedido.setSucursal(sucursal);
            // Obtener el nombre del distribuidor seleccionado
            for (Enumeration<AbstractButton> buttons = bg.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    pedido.setNombreDistribuidor(button.getText());
                }
            }
            // Crear y confirmar el pedido
            GenerarPedido generarPedido = new GenerarPedido();
            generarPedido.crearPedido(pedido);
        }
        return true;
    }

}
