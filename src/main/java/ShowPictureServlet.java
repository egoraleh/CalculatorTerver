import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/show-picture")
public class ShowPictureServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        try {
            String filename = req.getParameter("image_name");
            File file = new File(req.getServletContext().getAttribute("imageRootPath")+ "\\" + filename);
            resp.setContentType("image/jpg");
            resp.setContentLength((int) file.length());
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream inputStream = new BufferedInputStream(fileInputStream);
            ServletOutputStream outputStream = resp.getOutputStream();
            int readBytes = 0;
            while ((readBytes = inputStream.read()) != -1)
                outputStream.write(readBytes);
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}