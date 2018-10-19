package com.g3softwares.sipe.api.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.g3softwares.sipe.api.model.pk.LiberacaoPK;

@Entity
@Table(name = "usuario_empresa_modulo_nivel")
public class Liberacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LiberacaoPK liberacaoPK;

	@NotNull
	private Integer nivel;

	public LiberacaoPK getLiberacaoPK() {
		return liberacaoPK;
	}

	public void setLiberacaoPK(LiberacaoPK liberacaoPK) {
		this.liberacaoPK = liberacaoPK;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((liberacaoPK == null) ? 0 : liberacaoPK.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Liberacao other = (Liberacao) obj;
		if (liberacaoPK == null) {
			if (other.liberacaoPK != null)
				return false;
		} else if (!liberacaoPK.equals(other.liberacaoPK))
			return false;
		return true;
	}

}
