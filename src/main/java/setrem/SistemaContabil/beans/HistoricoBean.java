package setrem.SistemaContabil.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import setrem.SistemaContabil.model.Historico;
import setrem.SistemaContabil.repository.HistoricoRepository;

@Named(value = "historicoBean")
@SessionScoped
public class HistoricoBean {

  @Autowired
  private HistoricoRepository repositoryHistorico;

  private Historico historico = new Historico();
  private List<Historico> historicos = new ArrayList<>();
  private String historicoPesquisa = "";

  public List<Historico> getHistoricos() {
    if (this.historicoPesquisa.isEmpty()) {
      historicos = repositoryHistorico.findAll();
    } else {
      historicos = repositoryHistorico.historicoPesquisa(this.historicoPesquisa);
    }
    return historicos;
  }

  public void Pesquisar() {
    historicos = repositoryHistorico.historicoPesquisa(this.historicoPesquisa);
  }

  /*
   * public String editHistorico(Historico hist) { this.historico = hist; return
   * "...pagedit"; }
   */

  public void delete(Historico hist) {
    repositoryHistorico.delete(hist);
  }

  public String save() {
    repositoryHistorico.save(historico);
    this.historico = new Historico();
    return "historico-contabil";
  }

  public String cancelar() {
    return "historico-contabil";
  }

  public void setHistorico(Historico historico) {
    this.historico = historico;
  }

  public Historico getHistorico() {
    return historico;
  }

  public void setHistoricos(List<Historico> historicos) {
    this.historicos = historicos;
  }

  public String getHistoricoPesquisa() {
    return historicoPesquisa;
  }

  public void setHistoricoPesquisa(String historicoPesquisa) {
    this.historicoPesquisa = historicoPesquisa;
  }

  public HistoricoRepository getRepositoryHistorico() {
    return repositoryHistorico;
  }

  public void setRepositoryHistorico(HistoricoRepository repositoryHistorico) {
    this.repositoryHistorico = repositoryHistorico;
  }

}
