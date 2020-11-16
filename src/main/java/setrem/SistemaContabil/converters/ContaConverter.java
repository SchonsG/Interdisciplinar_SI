package setrem.SistemaContabil.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import setrem.SistemaContabil.model.Conta;
import setrem.SistemaContabil.repository.ContaRepository;

@Component
public class ContaConverter implements Converter {

   @Autowired
   private ContaRepository repository;

   @Override
   public Object getAsObject(FacesContext context, UIComponent component, String value) {
      Conta conta = repository.findById(Integer.valueOf(value)).get();

      return conta;
   }

   @Override
   public String getAsString(FacesContext context, UIComponent component, Object value) {
      return ((Conta) value).getCONTA_ID().toString();
   }
}
