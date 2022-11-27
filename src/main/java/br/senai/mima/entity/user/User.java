package br.senai.mima.entity.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senai.mima.entity.estacao.Estacao;

@Entity
@Table(name = "tb_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
	private Long id;
	
	@Column(name = "nome_user", nullable = false)
	private String nome;
	
	@Column(name = "sobrenome_user", nullable = false)
	private String sobrename;
	
	@Column(name = "email_user", nullable = false, unique = true)
	private String email;
	
	@Column(name = "senha_user", nullable = false)
	private String senha;
	
	@Column(name = "phone_user", unique = true)
	private String phone;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Estacao> estacoes = new ArrayList<>();
	
	public User() {}

	public User(Long id, String nome, String sobrename, String email, String senha, String phone) {
		this.id = id;
		this.nome = nome;
		this.sobrename = sobrename;
		this.email = email;
		this.senha = senha;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrename() {
		return sobrename;
	}

	public void setSobrename(String sobrename) {
		this.sobrename = sobrename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public List<Estacao> getEstacoes() {
		return estacoes;
	}
	
}
