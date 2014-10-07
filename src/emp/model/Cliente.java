/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author IFGoiano
 */
@Entity
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_cliente", nullable = false)
    private Integer pkCliente;
    @Column(name = "nome", length = 60)
    private String nome;
    @Column(name = "nascimento")
    @Temporal(TemporalType.DATE)
    private Date nascimento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "limite_credito", precision = 2147483647, scale = 0)
    private Double limiteCredito;
    @Column(name = "cpf", length = 11)
    private String cpf;
    @Column(name = "qtd_dependentes")
    private Integer qtdDependentes;
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @OneToMany(mappedBy = "fkCliente", cascade = CascadeType.ALL)
    private List<ClienteTelefone> clienteTelefoneList;

    public Cliente() {
    }
    

    public Cliente(String nome, Date nascimento, Double limiteCredito, String cpf, Integer qtdDependentes) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.limiteCredito = limiteCredito;
        this.cpf = cpf;
        this.qtdDependentes = qtdDependentes;

    }

    public Integer getPkCliente() {
        return pkCliente;
    }

    public void setPkCliente(Integer pkCliente) {
        this.pkCliente = pkCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(Double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getQtdDependentes() {
        return qtdDependentes;
    }

    public void setQtdDependentes(Integer qtdDependentes) {
        this.qtdDependentes = qtdDependentes;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @XmlTransient
    public List<ClienteTelefone> getClienteTelefoneList() {
        return clienteTelefoneList;
    }

    public void setClienteTelefoneList(List<ClienteTelefone> clienteTelefoneList) {
        this.clienteTelefoneList = clienteTelefoneList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkCliente != null ? pkCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.pkCliente == null && other.pkCliente != null) || (this.pkCliente != null && !this.pkCliente.equals(other.pkCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emp.model.Cliente[ pkCliente=" + pkCliente + " ]";
    }
}
