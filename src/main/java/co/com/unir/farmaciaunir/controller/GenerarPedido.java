/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.unir.farmaciaunir.controller;

import co.com.unir.farmaciaunir.model.Pedido;
import co.com.unir.farmaciaunir.view.RegistroPedidoFrame;
import co.com.unir.farmaciaunir.view.ResumenPedidoFrame;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author ivanc
 */
public class GenerarPedido {

    private final String DIR_PRINCIPAL = "Calle de la Rosa n. 28";
    private final String DIR_SECUNDARIA = "Calle Alcazabilla n.3";

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

}
