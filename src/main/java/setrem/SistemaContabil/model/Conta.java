package setrem.SistemaContabil.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CONTA")
public class Conta {
 
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer CONTA_ID;

  private String CONTA_PLANO;

  private String CONTA;

  private long CONTA_SUP;

  private String PATRIMONIO_RESULT;

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

  public long getCONTA_SUP() {
    return CONTA_SUP;
  }

  public void setCONTA_SUP(long cONT_SUP) {
    CONTA_SUP = cONT_SUP;
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

@Override
public int hashCode() {
  final int prime = 31;
  int result = 1;
  result = prime * result + ((CONTA_ID == null) ? 0 : CONTA_ID.hashCode());
  return result;
}

@Override
public boolean equals(Object obj) {
  if (this == obj)
    return true;
  if (obj == null)
    return false;
  if (getClass() != obj.getClass())
    return false;
  Conta other = (Conta) obj;
  if (CONTA_ID == null) {
    if (other.CONTA_ID != null)
      return false;
  } else if (!CONTA_ID.equals(other.CONTA_ID))
    return false;
  return true;
}

}
