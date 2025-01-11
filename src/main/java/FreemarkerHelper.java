import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class FreemarkerHelper {
    public static void drawPage(HttpServletRequest request, HttpServletResponse response, String ftl, Map<String, Object> context) throws IOException, TemplateException {
        Configuration cfg = FreemarkerConfigSingleton.getCfg(request);
        Template template = cfg.getTemplate(ftl);
        template.process(context, response.getWriter());
    }
}
