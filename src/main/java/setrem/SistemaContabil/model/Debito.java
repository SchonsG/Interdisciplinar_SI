package setrem.SistemaContabil.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LCTO_DEBITO")
public class Debito {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long LCTO_DEB_ID;

  @ManyToOne()
  @JoinColumn(name = "LCTO_ID")
  private Lancamento LCTO_ID;

  @ManyToOne()
  @JoinColumn(name = "CONTA_ID")
  private Conta CONTA_ID;

  private Integer VALOR;

  public long getLCTO_DEB_ID() {
    return LCTO_DEB_ID;
  }

  public void setLCTO_DEB_ID(long lCTO_DEB_ID) {
    LCTO_DEB_ID = lCTO_DEB_ID;
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

  public Integer getVALOR() {
    return VALOR;
  }

  public void setVALOR(Integer vALOR) {
    VALOR = vALOR;
  }

  }
