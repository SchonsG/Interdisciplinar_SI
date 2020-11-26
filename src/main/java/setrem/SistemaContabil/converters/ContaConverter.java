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

      Conta conta = new Conta();

      if (!value.equals("")) {
         return conta = repository.findById(Integer.valueOf(value)).get();
      } else {
         return null;
      }

   }

   @Override
   public String getAsString(FacesContext context, UIComponent component, Object value) {
 //     return ((Conta) value).getCONTA_ID().toString();

      if (value == null) {
         return "";
      } else {
         return "" + ( (Conta) value ).getCONTA_ID();
      }
   }
}
