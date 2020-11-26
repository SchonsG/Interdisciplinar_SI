package setrem.SistemaContabil.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import setrem.SistemaContabil.model.ContasPagarReceber;
import setrem.SistemaContabil.repository.ContasPagarReceberRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Named(value = "lanctitulos")
@SessionScoped
public class LancamentosPagarReceberBean {
   
   @Autowired
   private ContasPagarReceberRepository repository;

   private ContasPagarReceber conta = new ContasPagarReceber(); 
   private List<ContasPagarReceber> contas = new ArrayList<>();

   public void save() {
      repository.save(conta);
      this.conta = new ContasPagarReceber();
   }

   public void select(ContasPagarReceber conta) {
      this.conta = conta;
   }

   public void delete(ContasPagarReceber conta) {
      repository.delete(conta);
   }

   public ContasPagarReceber getConta() {
      return conta;
   }

   public void setConta(ContasPagarReceber conta) {
      this.conta = conta;
   }

   public List<ContasPagarReceber> getContas() {
      contas = repository.findAll();
      return contas;
   }

   public void setContas(List<ContasPagarReceber> contas) {
      this.contas = contas;
   }
}
