package setrem.SistemaContabil.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import setrem.SistemaContabil.model.ClienteFornecedor;
import setrem.SistemaContabil.repository.ClienteFornecedorRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Named(value = "cadcli")
@SessionScoped
public class CadastroClientesFornecedoresBean {
   
   @Autowired
   private ClienteFornecedorRepository repository;

   private ClienteFornecedor cliente = new ClienteFornecedor();
   private List<ClienteFornecedor> clientes = new ArrayList<>();

   public void save() {
      repository.save(cliente);
      this.cliente = new ClienteFornecedor();
   }

   public void select(ClienteFornecedor cli) {
      this.cliente = cli;
   }

   public void delete(ClienteFornecedor cli) {
      repository.delete(cli);
   }

   public ClienteFornecedor getCliente() {
      return cliente;
   }

   public void setCliente(ClienteFornecedor cliente) {
      this.cliente = cliente;
   }

   public List<ClienteFornecedor> getClientes() {
      clientes = repository.findAll();
      return clientes;
   }

   public void setClientes(List<ClienteFornecedor> clientes) {
      this.clientes = clientes;
   }

   

}
