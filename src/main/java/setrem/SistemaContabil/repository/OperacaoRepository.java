package setrem.SistemaContabil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import setrem.SistemaContabil.model.Operacao;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Long>{
  
}
