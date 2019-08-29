package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Fruteira implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Fruteira")
	@SequenceGenerator(name = "seq_Fruteira", sequenceName = "s_Fruteira", allocationSize = 1)
	private Long idFruteira;
	@Column(length = 50, nullable = true)
	private String nome;
	@Column
	private String endereco;


	public Long getIdFruteira() {
		return idFruteira;
	}
	public void setIdFruteira(Long idFruteira) {
		this.idFruteira = idFruteira;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + idFruteira);
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
		Fruteira other = (Fruteira) obj;
		if (idFruteira != other.idFruteira)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fruteira [idFruteira=" + idFruteira + ", nome=" + nome + "]";
	}
	

	
}
