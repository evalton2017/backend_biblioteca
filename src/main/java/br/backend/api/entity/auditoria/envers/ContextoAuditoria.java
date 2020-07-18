
package br.backend.api.entity.auditoria.envers;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.backend.api.enums.EnumTipoIntervencao;
import br.backend.api.user.User;

 public class ContextoAuditoria {
	
	private Long usuario;
	private String ip;
	private EnumTipoIntervencao tipoIntervencao;
	private Integer codigoSistema;
	
	
	@Transactional
	public static ContextoAuditoria getDefault() {	
		 FacesContext fc = FacesContext.getCurrentInstance();
		// HttpSession session = (HttpSession)fc.getExternalContext().getSession(false);
		 
		 //ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		 	 
		ContextoAuditoria contexto = new ContextoAuditoria();
		User user = (User) getSession().getAttribute("usuarioLogado");
		
		if(user==null) {
			user = new User();
			user.setId(1L);
			user.setIp("127.0.0.0");
		}
						
		contexto.setUsuario(user.getId());
		contexto.setIp(user.getIp());
		contexto.setTipoIntervencao(EnumTipoIntervencao.SISTEMA);
		contexto.setCodigoSistema(12);
		
		return contexto;
		
	}
	
	private static HttpServletRequest getRequest() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return requestAttributes.getRequest();
	}
	
	private static HttpSession getSession() {
		return getRequest().getSession();
	}



	public Long getUsuario() {
		return usuario;
	}

 
	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}


	public EnumTipoIntervencao getTipoIntervencao() {
		return tipoIntervencao;
	}


	public void setTipoIntervencao(EnumTipoIntervencao tipoIntervencao) {
		this.tipoIntervencao = tipoIntervencao;
	}


	public Integer getCodigoSistema() {
		return codigoSistema;
	}


	public void setCodigoSistema(Integer codigoSistema) {
		this.codigoSistema = codigoSistema;
	}
	
	
	

}
