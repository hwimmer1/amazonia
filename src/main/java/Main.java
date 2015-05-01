import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.apache.commons.io.IOUtils;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import detector.*;

public class Main extends HttpServlet {
/*  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    if (req.getRequestURI().endsWith("/other")) {
      //showOther(req,resp);
    } else {
      //showHome(req,resp);
    }
  }*/

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

        /*try {
          Thread.sleep(4000);
        } catch (InterruptedException e) {

        }*/
        InputStream body = req.getInputStream();

        StringWriter writer = new StringWriter();
        IOUtils.copy(body, writer, StandardCharsets.UTF_8);
        String theString = writer.toString();
        
        String score = ScoreDetector.parseReviews(theString);

        resp.getWriter().print(score);
    /*if (req.getRequestURI().endsWith("/other")) {
      //showOther(req,resp);
    } else {
      //showHome(req,resp);
    }*/
  }

/*  private void showHome(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.getWriter().print("Hello from Java!");
  }
  
  private void showOther(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.getWriter().print("Hello from Other!");
  }*/


  public static void main(String[] args) throws Exception {
    Server server = new Server(Integer.valueOf(System.getenv("PORT")));
    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");
    server.setHandler(context);
    context.addServlet(new ServletHolder(new Main()),"/*");
    server.start();
    server.join();
  }
}
