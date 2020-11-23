package setrem.SistemaContabil.converters;

import javax.persistence.AttributeConverter;

public class PatrimonialResultadoConverter implements AttributeConverter<String, String> {
  @Override
  public String convertToDatabaseColumn(String value) {

    if ("Patrimonial".equals(value))
      return "P";
    else if ("Resultado".equals(value))
      return "R";

    return null;
  }

  @Override
  public String convertToEntityAttribute(String value) {
    if ("P".equals(value))
      return "Patrimonial";
    else if ("R".equals(value))
      return "Resultado";

    return null;
  }

}
