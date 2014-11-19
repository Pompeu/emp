/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author pompeu
 */
@Entity
public class ClienteEndereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_endereco", nullable = false)
    private Integer pkClienteEndereco;
    @Column(name = "complemento", length = 20)
    private String complemento;
    @Column(name = "logradouro", length = 50)
    private String logradrouro;
    @Column(name = "cidade", length = 30)
    private String Cidade;
    @Column(name = "cep", length = 8)
    private String cep;
    @Column(name = "estado", length = 2)
    private String estado;

    public ClienteEndereco() {
    }

    public ClienteEndereco(Integer pkClienteEndereco) {
        this.pkClienteEndereco = pkClienteEndereco;
    }
    
    public ClienteEndereco(String complemento, String logradrouro, String Cidade, String cep, String estado) {
        this.complemento = complemento;
        this.logradrouro = logradrouro;
        this.Cidade = Cidade;
        this.cep = cep;
        this.estado = estado;
    }
    
    public Integer getPkClienteEndereco() {
        return pkClienteEndereco;
    }

    public void setPkClienteEndereco(Integer pkClienteEndereco) {
        this.pkClienteEndereco = pkClienteEndereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getLogradrouro() {
        return logradrouro;
    }

    public void setLogradrouro(String logradrouro) {
        this.logradrouro = logradrouro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ClienteEndereco{" + "pkClienteEndereco=" + pkClienteEndereco + ", complemento=" + complemento + ", logradrouro=" + logradrouro + ", Cidade=" + Cidade + ", cep=" + cep + ", estado=" + estado + '}';
    }

    @Override
    public int hashCode() {
        int hash = 31;
        hash += (pkClienteEndereco != null ? pkClienteEndereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClienteEndereco other = (ClienteEndereco) obj;
        return Objects.equals(this.pkClienteEndereco, other.pkClienteEndereco);
    }

}
