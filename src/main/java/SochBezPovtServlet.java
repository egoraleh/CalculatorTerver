import freemarker.template.TemplateException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/soch-bez-povt")
public class SochBezPovtServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        Map<String, Object> content = new HashMap<>();
        content.put("contextPath", req.getContextPath());
        content.put("incorrect", req.getAttribute("incorrect"));
        content.put("answer", req.getAttribute("answer"));
        try {
            FreemarkerHelper.drawPage(req, resp, "sochbezpovt.ftl", content);
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
        req.removeAttribute("incorrect");
        req.removeAttribute("answer");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        int n = Integer.parseInt(req.getParameter("n"));
        int k = Integer.parseInt(req.getParameter("k"));
        if (k < 1 || k > n) {
            req.setAttribute("incorrect", "1");
            doGet(req, resp);
            return;
        }
        BigInteger ans = FactorialHelper.factorial(n).divide(FactorialHelper.factorial(k).multiply(FactorialHelper.factorial(n - k)));
        req.setAttribute("answer", ans);
        doGet(req, resp);
    }
}