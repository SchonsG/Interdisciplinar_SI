package setrem.SistemaContabil.repository;

import java.util.List;

import setrem.SistemaContabil.model.ClienteFornecedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteFornecedorRepository 
   extends JpaRepository<ClienteFornecedor, Integer> {
   
 
}
