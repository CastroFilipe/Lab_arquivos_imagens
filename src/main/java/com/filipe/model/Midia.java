package com.filipe.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "QIZ_MIDIA",  uniqueConstraints = { 
		@UniqueConstraint (columnNames = "ID_MIDIA", name = "UK_ID_MIDIA")
})
@SequenceGenerator(name = "SEQ_MIDIA", sequenceName = "SQ_MIDIA", initialValue = 1, allocationSize = 1)
public class Midia implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_MIDIA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MIDIA")
	private Long id;
	
	@Lob
	@Column(name = "IM_ARQUIVO_MIDIA", nullable = false)
	private Blob arquivoMidia;
	
	@Column(name = "TX_DESCRICAO")
	private String descricao;

	public Midia() {
		super();
	}

	public Midia(Long id, Blob arquivoMidia, String descricao) {
		super();
		this.id = id;
		this.arquivoMidia = arquivoMidia;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Blob getArquivoMidia() {
		return arquivoMidia;
	}

	public void setArquivoMidia(Blob arquivoMidia) {
		this.arquivoMidia = arquivoMidia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
