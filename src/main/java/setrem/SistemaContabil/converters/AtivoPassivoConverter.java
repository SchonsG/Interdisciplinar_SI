package setrem.SistemaContabil.converters;

import javax.persistence.AttributeConverter;

public class AtivoPassivoConverter implements AttributeConverter<String, String> {
  @Override
  public String convertToDatabaseColumn(String value) {

    if ("Passivo".equals(value))
      return "PA";
    else if ("Ativo".equals(value))
      return "AT";

    return null;
  }

  @Override
  public String convertToEntityAttribute(String value) {
    if ("PA".equals(value))
      return "Passivo";
    else if ("AT".equals(value))
      return "Ativo";

    return null;
  }

}
