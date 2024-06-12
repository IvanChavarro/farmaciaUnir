
package co.com.unir.farmaciaunir.model;

import java.util.List;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;

/**
 *
 * @author ivanc
 */
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class Pedido {
    private String nombreMedicamento;
    private String tipoMedicamento;
    private Long cantidadMedicamento;
    private String nombreDistribuidor;
    private List<String> sucursal;

    public Pedido(String nombreMedicamento, String tipoMedicamento, Long cantidadMedicamento, String nombreDistribuidor, List<String> sucursal) {
        this.nombreMedicamento = nombreMedicamento;
        this.tipoMedicamento = tipoMedicamento;
        this.cantidadMedicamento = cantidadMedicamento;
        this.nombreDistribuidor = nombreDistribuidor;
        this.sucursal = sucursal;
    }

    public Pedido() {
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public String getTipoMedicamento() {
        return tipoMedicamento;
    }

    public void setTipoMedicamento(String tipoMedicamento) {
        this.tipoMedicamento = tipoMedicamento;
    }

    public Long getCantidadMedicamento() {
        return cantidadMedicamento;
    }

    public void setCantidadMedicamento(Long cantidadMedicamento) {
        this.cantidadMedicamento = cantidadMedicamento;
    }

    public String getNombreDistribuidor() {
        return nombreDistribuidor;
    }

    public void setNombreDistribuidor(String nombreDistribuidor) {
        this.nombreDistribuidor = nombreDistribuidor;
    }

    public List<String> getSucursal() {
        return sucursal;
    }

    public void setSucursal(List<String> sucursal) {
        this.sucursal = sucursal;
    }
    
    
}
