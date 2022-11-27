package br.senai.mima.projection.user;

import java.util.List;

import br.senai.mima.projection.estacao.EstacaoProjection;

public interface UserWithEstacoesProjection {
	
	String getId();
	
	String getNome();
	
	String getSobrename();
	
	String getEmail();
	
	String getSenha();
	
	String getPhone();
	
	List<EstacaoProjection> getEstacoes();
}
