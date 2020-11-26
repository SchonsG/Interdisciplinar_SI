package setrem.SistemaContabil.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import setrem.SistemaContabil.model.Conta;
import setrem.SistemaContabil.model.Credito;
import setrem.SistemaContabil.model.Debito;
import setrem.SistemaContabil.model.Historico;
import setrem.SistemaContabil.model.Lancamento;
import setrem.SistemaContabil.repository.ContaRepository;
import setrem.SistemaContabil.repository.CreditoRepository;
import setrem.SistemaContabil.repository.DebitoRepository;
import setrem.SistemaContabil.repository.HistoricoRepository;
import setrem.SistemaContabil.repository.LancamentoRepository;

@Named(value = "lancamentoBean")
@SessionScoped
public class LancamentoBean {
  
  // Lançamento
  @Autowired
  private LancamentoRepository repositoryLancamento;
  private Lancamento lancamento = new Lancamento();
  private List<Lancamento> lancamentos = new ArrayList<>();
  private String lancamentoPesquisa = "";

  // Créditos
  @Autowired
  private CreditoRepository repositoryCredito;
  
  private Credito credito = new Credito();
  private List<Credito> creditos = new ArrayList<>();

  // Débitos
  @Autowired
  private DebitoRepository repositoryDebito;

  private Debito debito = new Debito();
  private List<Debito> debitos = new ArrayList<>();

  // Contas
  @Autowired
  private ContaRepository repositoryConta;
  private String contaPesquisa = "";
  private List<Conta> contas = new ArrayList<>();

  // Histórico
  @Autowired
  private HistoricoRepository repositoryHistorico;
  private Historico historicoSelecionado;


  // MÉTODOS

  // Lançamento
  public List<Historico> complete(String query) {
    List<Historico> historicos = repositoryHistorico.findByHISTORICOContaining(query);
    return historicos;
  }

  public LancamentoRepository getRepositoryLancamento() {
    return repositoryLancamento;
  }

  public String novo(){
    this.lancamento = new Lancamento();
    this.credito = new Credito();
    this.debito = new Debito();
    this.creditos.clear();
    this.debitos.clear();
    return "novo-lancamento-contabil.xhtml?faces-redirect=true&includeViewParams=true";
  }

  public void Pesquisar() {
    lancamentos = repositoryLancamento.findAll();
  }

  public String editar(Lancamento lanc) { 
    this.lancamento = lanc;
    this.creditos = lanc.getCREDITOS();
    this.debitos = lanc.getDEBITOS();
    return "editar-lancamento-contabil.xhtml?faces-redirect=true&includeViewParams=true";
  }
  
  public String save() {
  
    repositoryLancamento.save(lancamento);

    for (Credito cred : creditos) {
      cred.setLCTO_ID(lancamento);
      repositoryCredito.save(cred);
    }

    for (Debito deb: debitos) {
      deb.setLCTO_ID(lancamento);
      repositoryDebito.save(deb);
    }

    this.lancamento = new Lancamento();
    this.credito = new Credito();
    this.debito = new Debito();
    this.creditos.clear();
    this.debitos.clear();

    return "lancamento-contabil.xhtml?faces-redirect=true&includeViewParams=true";
  }

  public void deletar(Lancamento lanc) {

    List<Credito> credDeletar = lanc.getCREDITOS();
    List<Debito> debDeletar = lanc.getDEBITOS();

    for (Credito cred : credDeletar) {
      repositoryCredito.delete(cred);
    }

    for (Debito deb : debDeletar) {
      repositoryDebito.delete(deb);
    }

    repositoryLancamento.delete(lanc);

  }

  public void setRepositoryLancamento(LancamentoRepository repositoryLancamento) {
    this.repositoryLancamento = repositoryLancamento;
  }

  public Lancamento getLancamento() {
    return lancamento;
  }

  public void setLancamento(Lancamento lancamento) {
    this.lancamento = lancamento;
  }

  public List<Lancamento> getLancamentos() {
    return lancamentos = repositoryLancamento.findAll();
  }

  public void setLancamentos(List<Lancamento> lancamentos) {
    this.lancamentos = lancamentos;
  }

  public String getLancamentoPesquisa() {
    return lancamentoPesquisa;
  }

  public void setLancamentoPesquisa(String lancamentoPesquisa) {
    this.lancamentoPesquisa = lancamentoPesquisa;
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

  public String getContaPesquisa() {
    return contaPesquisa;
  }

  public void setContaPesquisa(String contaPesquisa) {
    this.contaPesquisa = contaPesquisa;
  }


  // Crédito
  public void selecionarContaCredito(Conta conta){
    Conta contaCred = repositoryConta.findById(conta.getCONTA_ID()).get();
    this.credito.setCONTA_ID(contaCred);
  }

  public CreditoRepository getRepositoryCredito() {
    return repositoryCredito;
  }

  public void setRepositoryCredito(CreditoRepository repositoryCredito) {
    this.repositoryCredito = repositoryCredito;
  }

  public List<Credito> getCreditos() {
    return creditos;
  }

  public void setCreditos(List<Credito> creditos) {
    this.creditos = creditos;
  }

  public Credito getCredito() {
    return credito;
  }

  public void setCredito(Credito credito) {
    this.credito = credito;
  }

  public void adicionarCredito() {
    this.creditos.add(this.credito);
    this.credito = new Credito();
  }

  public void cancelarCredito() {
    this.credito = new Credito();
  }

  // Débito
  public void selecionarContaDebito(Conta conta){
    Conta contaDeb = repositoryConta.findById(conta.getCONTA_ID()).get();
    this.debito.setCONTA_ID(contaDeb);
  }

  public void adicionarDebito() {
    this.debitos.add(this.debito);
    this.debito = new Debito();
  }

  public DebitoRepository getRepositoryDebito() {
    return repositoryDebito;
  }

  public void setRepositoryDebito(DebitoRepository repositoryDebito) {
    this.repositoryDebito = repositoryDebito;
  }

  public List<Debito> getDebitos() {
    return debitos;
  }

  public void setDebitos(List<Debito> debitos) {
    this.debitos = debitos;
  }

  public Debito getDebito() {
    return debito;
  }

  public void setDebito(Debito debito) {
    this.debito = debito;
  }

  public void cancelarDebito() {
    this.debito = new Debito();
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

}
