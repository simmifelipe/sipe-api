package com.g3softwares.sipe.api.model.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.g3softwares.sipe.api.model.EmpresaModulo;
import com.g3softwares.sipe.api.model.Usuario;

@Embeddable
public class LiberacaoPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "codigo_usuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "codigo_empresa_modulo")
	private EmpresaModulo empresaModulo;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public EmpresaModulo getEmpresaModulo() {
		return empresaModulo;
	}

	public void setEmpresaModulo(EmpresaModulo empresaModulo) {
		this.empresaModulo = empresaModulo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empresaModulo == null) ? 0 : empresaModulo.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		LiberacaoPK other = (LiberacaoPK) obj;
		if (empresaModulo == null) {
			if (other.empresaModulo != null)
				return false;
		} else if (!empresaModulo.equals(other.empresaModulo))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
