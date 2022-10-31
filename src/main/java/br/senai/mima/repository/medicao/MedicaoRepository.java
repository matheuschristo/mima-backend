package br.senai.mima.repository.medicao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senai.mima.entity.medicao.Medicao;
import br.senai.mima.projection.medicao.MedicaoProjection;

@Repository
public interface MedicaoRepository extends JpaRepository<Medicao, LocalDate>{

	Optional<MedicaoProjection> findMedicaoById(Long id);
	
}
