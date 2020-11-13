package setrem.SistemaContabil.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "HISTORICO")
public class Historico {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long HISTORICO_ID;

  private String HISTORICO;

  @OneToMany(mappedBy = "HISTORICO_ID")
  private List<Operacao> OPERACOES;

  @OneToMany(mappedBy = "HISTORICO_ID")
  private List<Lancamento> LANCAMENTOS; 

  public long getHISTORICO_ID() {
    return HISTORICO_ID;
  }

  public void setHISTORICO_ID(long hISTORICO_ID) {
    HISTORICO_ID = hISTORICO_ID;
  }

  public String getHISTORICO() {
    return HISTORICO;
  }

  public void setHISTORICO(String hISTORICO) {
    HISTORICO = hISTORICO;
  }

  public List<Lancamento> getLANCAMENTOS() {
    return LANCAMENTOS;
  }

  public void setLANCAMENTOS(List<Lancamento> lANCAMENTOS) {
    LANCAMENTOS = lANCAMENTOS;
  }

  public List<Operacao> getOPERACOES() {
    return OPERACOES;
  }

  public void setOPERACOES(List<Operacao> oPERACOES) {
    OPERACOES = oPERACOES;
  }


}