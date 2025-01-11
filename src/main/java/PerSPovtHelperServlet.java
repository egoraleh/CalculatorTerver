import freemarker.template.TemplateException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/per-s-povt-helper")
public class PerSPovtHelperServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        Map<String, Object> content = new HashMap<>();
        content.put("incorrect", req.getAttribute("incorrect"));
        content.put("contextPath", req.getContextPath());
        try {
            FreemarkerHelper.drawPage(req, resp, "perspovthelper.ftl", content);
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
        req.removeAttribute("incorrect");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        int ncount = Integer.parseInt(req.getParameter("ncount"));
        if (ncount < 1) {
            req.setAttribute("incorrect", "1");
            doGet(req, resp);
            return;
        }
        req.getSession().setAttribute("ncount", ncount);
        try {
            resp.sendRedirect(req.getContextPath() + "/per-s-povt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}