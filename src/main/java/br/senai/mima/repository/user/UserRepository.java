package br.senai.mima.repository.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senai.mima.entity.user.User;
import br.senai.mima.projection.user.UserProjection;
import br.senai.mima.projection.user.UserWithEstacoesProjection;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	boolean existsByEmail(String email);
	
	boolean existsByPhone(String phone);
	
	Optional<UserProjection> findUserByEmail(String email);
	
	Optional<UserProjection> findUserById(Long id);
	
	Optional<UserWithEstacoesProjection> findUserWithEstacoesById(Long id);
}
