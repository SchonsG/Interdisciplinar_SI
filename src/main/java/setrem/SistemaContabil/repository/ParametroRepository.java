package setrem.SistemaContabil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import setrem.SistemaContabil.model.Parametro;

@Repository
public interface ParametroRepository extends JpaRepository<Parametro, Long>{
  
}
