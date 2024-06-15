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
import javax.swing.JOptionPane;

/**
 *
 * @author ivanc
 */
public class GenerarPedido {

    private final String DIR_PRINCIPAL = "Calle de la Rosa n. 28";
    private final String DIR_SECUNDARIA = "Calle Alcazabilla n.3";

    private static final String SUCURSAL_PRINCIPAL = "Principal";
    private static final String SUCURSAL_SECUNDARIA = "Secundaria";

    public void crearPedido(Pedido dto) {
        String direccion;
        if (dto.getSucursal().size() > 1) {
            direccion = DIR_PRINCIPAL + " y para la situada en " + DIR_SECUNDARIA;
        } else if (dto.getSucursal().get(0).equalsIgnoreCase("principal")) {
            direccion = DIR_PRINCIPAL;
        } else {
            direccion = DIR_SECUNDARIA;
        }
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

    public static boolean validarDatosIngresaros(String medicamento, String cantidad, ButtonGroup bg, boolean sucursalPrincipal, boolean sucursalSecundaria, JComboBox<String> tipoMedicamentoComboBox) {
        if (medicamento.isBlank() || cantidad.isBlank() || bg.getSelection() == null || (!sucursalPrincipal && !sucursalSecundaria)) {
            return false;
        } else {
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
            for (Enumeration<AbstractButton> buttons = bg.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    pedido.setNombreDistribuidor(button.getText());
                }
            }
            GenerarPedido generarPedido = new GenerarPedido();
            generarPedido.crearPedido(pedido);
        }
        return true;
    }
}
