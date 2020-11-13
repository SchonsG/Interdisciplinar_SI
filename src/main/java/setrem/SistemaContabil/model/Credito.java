package setrem.SistemaContabil.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LCTO_CREDITO")
public class Credito {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long LCTO_CRED_ID;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "LCTO_ID")
  private Lancamento LCTO_ID;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "CONTA_ID")
  private Conta CONTA_ID;

  private BigDecimal VALOR;

  public long getLCTO_CRED_ID() {
    return LCTO_CRED_ID;
  }

  public void setLCTO_CRED_ID(long lCTO_CRED_ID) {
    LCTO_CRED_ID = lCTO_CRED_ID;
  }

  public Lancamento getLCTO_ID() {
    return LCTO_ID;
  }

  public void setLCTO_ID(Lancamento lCTO_ID) {
    LCTO_ID = lCTO_ID;
  }

  public Conta getCONTA_ID() {
    return CONTA_ID;
  }

  public void setCONTA_ID(Conta cONTA_ID) {
    CONTA_ID = cONTA_ID;
  }

  public BigDecimal getVALOR() {
    return VALOR;
  }

  public void setVALOR(BigDecimal vALOR) {
    VALOR = vALOR;
  }

    

}
