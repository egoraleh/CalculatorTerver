import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import jakarta.servlet.http.HttpServletRequest;


public class FreemarkerConfigSingleton {
    private static Configuration cfg;
    public static Configuration getCfg(HttpServletRequest request) {
        if (cfg == null) {
            cfg = new Configuration();
            cfg.setServletContextForTemplateLoading(request.getServletContext(), "/WEB-INF/templates");
            cfg.setIncompatibleImprovements(new Version(2, 3, 33));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        }
        return cfg;
    }
}