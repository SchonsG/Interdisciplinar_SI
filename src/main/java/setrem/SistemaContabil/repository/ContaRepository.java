package setrem.SistemaContabil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import setrem.SistemaContabil.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer>{
 
  @Query("select c from Conta c where upper(c.CONTA) like upper(?1)")
  public List<Conta> contaPesquisa(String conta);

}
