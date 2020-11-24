package setrem.SistemaContabil.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TP_OPERACAO")
public class Operacao {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long TP_OPERACAO_ID;

  private String TP_OPERACAO;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "HISTORICO_ID")
  private Historico HISTORICO_ID;

  @OneToMany(mappedBy = "TP_OPERACAO_ID")
  private List<Parametro> PARAMETROS;

  public long getTP_OPERACAO_ID() {
    return TP_OPERACAO_ID;
  }

  public void setTP_OPERACAO_ID(long tP_OPERACAO_ID) {
    TP_OPERACAO_ID = tP_OPERACAO_ID;
  }

  public String getTP_OPERACAO() {
    return TP_OPERACAO;
  }

  public void setTP_OPERACAO(String tP_OPERACAO) {
    TP_OPERACAO = tP_OPERACAO;
  }

  public List<Parametro> getPARAMETROS() {
    return PARAMETROS;
  }

  public void setPARAMETROS(List<Parametro> pARAMETROS) {
    PARAMETROS = pARAMETROS;
  }

  public Historico getHISTORICO_ID() {
    return HISTORICO_ID;
  }

  public void setHISTORICO_ID(Historico hISTORICO_ID) {
    HISTORICO_ID = hISTORICO_ID;
  }

}
