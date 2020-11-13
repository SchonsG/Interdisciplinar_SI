package setrem.SistemaContabil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import setrem.SistemaContabil.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{
  
}
