

import com.sun.deploy.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class InterfaceBindServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        String pageUrl = request.getParameter("pageUrl");
        String domElementId = request.getParameter("domElementId");

        // validate page url
        if ( pageUrl == null ) {
            response.setContentType("text/javascript");
            PrintWriter pw = response.getWriter();

            // # search comments in database
            Comment[] comments = new Comment[] {
              new Comment( pageUrl, "Foo", "foo@mail.com", "Content1", null  ),
            };

            String scriptString = generateScriptString( comments );
            pw.print( scriptString );
            pw.close();
        }

    }

    public String generateScriptString( Comment[] comments ) {
        // # update dom element via js
        // # add user interaction logic
        String scriptString = "" +
//                "alert(\"Test!\")" +
                "" +
                "" +
                "";
        return scriptString;
    }
}
