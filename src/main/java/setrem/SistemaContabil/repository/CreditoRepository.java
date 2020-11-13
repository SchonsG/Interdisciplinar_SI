package setrem.SistemaContabil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import setrem.SistemaContabil.model.Credito;

@Repository
public interface CreditoRepository extends JpaRepository<Credito, Long>{
  
}
