package setrem.SistemaContabil.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import setrem.SistemaContabil.model.Conta;
import setrem.SistemaContabil.repository.ContaRepository;

@Named(value = "contaBean")
@SessionScoped
public class ContaBean {
  
  @Autowired
  private ContaRepository repositoryConta;

  private Conta conta;

  private List<Conta> contas = new ArrayList<>();

  private String contaPesquisa = "";

  public void Pesquisar() {
     this.contas = repositoryConta.findByCONTAContaining(this.contaPesquisa);
  }
  
  public List<Conta> getContas() {

    if (this.contaPesquisa.isEmpty()) {
      contas = repositoryConta.findAll();
    } else {
      contas = repositoryConta.findByCONTAContaining(this.contaPesquisa);
    }

    return contas;
  }

  public String save() {
    repositoryConta.save(conta);
    this.conta = new Conta();
    return "plano-contas.xhtml?faces-redirect=true&includeViewParams=true";
  }

  public String editar(Conta conta) { 
    this.conta = conta;
    return "editar-conta.xhtml?faces-redirect=true&includeViewParams=true";
  }
  
  public void deletar(Conta conta) {
    repositoryConta.delete(conta);
  }

  public void setContas(List<Conta> contas) {
    this.contas = contas;
  }

  public ContaRepository getRepositoryConta() {
    return repositoryConta;
  }

  public void setRepositoryConta(ContaRepository repositoryConta) {
    this.repositoryConta = repositoryConta;
  }

  public Conta getConta() {
    return conta;
  }

  public void setConta(Conta conta) {
    this.conta = conta;
  }

  public String getContaPesquisa() {
    return contaPesquisa;
  }

  public void setContaPesquisa(String contaPesquisa) {
    this.contaPesquisa = contaPesquisa;
  }

}
