package co.com.unir.farmaciaunir;

import co.com.unir.farmaciaunir.view.RegistroPedidoFrame;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class FarmaciaUnir {

    public static void main(String[] args) {
        RegistroPedidoFrame displayFrame = new RegistroPedidoFrame();
        displayFrame.setLocationRelativeTo(null);
        displayFrame.setResizable(false);
        displayFrame.setTitle("Registrar pedido");
        try {
            // Cargar el icono desde el directorio de recursos
            URL iconUrl = FarmaciaUnir.class.getResource("/images/unirPharmacy.png");
            if (iconUrl != null) {
                ImageIcon icon = new ImageIcon(iconUrl);
                displayFrame.setIconImage(icon.getImage());
            } else {
                System.err.println("Icono no encontrado.");
            }
        } catch (Exception ex) {
            Logger.getLogger(FarmaciaUnir.class.getName()).log(Level.SEVERE, null, ex);
        }

        displayFrame.setVisible(true);
    }
}
