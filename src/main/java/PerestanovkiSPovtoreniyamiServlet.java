import freemarker.template.TemplateException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/per-s-povt")
public class PerestanovkiSPovtoreniyamiServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        Map<String, Object> content = new HashMap<>();
        content.put("contextPath", req.getContextPath());
        content.put("x", req.getSession().getAttribute("ncount"));
        content.put("incorrect", req.getAttribute("incorrect"));
        content.put("answer", req.getAttribute("answer"));
        try {
            FreemarkerHelper.drawPage(req, resp, "perspovt.ftl", content);
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
        req.removeAttribute("incorrect");
        req.removeAttribute("answer");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        int[] nlist = new int[(int) req.getSession().getAttribute("ncount")];
        int n = 0;
        BigInteger znam = BigInteger.ONE;
        for (int i = 1; i <= nlist.length; i++) {
            nlist[i - 1] = Integer.parseInt(req.getParameter("n" + i));
            if (nlist[i - 1] < 1) {
                req.setAttribute("incorrect", "1");
                doGet(req, resp);
                return;
            }
            n += nlist[i - 1];
            znam = znam.multiply(FactorialHelper.factorial(nlist[i - 1]));
        }
        if (n < 1) {
            req.setAttribute("incorrect", "1");
            doGet(req, resp);
            return;
        }
        BigInteger ans = FactorialHelper.factorial(n).divide(znam);
        req.setAttribute("answer", ans);
        doGet(req, resp);
    }
}