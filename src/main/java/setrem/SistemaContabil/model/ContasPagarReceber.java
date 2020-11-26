package setrem.SistemaContabil.model;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "contaspagarreceber")
public class ContasPagarReceber{
@Id
private Integer id;
private String tipoOperacao;
private Integer cod_clienteFornecedor;
private String nome_clienteFornecedor;
private Integer cod_contaDeb;
private Integer cod_contaCred;
private String numDocumento;
private Date dataLancamento;
private Date dataVencimento;
private Date dataPagamento;
private String formaPagamento;
private Integer numParcelas;
private Integer valorDocumento;
private Integer cod_tipoDocumento;
private Integer cod_Historico;

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getTipoOperacao() {
    return tipoOperacao;
}

public void setTipoOperacao(String tipoOperacao) {
    this.tipoOperacao = tipoOperacao;
}

public Integer getCod_clienteFornecedor() {
    return cod_clienteFornecedor;
}

public void setCod_clienteFornecedor(Integer cod_clienteFornecedor) {
    this.cod_clienteFornecedor = cod_clienteFornecedor;
}

public String getNome_clienteFornecedor() {
    return nome_clienteFornecedor;
}

public void setNome_clienteFornecedor(String nome_clienteFornecedor) {
    this.nome_clienteFornecedor = nome_clienteFornecedor;
}

public Integer getCod_contaDeb() {
    return cod_contaDeb;
}

public void setCod_contaDeb(Integer cod_contaDeb) {
    this.cod_contaDeb = cod_contaDeb;
}

public Integer getCod_contaCred() {
    return cod_contaCred;
}

public void setCod_contaCred(Integer cod_contaCred) {
    this.cod_contaCred = cod_contaCred;
}

public String getNumDocumento() {
    return numDocumento;
}

public void setNumDocumento(String numDocumento) {
    this.numDocumento = numDocumento;
}

public Date getDataLancamento() {
    return dataLancamento;
}

public void setDataLancamento(Date dataLancamento) {
    this.dataLancamento = dataLancamento;
}

public Date getDataVencimento() {
    return dataVencimento;
}

public void setDataVencimento(Date dataVencimento) {
    this.dataVencimento = dataVencimento;
}

public Date getDataPagamento() {
    return dataPagamento;
}

public void setDataPagamento(Date dataPagamento) {
    this.dataPagamento = dataPagamento;
}

public String getFormaPagamento() {
    return formaPagamento;
}

public void setFormaPagamento(String formaPagamento) {
    this.formaPagamento = formaPagamento;
}

public Integer getNumParcelas() {
    return numParcelas;
}

public void setNumParcelas(Integer numParcelas) {
    this.numParcelas = numParcelas;
}

public Integer getValorDocumento() {
    return valorDocumento;
}

public void setValorDocumento(Integer valorDocumento) {
    this.valorDocumento = valorDocumento;
}

public Integer getCod_tipoDocumento() {
    return cod_tipoDocumento;
}

public void setCod_tipoDocumento(Integer cod_tipoDocumento) {
    this.cod_tipoDocumento = cod_tipoDocumento;
}

public Integer getCod_Historico() {
    return cod_Historico;
}

public void setCod_Historico(Integer cod_Historico) {
    this.cod_Historico = cod_Historico;
}

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((cod_Historico == null) ? 0 : cod_Historico.hashCode());
    result = prime * result + ((cod_clienteFornecedor == null) ? 0 : cod_clienteFornecedor.hashCode());
    result = prime * result + ((cod_contaCred == null) ? 0 : cod_contaCred.hashCode());
    result = prime * result + ((cod_contaDeb == null) ? 0 : cod_contaDeb.hashCode());
    result = prime * result + ((cod_tipoDocumento == null) ? 0 : cod_tipoDocumento.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((numParcelas == null) ? 0 : numParcelas.hashCode());
    result = prime * result + ((valorDocumento == null) ? 0 : valorDocumento.hashCode());
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
    ContasPagarReceber other = (ContasPagarReceber) obj;
    if (cod_Historico == null) {
        if (other.cod_Historico != null)
            return false;
    } else if (!cod_Historico.equals(other.cod_Historico))
        return false;
    if (cod_clienteFornecedor == null) {
        if (other.cod_clienteFornecedor != null)
            return false;
    } else if (!cod_clienteFornecedor.equals(other.cod_clienteFornecedor))
        return false;
    if (cod_contaCred == null) {
        if (other.cod_contaCred != null)
            return false;
    } else if (!cod_contaCred.equals(other.cod_contaCred))
        return false;
    if (cod_contaDeb == null) {
        if (other.cod_contaDeb != null)
            return false;
    } else if (!cod_contaDeb.equals(other.cod_contaDeb))
        return false;
    if (cod_tipoDocumento == null) {
        if (other.cod_tipoDocumento != null)
            return false;
    } else if (!cod_tipoDocumento.equals(other.cod_tipoDocumento))
        return false;
    if (id == null) {
        if (other.id != null)
            return false;
    } else if (!id.equals(other.id))
        return false;
    if (numParcelas == null) {
        if (other.numParcelas != null)
            return false;
    } else if (!numParcelas.equals(other.numParcelas))
        return false;
    if (valorDocumento == null) {
        if (other.valorDocumento != null)
            return false;
    } else if (!valorDocumento.equals(other.valorDocumento))
        return false;
    return true;
}
}