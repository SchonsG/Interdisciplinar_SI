package setrem.SistemaContabil.beans;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import setrem.SistemaContabil.model.Operacao;
import setrem.SistemaContabil.repository.OperacaoRepository;

@Named(value = "operacaoBean")
@SessionScoped
public class OperacaoBean {
  
  @Autowired
  private OperacaoRepository repositoryOperacao;
  private Operacao operacao;
  private List<Operacao> operacoes;
  private String operacaoPesquisa = "";

  public OperacaoRepository getRepositoryOperacao() {
    return repositoryOperacao;
  }

  public void setRepositoryOperacao(OperacaoRepository repositoryOperacao) {
    this.repositoryOperacao = repositoryOperacao;
  }

  public Operacao getOperacao() {
    return operacao;
  }

  public void setOperacao(Operacao operacao) {
    this.operacao = operacao;
  }

  public List<Operacao> getOperacoes() {
    if (this.operacaoPesquisa.isEmpty()) {
      operacoes = repositoryOperacao.findAll();
    } else {
     // operacoes = repositoryOperacao.findByTP_OPERACAOContaining(this.operacaoPesquisa);
    }
    return operacoes;
  }

  public void setOperacoes(List<Operacao> operacoes) {
    this.operacoes = operacoes;
  }

  public String getOperacaoPesquisa() {
    return operacaoPesquisa;
  }

  public void setOperacaoPesquisa(String operacaoPesquisa) {
    this.operacaoPesquisa = operacaoPesquisa;
  }

  public void deletar(Operacao oper) {
    repositoryOperacao.delete(oper);
  }

  public String editar(Operacao oper) {
    this.operacao = oper;
    return "operacao-parametrizada.xhtml?faces-redirect=true&includeViewParams=true";
  }

  public String novo() {
    this.operacao = new Operacao();
    return "novo-parametro-lancamento.xhtml?faces-redirect=true&includeViewParams=true";
  }

  public void Pesquisar() {
 //   operacoes = repositoryOperacao.findByTP_OPERACAOContaining(this.operacaoPesquisa);
  }

}
