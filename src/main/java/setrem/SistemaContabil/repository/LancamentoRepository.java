package setrem.SistemaContabil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import setrem.SistemaContabil.model.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

  //@Query("select c from Cliente c where upper(c.nomefantasia) like upper(?1)")

/*   @Query(
    "select l from Lancamento l inner join Historico h on l.HISTORICO_ID = h.HISTORICO_ID where h.HISTORICO like ?1"
  )
  public List<Lancamento> findPersonalizado(String historico); */


/*   @Query(
    value = "select l, h.historico from Lancamento l inner join l.historico h"
  )
  public List<Lancamento> findPersonalizado(@Param("histParm") String histParm); */
  
  /* select * from LCTO_CONTABIL
  inner join historico on historico.historico_id = lcto_contabil.historico_id 
  where historico like '%%' */

}
