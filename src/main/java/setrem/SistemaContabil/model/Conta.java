package setrem.SistemaContabil.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import setrem.SistemaContabil.converters.AtivoPassivoConverter;
import setrem.SistemaContabil.converters.PatrimonialResultadoConverter;

@Entity
@Table(name = "CONTA")
public class Conta {
 
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer CONTA_ID;

  private String CONTA_PLANO;

  private String CONTA;

  @ManyToOne(cascade = {CascadeType.ALL})
  @JoinColumn(name = "CONTA_SUP", referencedColumnName = "CONTA_ID")
  private Conta CONTA_SUP;

  @Convert(converter = PatrimonialResultadoConverter.class)
  private String PATRIMONIO_RESULT;

  @Convert(converter = AtivoPassivoConverter.class)
  private String ATIVO_PASSIVO;

  @OneToMany(mappedBy = "CONTA_ID")
  private List<Parametro> PARAMETROS;

  @OneToMany(mappedBy = "CONTA_ID")
  private List<Credito> DEBITOS;

  @OneToMany(mappedBy = "CONTA_ID")
  private List<Debito> CREDITOS;

  public Integer getCONTA_ID() {
    return CONTA_ID;
  }

  public void setCONTA_ID(Integer cONTA_ID) {
    CONTA_ID = cONTA_ID;
  }

  public String getCONTA_PLANO() {
    return CONTA_PLANO;
  }

  public void setCONTA_PLANO(String cONTA_PLANO) {
    CONTA_PLANO = cONTA_PLANO;
  }

  public String getCONTA() {
    return CONTA;
  }

  public void setCONTA(String cONTA) {
    CONTA = cONTA;
  }

  public String getPATRIMONIO_RESULT() {
    return PATRIMONIO_RESULT;
  }

  public void setPATRIMONIO_RESULT(String pATRIMONIO_RESULT) {
    PATRIMONIO_RESULT = pATRIMONIO_RESULT;
  }

  public String getATIVO_PASSIVO() {
    return ATIVO_PASSIVO;
  }

  public void setATIVO_PASSIVO(String aTIVO_PASSIVO) {
    ATIVO_PASSIVO = aTIVO_PASSIVO;
  }

public List<Parametro> getPARAMETROS() {
	return PARAMETROS;
}

public void setPARAMETROS(List<Parametro> pARAMETROS) {
	PARAMETROS = pARAMETROS;
}

public List<Credito> getDEBITOS() {
	return DEBITOS;
}

public void setDEBITOS(List<Credito> dEBITOS) {
	DEBITOS = dEBITOS;
}

public List<Debito> getCREDITOS() {
	return CREDITOS;
}

public void setCREDITOS(List<Debito> cREDITOS) {
	CREDITOS = cREDITOS;
}

public Conta getCONTA_SUP() {
  return CONTA_SUP;
}

public void setCONTA_SUP(Conta cONTA_SUP) {
  CONTA_SUP = cONTA_SUP;
}

}
