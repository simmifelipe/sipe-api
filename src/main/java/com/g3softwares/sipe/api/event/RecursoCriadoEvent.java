package com.g3softwares.sipe.api.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class RecursoCriadoEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	private HttpServletResponse response;
	private Long codigo;
	private Object chavePk;

	public RecursoCriadoEvent(Object source, HttpServletResponse response, Long codigo) {
		super(source);
		this.response = response;
		this.codigo = codigo;
	}

	public RecursoCriadoEvent(Object source, HttpServletResponse response, Object chavePk) {
		super(source);
		this.response = response;
		this.chavePk = chavePk;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public Long getCodigo() {
		return codigo;
	}

	public Object getChavePk() {
		return chavePk;
	}

}