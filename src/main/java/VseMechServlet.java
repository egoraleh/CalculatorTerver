import freemarker.template.TemplateException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/vse-mech")
public class VseMechServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        Map<String, Object> content = new HashMap<>();
        content.put("contextPath", req.getContextPath());
        content.put("incorrect", req.getAttribute("incorrect"));
        content.put("answer", req.getAttribute("answer"));
        try {
            FreemarkerHelper.drawPage(req, resp, "vsemech.ftl", content);
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
        int m = Integer.parseInt(req.getParameter("m"));
        if (k < 1 || k > n || m < 1 || m < k) {
            req.setAttribute("incorrect", "1");
            doGet(req, resp);
            return;
        }
        BigInteger chislitel = FactorialHelper.factorial(m).divide(FactorialHelper.factorial(k).multiply(FactorialHelper.factorial(m - k)));
        BigInteger znamenatel = FactorialHelper.factorial(n).divide(FactorialHelper.factorial(k).multiply(FactorialHelper.factorial(n - k)));
        BigInteger nod = chislitel.gcd(znamenatel);
        chislitel = chislitel.divide(nod);
        znamenatel = znamenatel.divide(nod);
        if (!chislitel.equals(BigInteger.ZERO)) {
            String ans = "";
            ans += chislitel.toString();
            ans += "/";
            ans += znamenatel.toString();
            req.setAttribute("answer", ans);
            doGet(req, resp);
        } else {
            int ans = 0;
            req.setAttribute("answer", ans);
            doGet(req, resp);
        }
    }
}