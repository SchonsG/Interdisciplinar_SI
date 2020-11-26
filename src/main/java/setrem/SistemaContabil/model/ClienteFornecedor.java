package setrem.SistemaContabil.model;
import javax.persistence.Entity;   
import javax.persistence.Id;
import javax.persistence.Table;

 
@Entity
@Table(name = "clientefornecedor")
public class ClienteFornecedor{
@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer cod;
private String tipo;
private Integer cpf_cnpj;
private Integer rg_ie;
private String nome_razao;
private String cep;
private String endereco;
private String numero;
private String cidade;
private String bairro;
private String complemento;
private String uf;
private String pais;
private String telefoneprincipal;
private String telefonesecundario;
private String email;

public Integer getCod() {
    return cod;
}

public void setCod(Integer cod) {
    this.cod = cod;
}

public String getTipo() {
    return tipo;
}

public void setTipo(String tipo) {
    this.tipo = tipo;
}

public Integer getCpf_cnpj() {
    return cpf_cnpj;
}

public void setCpf_cnpj(Integer cpf_cnpj) {
    this.cpf_cnpj = cpf_cnpj;
}

public Integer getRg_ie() {
    return rg_ie;
}

public void setRg_ie(Integer rg_ie) {
    this.rg_ie = rg_ie;
}

public String getNome_razao() {
    return nome_razao;
}

public void setNome_razao(String nome_razao) {
    this.nome_razao = nome_razao;
}

public String getCep() {
    return cep;
}

public void setCep(String cep) {
    this.cep = cep;
}

public String getEndereco() {
    return endereco;
}

public void setEndereco(String endereco) {
    this.endereco = endereco;
}

public String getNumero() {
    return numero;
}

public void setNumero(String numero) {
    this.numero = numero;
}

public String getCidade() {
    return cidade;
}

public void setCidade(String cidade) {
    this.cidade = cidade;
}

public String getBairro() {
    return bairro;
}

public void setBairro(String bairro) {
    this.bairro = bairro;
}

public String getComplemento() {
    return complemento;
}

public void setComplemento(String complemento) {
    this.complemento = complemento;
}

public String getUf() {
    return uf;
}

public void setUf(String uf) {
    this.uf = uf;
}

public String getPais() {
    return pais;
}

public void setPais(String pais) {
    this.pais = pais;
}

public String getTelefoneprincipal() {
    return telefoneprincipal;
}

public void setTelefoneprincipal(String telefoneprincipal) {
    this.telefoneprincipal = telefoneprincipal;
}

public String getTelefonesecundario() {
    return telefonesecundario;
}

public void setTelefonesecundario(String telefonesecundario) {
    this.telefonesecundario = telefonesecundario;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
	this.email = email;
}

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((cod == null) ? 0 : cod.hashCode());
    result = prime * result + ((cpf_cnpj == null) ? 0 : cpf_cnpj.hashCode());
    result = prime * result + ((rg_ie == null) ? 0 : rg_ie.hashCode());
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
    ClienteFornecedor other = (ClienteFornecedor) obj;
    if (cod == null) {
        if (other.cod != null)
            return false;
    } else if (!cod.equals(other.cod))
        return false;
    if (cpf_cnpj == null) {
        if (other.cpf_cnpj != null)
            return false;
    } else if (!cpf_cnpj.equals(other.cpf_cnpj))
        return false;
    if (rg_ie == null) {
        if (other.rg_ie != null)
            return false;
    } else if (!rg_ie.equals(other.rg_ie))
        return false;
    return true;
}
}
