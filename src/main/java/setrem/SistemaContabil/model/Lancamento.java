package setrem.SistemaContabil.model;

import java.time.LocalDate;
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
@Table(name = "LCTO_CONTABIL")
public class Lancamento {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long LCTO_ID;

  @ManyToOne()
  @JoinColumn(name = "HISTORICO_ID")
  private Historico HISTORICO_ID;

  private LocalDate DATA;

  private String COMPLEMENTO;

  @OneToMany(mappedBy = "LCTO_ID")
  private List<Credito> CREDITOS;

  @OneToMany(mappedBy = "LCTO_ID")
  private List<Debito> DEBITOS;

  public long getLCTO_ID() {
    return LCTO_ID;
  }

  public void setLCTO_ID(long lCTO_ID) {
    LCTO_ID = lCTO_ID;
  }

  public LocalDate getDATA() {
    return DATA;
  }

  public void setDATA(LocalDate dATA) {
    DATA = dATA;
  }

  public String getCOMPLEMENTO() {
    return COMPLEMENTO;
  }

  public void setCOMPLEMENTO(String cOMPLEMENTO) {
    COMPLEMENTO = cOMPLEMENTO;
  }

public List<Credito> getCREDITOS() {
	return CREDITOS;
}

public void setCREDITOS(List<Credito> cREDITOS) {
	CREDITOS = cREDITOS;
}

public List<Debito> getDEBITOS() {
	return DEBITOS;
}

public void setDEBITOS(List<Debito> dEBITOS) {
	DEBITOS = dEBITOS;
}

public Historico getHISTORICO_ID() {
	return HISTORICO_ID;
}

public void setHISTORICO_ID(Historico hISTORICO_ID) {
	HISTORICO_ID = hISTORICO_ID;
}
}
