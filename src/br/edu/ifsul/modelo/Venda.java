/*
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
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Vini
 */
@Entity
@Table(name = "venda")
public class Venda implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_venda", sequenceName = "seq_venda_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_venda", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "data", nullable = false)
    @NotNull(message = "Data deve ser informado!")
    @Temporal(TemporalType.DATE)
    private Calendar data;

    @Column(name = "valor_total", columnDefinition = "decimal(12,2)", nullable = false)
    @NotNull(message = "valor não informado")
    private Double valorTotal;

    @Column(name = "qtd_parcelas", nullable = false)
    @NotNull(message = "Informe a quantidade de parcelas")
    @Min(value = 1, message = "Quantidade de parcelas não pode ser menor que {value}")
    private Integer qtdParcelas;
    
    @NotBlank(message="O tipo de pagamento deve ser informado")
    @Column(name="pagamento", nullable = false, length = 30)
    private String pagamentos;
    
    @NotNull(message = "Usuário deve ser informado")
    @ManyToOne
    @JoinColumn(name="usuario", referencedColumnName = "id", nullable = false)
    private Usuario usuario;
    
    @NotNull(message = "Pessoa deve ser informada")
    @ManyToOne
    @JoinColumn(name="pessoa_fisica", referencedColumnName = "id", nullable = false)
    private PessoaFisica pessoaFisica;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    private List<VendaItens> itens = new ArrayList<>();
    
    @OneToMany(mappedBy = "parcelaID.venda", cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Parcela> parcelas = new ArrayList<>();
    
    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", data=" + data + ", valorTotal=" + valorTotal + ", qtdParcelas=" + qtdParcelas + ", pagamentos=" + pagamentos + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Venda() {
         this.valorTotal = 0.0;
    }
    
    
    public void gerarParcelas(){
        Double valorParcela = this.valorTotal / this.qtdParcelas;
        
        for(int i = 1; i <= this.qtdParcelas; i++){
            Parcela p = new Parcela();
            ParcelaID id = new ParcelaID();
            id.setNumero(i);
            id.setVenda(this);
            p.setParcelaID(id);
            //Copiando a data corretamente
            Calendar vencimento = (Calendar) this.data.clone();
            vencimento.add(Calendar.MONTH, i);
            p.setVencimento(vencimento);
            p.setValor(valorParcela);
            this.parcelas.add(p);
        }
        
        
                
    }

    public void addItem(VendaItens obj) {
        obj.setVenda(this);
        this.valorTotal  = this.valorTotal + obj.getValorTotal();
        this.itens.add(obj);
    }

    public void removeItens(int index) {
        VendaItens obj = this.itens.get(index);
        this.valorTotal  = this.valorTotal - obj.getValorTotal();
        this.itens.remove(obj);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(Integer qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    public String getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(String pagamentos) {
        this.pagamentos = pagamentos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public List<VendaItens> getItens() {
        return itens;
    }

    public void setItens(List<VendaItens> itens) {
        this.itens = itens;
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }

    public void setParcelas(List<Parcela> parcelas) {
        this.parcelas = parcelas;
    }

}
