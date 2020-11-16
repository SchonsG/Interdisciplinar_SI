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

  

}
