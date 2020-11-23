package setrem.SistemaContabil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import setrem.SistemaContabil.model.Operacao;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Long>{
 
 
//  public List<Operacao> findByTP_OPERACAOContaining(String historico);

}
