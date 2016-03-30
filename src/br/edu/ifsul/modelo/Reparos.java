/*
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Vini
 *
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "reparos")

public class Reparos implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_reparos", sequenceName = "seq_reparos_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_reparos", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "descricao", nullable = true, length = 50)
    private String descricao;

    @Column(name = "data_reparo", nullable = false)
    @NotNull(message = "Data deve ser informado!")
    @Temporal(TemporalType.DATE)
    private Calendar dataReparo;

    @Column(name = "previsao_entrega", nullable = false)
    @NotNull(message = "Previsão deve ser informado!")
    @Temporal(TemporalType.DATE)
    private Calendar previsaoEntrega;

    @Column(name = "valor", columnDefinition = "decimal(12,2)", nullable = false)
    @NotNull(message = "valor não informado")
    private Double valor;
 
    @ManyToOne
    @NotNull(message = "Informe o automovel")
    @JoinColumn(name="automovel_id" ,referencedColumnName = "id", nullable = false)
    private Automovel automovel;
     
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Reparos() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Reparos other = (Reparos) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Calendar getDataReparo() {
        return dataReparo;
    }

    public void setDataReparo(Calendar dataReparo) {
        this.dataReparo = dataReparo;
    }

    public Calendar getPrevisaoEntrega() {
        return previsaoEntrega;
    }

    public void setPrevisaoEntrega(Calendar previsaoEntrega) {
        this.previsaoEntrega = previsaoEntrega;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

}
