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
      historicos = repositoryHistorico.findByHISTORICOContaining(this.historicoPesquisa);
    }
    return historicos;
  }

  public String novo(){
    this.historico = new Historico();
    return "novo-historico-contabil.xhtml?faces-redirect=true&includeViewParams=true";
  }

  public void Pesquisar() {
    historicos = repositoryHistorico.findByHISTORICOContaining(this.historicoPesquisa);
  }

  public String editar(Historico hist) { 
    this.historico = hist;
    return "editar-historico-contabil.xhtml?faces-redirect=true&includeViewParams=true";
  }
  
  public void deletar(Historico hist) {
    repositoryHistorico.delete(hist);
  }

  public String save() {
    repositoryHistorico.save(historico);
    this.historico = new Historico();
    return "historico-contabil.xhtml?faces-redirect=true&includeViewParams=true";
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
