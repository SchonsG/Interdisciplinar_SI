package setrem.SistemaContabil.converters;

import javax.persistence.AttributeConverter;

public class CreditoDebitoConverter implements AttributeConverter<String, String> {
  @Override
  public String convertToDatabaseColumn(String value) {

    if ("Crédito".equals(value))
      return "CR";
    else if ("Débito".equals(value))
      return "DE";

    return null;
  }

  @Override
  public String convertToEntityAttribute(String value) {
    if ("CR".equals(value))
      return "Crédito";
    else if ("DE".equals(value))
      return "Débito";

    return null;
  }

}
