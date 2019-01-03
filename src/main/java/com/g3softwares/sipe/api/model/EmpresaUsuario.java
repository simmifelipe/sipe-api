package com.g3softwares.sipe.api.model;

import java.io.Serializable;

public class EmpresaUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long codigo;
	private Empresa empresa;
	private Modulo modulo;
	private Long nivel;

	public EmpresaUsuario(Long codigo, Empresa empresa, Modulo modulo) {
		super();
		this.codigo = codigo;
		this.empresa = empresa;
		this.modulo = modulo;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public Long getNivel() {
		return nivel;
	}

	public void setNivel(Long nivel) {
		this.nivel = nivel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		EmpresaUsuario other = (EmpresaUsuario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
