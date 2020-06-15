package com.Generation.clinica.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="tbFicha")
public class Ficha {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codFicha")
	private long codFicha;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codPaciente", referencedColumnName="codPaciente")
	private Paciente paciente;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="crm", referencedColumnName="crm")
	private Medico Medico;
	
	@Column(name="dataConsulta")
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dataConsulta = new java.sql.Date(System.currentTimeMillis());
	
	@Column(name="valorConsulta")
	@NotNull
	private double valorConsulta;
	
	@Column(name="diagnostico",length=255)
	private String diagnostico;
	
	@Column(name="procedimeno",length=255)
	private String procedimento;
	
	@Column(name="exame",length=255)
	private String exame;
	
	@Column(name="dataRetorno")
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dataRetorno;

	public long getCodFicha() {
		return codFicha;
	}

	public void setCodFicha(long codFicha) {
		this.codFicha = codFicha;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return Medico;
	}

	public void setMedico(Medico medico) {
		Medico = medico;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public double getValorConsulta() {
		return valorConsulta;
	}

	public void setValorConsulta(double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(String procedimento) {
		this.procedimento = procedimento;
	}

	public String getExame() {
		return exame;
	}

	public void setExame(String exame) {
		this.exame = exame;
	}

	public Date getDataRetorno() {
		return dataRetorno;
	}

	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}

	
	
}
