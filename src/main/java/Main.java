import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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


  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
        //Fill String with HTTPServletRequest Text
        InputStream reqBody = req.getInputStream();
        StringWriter writer = new StringWriter();
        IOUtils.copy(reqBody, writer, StandardCharsets.UTF_8);
        String theString = writer.toString();

        //Write String to textfile
        String separator_type = System.getProperty("file.separator");
        String user_dir = System.getProperty("user.dir").concat(separator_type);
        String path = user_dir.concat("reviews.txt");
        
        //Textfile Writer
        PrintWriter out = new PrintWriter(path);
        out.println(theString);
        out.close();

        String score = ScoreDetector.parseReviews(user_dir + "score.txt");

        //pass user_dir+score.txt to ScoreDetector
          //String score = ScoreDetector.parseReviews(theString);
        //Score detector should perform Counterfeit Detection
        //Return a score

        //read contents of TextFile to test POST message functioning and Heroku-hosted text writing
        String content = readFile("reviews.txt", StandardCharsets.UTF_8);

        resp.getWriter().print("Score:" + score + " // Reviews.txt contents: " + content + "Wimmer");
        //resp.getWriter().print("Score:" + score);
   
  }


  static String readFile(String path, Charset encoding) throws IOException {
    byte[] encoded = Files.readAllBytes(Paths.get(path));
    return new String(encoded, encoding);
  }



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
