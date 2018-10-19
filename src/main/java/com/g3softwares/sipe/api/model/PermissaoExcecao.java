package com.g3softwares.sipe.api.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.g3softwares.sipe.api.model.pk.PermissaoExcecaoPK;

@Entity
@Table(name = "permissao_excecao")
public class PermissaoExcecao implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PermissaoExcecaoPK excecaoPK;

	private boolean acesso;

	public PermissaoExcecaoPK getExcecaoPK() {
		return excecaoPK;
	}

	public void setExcecaoPK(PermissaoExcecaoPK excecaoPK) {
		this.excecaoPK = excecaoPK;
	}

	public boolean isAcesso() {
		return acesso;
	}

	public void setAcesso(boolean acesso) {
		this.acesso = acesso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((excecaoPK == null) ? 0 : excecaoPK.hashCode());
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
		PermissaoExcecao other = (PermissaoExcecao) obj;
		if (excecaoPK == null) {
			if (other.excecaoPK != null)
				return false;
		} else if (!excecaoPK.equals(other.excecaoPK))
			return false;
		return true;
	}

}
