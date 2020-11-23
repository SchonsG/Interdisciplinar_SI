package setrem.SistemaContabil.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import setrem.SistemaContabil.model.Historico;
import setrem.SistemaContabil.repository.HistoricoRepository;

@Component
public class HistoricoConverter implements Converter {

   @Autowired
   private HistoricoRepository repository;

   @Override
   public Object getAsObject(FacesContext context, UIComponent component, String value) {
      Historico historico = repository.findById(Integer.valueOf(value)).get();

      return historico;
   }

   @Override
   public String getAsString(FacesContext context, UIComponent component, Object value) {
      return ((Historico) value).getHISTORICO_ID().toString();
   }
}
