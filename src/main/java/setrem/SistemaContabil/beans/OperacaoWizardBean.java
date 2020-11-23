package setrem.SistemaContabil.beans;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;

import setrem.SistemaContabil.model.Operacao;
import setrem.SistemaContabil.model.Parametro;
import setrem.SistemaContabil.repository.OperacaoRepository;

@Named(value = "operacaoWizardBean")
@SessionScoped
public class OperacaoWizardBean {
  
  @Autowired
  private OperacaoRepository repositoryOperacao;

  private Operacao operacao = new Operacao();

  private Parametro parametro = new Parametro();

  private List<Parametro> parametros;

  private boolean skip;
  
  public void save() {        
      FacesMessage msg = new FacesMessage("Operação salva!");
      FacesContext.getCurrentInstance().addMessage(null, msg);
  }
   
  public boolean isSkip() {
      return skip;
  }

  public void setSkip(boolean skip) {
      this.skip = skip;
  }
   
  public String onFlowProcess(FlowEvent event) {
      if(skip) {
          skip = false;   //reset in case user goes back
          return "confirm";
      }
      else {
          return event.getNewStep();
      }
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

}
