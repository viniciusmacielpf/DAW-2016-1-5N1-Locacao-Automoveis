/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.modelo;

import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Vini
 */
@Entity

public class Representante {
   
    @EmbeddedId
    private RepresentanteID representanteID;
    
    @Column(name = "data_cadastro", nullable = false)
    @NotNull(message = "data de cadastro deve ser informado!")
    @Temporal(TemporalType.DATE)
    private Calendar dataCadastro;

    public RepresentanteID getRepresentanteID() {
        return representanteID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.representanteID);
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
        final Representante other = (Representante) obj;
        if (!Objects.equals(this.representanteID, other.representanteID)) {
            return false;
        }
        return true;
    }

    public void setRepresentanteID(RepresentanteID representanteID) {
        this.representanteID = representanteID;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    
    
}
