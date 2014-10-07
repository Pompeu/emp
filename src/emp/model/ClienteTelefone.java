/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emp.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author IFGoiano
 */
@Entity
public class ClienteTelefone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_telefone", nullable = false)
    private Integer pkTelefone;
    @Column(name = "ddd", length = 2)
    private String ddd;
    @Column(name = "operadora", length = 20)
    private String operadora;
    @Column(name = "numero")
    private Integer numero;
    @JoinColumn(name = "fk_cliente", referencedColumnName = "pk_cliente")
    @ManyToOne
    private Cliente fkCliente;

    public ClienteTelefone() {
    }

    public ClienteTelefone(String ddd, String operadora, Integer numero, Cliente fkCliente) {
        this.ddd = ddd;
        this.operadora = operadora;
        this.numero = numero;
        this.fkCliente = fkCliente;
    }

    
    
    public Integer getPkTelefone() {
        return pkTelefone;
    }

    public void setPkTelefone(Integer pkTelefone) {
        this.pkTelefone = pkTelefone;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Cliente getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(Cliente fkCliente) {
        this.fkCliente = fkCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkTelefone != null ? pkTelefone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteTelefone)) {
            return false;
        }
        ClienteTelefone other = (ClienteTelefone) object;
        if ((this.pkTelefone == null && other.pkTelefone != null) || (this.pkTelefone != null && !this.pkTelefone.equals(other.pkTelefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emp.model.ClienteTelefone[ pkTelefone=" + pkTelefone + " ]";
    }
}
