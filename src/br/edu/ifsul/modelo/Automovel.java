/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "automovel")

public class Automovel implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_automovel", sequenceName = "seq_automovel_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_automovel", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "modelo", length = 50, nullable = false)
    @NotBlank(message = "Informe um modelo!")
    @Length(max = 50, message = "o modelo não deve ultrapassar {max} caracteres")
    private String modelo;

    @Column(name = "estado_atual", length = 50, nullable = false)
    @NotBlank(message = "Informe um estado!")
    @Length(max = 50, message = "o estado não deve ultrapassar {max} caracteres")
    private String estadoAtual;
    
    @Column(name = "quilometragem", columnDefinition = "text")
    private String quilometragem;


    @Column(name = "ano", columnDefinition = "integer", nullable = false)
    @NotNull(message = "Informe o ano")
    @Min(value = 0, message = "Ano não pode ser menor que 0")
    private Double estoque;

    @ManyToOne
    @JoinColumn(name = "marca", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Informe a marca")
    private Marca marca;
    

    @OneToMany(mappedBy = "automovel", cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Reparos> reparos = new ArrayList<>();
  
     
    @ManyToMany
    @JoinTable(name = "auto_opcionais",
            joinColumns = @JoinColumn(name = "automovel", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "opcionais", referencedColumnName = "id", nullable = false))
    private List<Opcionais> opcionais = new ArrayList<>();

    public Automovel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    public void addReparos(Reparos obj){
        obj.setAutomovel(this);
        this.reparos.add(obj);
    }
    
    public void removeReparos(int index){
        this.reparos.remove(index);
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
        final Automovel other = (Automovel) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    public List<Opcionais> getDesejam() {
        return opcionais;
    }

    public void setDesejam(List<Opcionais> opcionais) {
        this.opcionais = opcionais;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getEstadoAtual() {
        return estadoAtual;
    }

    public void setEstadoAtual(String estadoAtual) {
        this.estadoAtual = estadoAtual;
    }

    public String getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(String quilometragem) {
        this.quilometragem = quilometragem;
    }

    public Double getEstoque() {
        return estoque;
    }

    public void setEstoque(Double estoque) {
        this.estoque = estoque;
    }

    public List<Reparos> getReparos() {
        return reparos;
    }

    public void setReparos(List<Reparos> reparos) {
        this.reparos = reparos;
    }

    public List<Opcionais> getOpcionais() {
        return opcionais;
    }

    public void setOpcionais(List<Opcionais> opcionais) {
        this.opcionais = opcionais;
    }


}
