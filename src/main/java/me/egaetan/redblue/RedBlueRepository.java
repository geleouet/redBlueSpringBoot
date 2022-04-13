package me.egaetan.redblue;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

public interface RedBlueRepository extends JpaRepository<RedBlueEntity, String>{

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<RedBlueEntity> findById(String id);
}
