package setrem.SistemaContabil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import setrem.SistemaContabil.model.Operacao;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Long>{
 
  //@Query("select c from Cliente c where upper(c.nomefantasia) like upper(?1)")
  @Query("select o from Operacao o where upper(o.TP_OPERACAO) like upper(?1)")
  public List<Operacao> findByTP_OPERACAOContaining(String operacao);

}
