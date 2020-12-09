package setrem.SistemaContabil.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class ReportUtil {

   public void imprimirRelatorio(String nomeRelatorio, Map parametros, Connection con) {
      ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

      HttpServletResponse response = (HttpServletResponse) ec.getResponse();
      response.setContentType("application/pdf");
      response.setHeader("content-disposition", "inline; " + nomeRelatorio + ".pdf");

      ServletOutputStream stream;

      try {
         InputStream io = this.getClass().getResourceAsStream("/reports/"+nomeRelatorio+".jasper");
         JasperPrint print = JasperFillManager.fillReport(io, parametros, con);

         stream = response.getOutputStream();

         JRPdfExporter export = new JRPdfExporter();
         export.setExporterInput(new SimpleExporterInput(print));
         export.setExporterOutput(new SimpleOutputStreamExporterOutput(stream));
         export.exportReport();

         stream.flush();
         stream.close();
      } catch (IOException | JRException ex) {
         Logger.getLogger(ReportUtil.class.getName()).log(Level.SEVERE, null, ex);
      }
      FacesContext.getCurrentInstance().responseComplete();
   }
} 