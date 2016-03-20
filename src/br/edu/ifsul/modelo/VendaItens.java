/*
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Vini
 */
@Entity
@Table(name = "venda_itens")
public class VendaItens implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_venda_item", sequenceName = "seq_venda_item_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_venda_item", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "quantidade", columnDefinition = "decimal(12,2)", nullable = false)
    @NotNull(message = "Informe o quantidade")
    @Min(value = 0, message = "quantidade não pode ser menor que 0")
    private Double quantidade;

    @Column(name = "valor_unitario", columnDefinition = "decimal(12,2)", nullable = false)
    @NotNull(message = "Informe o valor unitário")
    @Min(value = 0, message = "Valor unitario pode ser menor que 0")
    private Double valorUnitario;

    @Column(name = "valor_total", columnDefinition = "decimal(12,2)", nullable = false)
    @NotNull(message = "Informe o valor total")
    @Min(value = 0, message = "Valor total pode ser menor que 0")
    private Double valorTotal;
    
    @NotNull(message = "Produto deve ser infomrado!")
    @ManyToOne
    @JoinColumn(name="produto", referencedColumnName = "id", nullable = false)
    private Produto produto;
    
    @NotNull(message = "A venda deve ser infomrado!")
    @ManyToOne
    @JoinColumn(name="venda_id", referencedColumnName = "id", nullable = false)
    private Venda venda;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final VendaItens other = (VendaItens) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public VendaItens() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

}
