package br.senai.mima.repository.medicao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senai.mima.entity.medicao.Medicao;
import br.senai.mima.projection.medicao.MedicaoProjection;

@Repository
public interface MedicaoRepository extends JpaRepository<Medicao, Long>{

	Optional<MedicaoProjection> findMedicaoById(Long id);
	
}
