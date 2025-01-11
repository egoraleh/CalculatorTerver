import freemarker.template.TemplateException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/ne-vse-mech")
public class NeVseMechServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        Map<String, Object> content = new HashMap<>();
        content.put("contextPath", req.getContextPath());
        content.put("incorrect", req.getAttribute("incorrect"));
        content.put("answer", req.getAttribute("answer"));
        try {
            FreemarkerHelper.drawPage(req, resp, "nevsemech.ftl", content);
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
        int r = Integer.parseInt(req.getParameter("r"));
        if (m > n || r > k || r > m || k < 0 || m < 1 || r < 0) {
            req.setAttribute("incorrect", "1");
            doGet(req, resp);
            return;
        }
        BigInteger chislitel1 = FactorialHelper.factorial(m).divide(FactorialHelper.factorial(r).multiply(FactorialHelper.factorial(m - r)));
        BigInteger chislitel2 = FactorialHelper.factorial(n - m).divide(FactorialHelper.factorial(k - r).multiply(FactorialHelper.factorial(n - m - k + r)));
        BigInteger znamenatel = FactorialHelper.factorial(n).divide(FactorialHelper.factorial(k).multiply(FactorialHelper.factorial(n - k)));
        BigInteger chislitel = chislitel1.multiply(chislitel2);
        BigInteger nod = chislitel.gcd(znamenatel);
        chislitel = chislitel.divide(nod);
        znamenatel = znamenatel.divide(nod);
        if (chislitel.equals(BigInteger.ZERO)) {
            int ans = 0;
            req.setAttribute("answer", ans);
            doGet(req, resp);
        } else if (chislitel.equals(znamenatel)) {
             int ans = 1;
             req.setAttribute("answer", ans);
             doGet(req, resp);
        } else {
            String ans = "";
            ans += chislitel.toString();
            ans += "/";
            ans += znamenatel.toString();
            req.setAttribute("answer", ans);
            doGet(req, resp);
        }
    }
}