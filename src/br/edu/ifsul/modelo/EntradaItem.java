/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Vini
 */
@Entity
@Table(name = "entrada_item")

public class EntradaItem implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_entrada_item", sequenceName = "seq_entrada_item_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_entrada_item", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "valor_unitario", columnDefinition = "decimal(12,2)", nullable = false)
    @NotNull(message = "Informe o valor unitário")
    @Min(value = 0,message = "Valor unitario pode ser menor que 0")
    private Double valorUnitario;
    
    @Column(name = "valor_total", columnDefinition = "decimal(12,2)", nullable = false)
    @NotNull(message = "Informe o valor total")
    @Min(value = 0,message = "Valor total pode ser menor que 0")
    private Double valorTotal;
    
    @Column(name = "quantidade", columnDefinition = "decimal(12,2)", nullable = false)
    @NotNull(message = "Informe o quantidade")
    @Min(value = 0,message = "quantidade não pode ser menor que 0")
    private Double quantidade;
    
    @ManyToOne
    @NotNull(message = "Informe a entrada")
    @JoinColumn(name="entrada_id" ,referencedColumnName = "id", nullable = false)
    private Entrada entrada;
    
    @ManyToOne
    @NotNull(message = "Informe o produto")
    @JoinColumn(name="produto" ,referencedColumnName = "id", nullable = false)
    private Automovel produto;

    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    public EntradaItem() {
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
        final EntradaItem other = (EntradaItem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    public Automovel getProduto() {
        return produto;
    }

    public void setProduto(Automovel produto) {
        this.produto = produto;
    }
    
}
