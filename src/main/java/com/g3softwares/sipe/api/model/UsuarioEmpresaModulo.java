package com.g3softwares.sipe.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.g3softwares.sipe.api.model.pk.UsuarioEmpresaModuloPK;

@Entity
@Table(name = "usuario_empresa_modulo")
public class UsuarioEmpresaModulo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private UsuarioEmpresaModuloPK usuarioEmpresaModuloPK;

	@Column(name = "nivel")
	private Integer nivel;

	public UsuarioEmpresaModuloPK getUsuarioEmpresaModuloPK() {
		return usuarioEmpresaModuloPK;
	}

	public void setUsuarioEmpresaModuloPK(UsuarioEmpresaModuloPK usuarioEmpresaModuloPK) {
		this.usuarioEmpresaModuloPK = usuarioEmpresaModuloPK;
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
		result = prime * result + ((usuarioEmpresaModuloPK == null) ? 0 : usuarioEmpresaModuloPK.hashCode());
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
		UsuarioEmpresaModulo other = (UsuarioEmpresaModulo) obj;
		if (usuarioEmpresaModuloPK == null) {
			if (other.usuarioEmpresaModuloPK != null)
				return false;
		} else if (!usuarioEmpresaModuloPK.equals(other.usuarioEmpresaModuloPK))
			return false;
		return true;
	}
	
	

}
