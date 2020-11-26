package setrem.SistemaContabil.repository;

import java.util.List;

import setrem.SistemaContabil.model.ContasPagarReceber;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasPagarReceberRepository 
   extends JpaRepository<ContasPagarReceber, Integer> {
   


}
