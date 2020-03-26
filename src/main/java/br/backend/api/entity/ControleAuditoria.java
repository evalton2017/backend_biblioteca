package br.backend.api.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import br.backend.api.entity.auditoria.envers.AuditoriaListener;
import br.backend.api.enums.EnumTipoIntervencao;

@Entity
@RevisionEntity(AuditoriaListener.class)
@Table(name = "TB_CONTROLE_AUDITORIA")
public class ControleAuditoria {
	
	@Id
	@Column(name = "ID_CONTROLE_AUDITORIA")
	@RevisionNumber
	@SequenceGenerator(name = "controleAuditoriaGenerator")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "DH_AUDITORIA")
	@RevisionTimestamp
	private Date dataHora;
	
	@Column(name = "NR_CPF")
	private Long cpf;
	
	@Column(name = "ED_IP")
	private String ip;
	
	@Column(name = "CD_INTERVENCAO", nullable = false)
	private Integer tipoIntervencao;
	
	@Column(name = "CD_SISTEMA")
	private Integer sistema;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getSistema() {
		return sistema;
	}
	public void setSistema(Integer sistema) {
		this.sistema = sistema;
	}
	public EnumTipoIntervencao getTipoIntervencao() {
		if (tipoIntervencao != null) {
			for (EnumTipoIntervencao tipo : EnumTipoIntervencao.values()) {
				if (tipo.getValor().equals(tipoIntervencao)) {
					return tipo;
				}
			}
		}
		return null;
	}
	public void setTipoIntervencao(EnumTipoIntervencao tipoIntervencao) {
		this.tipoIntervencao = tipoIntervencao.getValor();
	}
}
