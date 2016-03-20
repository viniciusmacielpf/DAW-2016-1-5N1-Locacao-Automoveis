/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Vini
 */
@Entity
@Table(name = "entrada")

public class Entrada implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_entrada", sequenceName = "seq_entrada_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_entrada", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "data", nullable = false)
    @NotNull(message = "Data deve ser informado!")
    @Temporal(TemporalType.DATE)
    private Calendar data;

    @Column(name = "nota", nullable = true, length = 10)
    @NotBlank(message = "Informe uma nota!")
    @Length(max = 10, message = "A nota não deve ultrapassar {max} caracteres")
    private String nota;

    @Column(name = "valor_total", columnDefinition = "decimal(12,2)", nullable = false)
    @NotNull(message = "valor não informado")
    private Double valorTotal;

    @OneToMany(mappedBy = "entrada", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<EntradaItem> itens = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Informe a Pessoa")
    private PessoaJuridica pessoa;
    
    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Entrada() {
        this.valorTotal = 0.0;
    }


    public void addItem(EntradaItem obj) {
        obj.setEntrada(this);
        this.valorTotal  = this.valorTotal + obj.getValorTotal();
        this.itens.add(obj);
    }

    public void removeItens(int index) {
        this.itens.remove(index);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Entrada other = (Entrada) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<EntradaItem> getItens() {
        return itens;
    }

    public void setItens(List<EntradaItem> itens) {
        this.itens = itens;
    }

    public PessoaJuridica getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaJuridica pessoa) {
        this.pessoa = pessoa;
    }

}
