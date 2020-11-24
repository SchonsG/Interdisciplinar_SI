package setrem.SistemaContabil.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import setrem.SistemaContabil.model.Conta;
import setrem.SistemaContabil.model.Historico;
import setrem.SistemaContabil.model.Operacao;
import setrem.SistemaContabil.model.Parametro;
import setrem.SistemaContabil.repository.ContaRepository;
import setrem.SistemaContabil.repository.HistoricoRepository;
import setrem.SistemaContabil.repository.OperacaoRepository;
import setrem.SistemaContabil.repository.ParametroRepository;

@Named(value = "operacaoBean")
@SessionScoped
public class OperacaoBean {
  
  // Operação
  @Autowired
  private OperacaoRepository repositoryOperacao;
  private Operacao operacao;
  private List<Operacao> operacoes = new ArrayList<>();
  private String operacaoPesquisa = "";

  // Parâmetros
  @Autowired
  private ParametroRepository repositoryParametro;
  private Parametro parametro;
  private List<Parametro> parametros = new ArrayList<>();

  // Conta
  @Autowired
  private ContaRepository repositoryConta;
  private List<Conta> contas = new ArrayList<>();
  private Conta conta;
  private String contaPesquisa = "";

  // Histórico
  @Autowired
  private HistoricoRepository repositoryHistorico;
  private Historico historicoSelecionado;

  // Lançamento
  public List<Historico> complete(String query) {
    List<Historico> historicos = repositoryHistorico.findByHISTORICOContaining(query);
    return historicos;
  }

  public void PesquisarConta() {
    this.contas = repositoryConta.findByCONTAContaining(this.contaPesquisa);
  }

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
    return "nova-operacao-lancamento.xhtml?faces-redirect=true&includeViewParams=true";
  }

  public void Pesquisar() {
 //   operacoes = repositoryOperacao.findByTP_OPERACAOContaining(this.operacaoPesquisa);
  }

  public ParametroRepository getRepositoryParametro() {
    return repositoryParametro;
  }

  public void setRepositoryParametro(ParametroRepository repositoryParametro) {
    this.repositoryParametro = repositoryParametro;
  }

  public Parametro getParametro() {
    return parametro;
  }

  public void setParametro(Parametro parametro) {
    this.parametro = parametro;
  }

  public List<Parametro> getParametros() {
    return parametros;
  }

  public void setParametros(List<Parametro> parametros) {
    this.parametros = parametros;
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

  public List<Conta> getContas() {
    if (this.contaPesquisa.isEmpty()) {
      contas = repositoryConta.findAll();
    } else {
      contas = repositoryConta.findByCONTAContaining(this.contaPesquisa);
    }

    return contas;
  }

  public void setContas(List<Conta> contas) {
    this.contas = contas;
  }

  public void selecionarConta(Conta conta){
    this.parametro.setCONTA_ID(conta);
  }

  public void adicionarConta() {
    this.parametros.add(this.parametro);
    this.parametro = new Parametro();
  }

  public void cancelarConta() {
    this.parametro = new Parametro();
  }

  public HistoricoRepository getRepositoryHistorico() {
    return repositoryHistorico;
  }

  public void setRepositoryHistorico(HistoricoRepository repositoryHistorico) {
    this.repositoryHistorico = repositoryHistorico;
  }

  public Historico getHistoricoSelecionado() {
    return historicoSelecionado;
  }

  public void setHistoricoSelecionado(Historico historicoSelecionado) {
    this.historicoSelecionado = historicoSelecionado;
  }

}
