package br.backend.api.entity.auditoria.envers;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.envers.RevisionListener;

import br.backend.api.entity.ControleAuditoria;

public class AuditoriaListener implements RevisionListener{
	
	public static ThreadLocal<ContextoAuditoria> contextoDefinido = new ThreadLocal<ContextoAuditoria>();

	@Override
	public void newRevision(Object revisionEntity) {
		ControleAuditoria controleAuditoria = (ControleAuditoria) revisionEntity;

		ContextoAuditoria contexto = contextoDefinido.get();
		if(contexto == null) {
			contexto = ContextoAuditoria.getDefault();
		}
		
		controleAuditoria.setCpf(contexto.getUsuario());
		controleAuditoria.setIp(contexto.getIp());
		controleAuditoria.setTipoIntervencao(contexto.getTipoIntervencao());
		controleAuditoria.setSistema(contexto.getCodigoSistema());
		
	}

}
