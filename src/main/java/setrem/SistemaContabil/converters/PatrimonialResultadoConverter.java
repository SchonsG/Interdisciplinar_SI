package setrem.SistemaContabil.converters;

import javax.persistence.AttributeConverter;

public class PatrimonialResultadoConverter implements AttributeConverter<String, String> {
  @Override
  public String convertToDatabaseColumn(String value) {

    if ("Patrimonial".equals(value))
      return "PA";
    else if ("Resultado".equals(value))
      return "RE";

    return null;
  }

  @Override
  public String convertToEntityAttribute(String value) {
    if ("PA".equals(value))
      return "Patrimonial";
    else if ("RE".equals(value))
      return "Resultado";

    return null;
  }

}
