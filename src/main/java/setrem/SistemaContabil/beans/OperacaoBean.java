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
  private Operacao operacao = new Operacao();
  private List<Operacao> operacoes = new ArrayList<>();
  private String operacaoPesquisa = "";

  // Parâmetros
  @Autowired
  private ParametroRepository repositoryParametro;
  private Parametro parametro = new Parametro();
  private List<Parametro> parametros = new ArrayList<>();

  // Conta
  @Autowired
  private ContaRepository repositoryConta;
  private List<Conta> contas = new ArrayList<>();
  private Conta conta = new Conta();
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

  // MÉTODOS

  // Operação
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
    repositoryParametro.deleteAll(oper.getPARAMETROS());
    repositoryOperacao.delete(oper);
  }

  public String editar(Operacao oper) {
    this.operacao = oper;
    this.parametros.addAll(oper.getPARAMETROS());
    return "editar-operacao.xhtml?faces-redirect=true&includeViewParams=true";
  }

  public String novo() {
    this.parametros.clear();
    this.operacao = new Operacao();
    return "nova-operacao.xhtml?faces-redirect=true&includeViewParams=true";
  }

  public void Pesquisar() {
 //   operacoes = repositoryOperacao.findByTP_OPERACAOContaining(this.operacaoPesquisa);
  }

  public String salvar() {
    
    repositoryOperacao.save(operacao);

    for (Parametro parm : parametros) {
      parm.setTP_OPERACAO_ID(operacao);
      repositoryParametro.save(parm);
    }

    this.operacao = new Operacao();
    this.parametro = new Parametro();
    this.parametros.clear();

    return "operacao-parametrizada.xhtml?faces-redirect=true&includeViewParams=true";
  }


  // Parametro
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

  public void excluirParametro(Parametro parm) {
    this.parametros.remove(parm);
  }


  // Histórico
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

  // Conta
  public void PesquisarConta() {
    this.contas = repositoryConta.findByCONTAContaining(this.contaPesquisa);
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
    System.out.println(this.parametro.getTIPO());
    this.parametros.add(this.parametro);
    this.parametro = new Parametro();
  }

  public void cancelarConta() {
    this.parametro = new Parametro();
  }

}
