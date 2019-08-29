package model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Fruta implements Serializable {	 

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Fruta")
	@SequenceGenerator(name = "seq_Fruta", sequenceName = "s_Fruta", allocationSize = 1)
	private Long idFruta;
	@Column(length = 50, nullable = false)
	private String nome;
	@Column(length = 10, nullable = false)
	private double preco;
	
	 @OneToMany(cascade = CascadeType.ALL)	
	 private List<Fruteira> fruteiras;
	 
	 @OneToMany(cascade = CascadeType.ALL)	
	 private List<Classificacao> classificacao;
	 

	public List<Fruteira> getFrutas() {
		return fruteiras;
	}
	public void setFrutas(List<Fruteira> frutas) {
		this.fruteiras = frutas;
	}
	public List<Classificacao> getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(List<Classificacao> classificacao) {
		this.classificacao = classificacao;
	}
	public Long getIdFruta() {
		return idFruta;
	}
	public void setIdFruta(Long idFruta) {
		this.idFruta = idFruta;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

	





	
}
