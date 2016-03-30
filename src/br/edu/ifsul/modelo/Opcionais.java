/*
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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
@Table(name = "opcionais")

public class Opcionais implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_opcionais", sequenceName = "seq_opcionais_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_opcionais", strategy = GenerationType.SEQUENCE)
    private Integer id;
        
    @Column(name = "descricao",nullable = true,length = 50)
    private String descricao;
    
//    @ManyToOne
//    @NotNull(message = "Informe o automovel")
//    @JoinColumn(name="pessoa_id" ,referencedColumnName = "id", nullable = false)
//   
    
     @ManyToMany
    @JoinTable(name = "auto_opcionais",
            joinColumns = @JoinColumn(name = "opcionais", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "automoveis", referencedColumnName = "id", nullable = false))
    private List<Automovel> automovel = new ArrayList<>();

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

   
    public Opcionais() {
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
        final Opcionais other = (Opcionais) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Automovel> getAutomovel() {
        return automovel;
    }

    public void setAutomovel(List<Automovel> automovel) {
        this.automovel = automovel;
    }
    
    
    
}
