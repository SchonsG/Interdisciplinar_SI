package setrem.SistemaContabil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import setrem.SistemaContabil.model.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{
  
  // public List<Lancamento> findByHISTORICOContaining(String historico); Ver com o professor isso

}
