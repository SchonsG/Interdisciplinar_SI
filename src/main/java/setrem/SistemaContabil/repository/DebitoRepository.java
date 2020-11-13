package setrem.SistemaContabil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import setrem.SistemaContabil.model.Debito;

@Repository
public interface DebitoRepository extends JpaRepository<Debito, Long>{
  
}
