package br.senai.mima.repository.estacao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senai.mima.entity.estacao.Estacao;
import br.senai.mima.projection.estacao.EstacaoProjection;
import br.senai.mima.projection.estacao.EstacaoWithMedicaoProjection;

@Repository
public interface EstacaoRepository extends JpaRepository<Estacao, Long>{

	Optional<EstacaoProjection> findEstacaoById(Long id);
	
	Optional<EstacaoWithMedicaoProjection> findEstacaoWithMedicaoById(Long id);
	
}
