package setrem.SistemaContabil.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PARAMETRO")
public class Parametro {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long PARAM_ID;

  private String TIPO;

  @ManyToOne()
  @JoinColumn(name = "CONTA_ID")
  private Conta CONTA_ID;

  @ManyToOne()
  @JoinColumn(name = "TP_OPERACAO_ID")
  private Operacao TP_OPERACAO_ID;

  public long getPARAM_ID() {
    return PARAM_ID;
  }

  public void setPARAM_ID(long pARAM_ID) {
    PARAM_ID = pARAM_ID;
  }

  public Conta getCONTA_ID() {
    return CONTA_ID;
  }

  public void setCONTA_ID(Conta cONTA_ID) {
    CONTA_ID = cONTA_ID;
  }

  public Operacao getTP_OPERACAO_ID() {
    return TP_OPERACAO_ID;
  }

  public void setTP_OPERACAO_ID(Operacao tP_OPERACAO_ID) {
    TP_OPERACAO_ID = tP_OPERACAO_ID;
  }

  public String getTIPO() {
    return TIPO;
  }

  public void setTIPO(String tIPO) {
    TIPO = tIPO;
  }

}
