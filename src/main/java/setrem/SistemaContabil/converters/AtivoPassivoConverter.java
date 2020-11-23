package setrem.SistemaContabil.converters;

import javax.persistence.AttributeConverter;

public class AtivoPassivoConverter implements AttributeConverter<String, String> {
  @Override
  public String convertToDatabaseColumn(String value) {

    if ("Passivo".equals(value))
      return "P";
    else if ("Ativo".equals(value))
      return "A";

    return null;
  }

  @Override
  public String convertToEntityAttribute(String value) {
    if ("P".equals(value))
      return "Passivo";
    else if ("A".equals(value))
      return "Ativo";

    return null;
  }

}
