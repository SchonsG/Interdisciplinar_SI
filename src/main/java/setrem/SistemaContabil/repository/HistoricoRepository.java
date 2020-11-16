package setrem.SistemaContabil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import setrem.SistemaContabil.model.Historico;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Long>{
  
/*   @Query("select c from Historico c where upper(c.HISTORICO) like upper(?1)")
  public List<Historico> historicoPesquisa(String historico); */

  public List<Historico> findByHISTORICOContaining(String historico);

}
