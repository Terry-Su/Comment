
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Collectors;


public class InterfaceCommentServlet extends HttpServlet {
    public static void main(String[] args) {
//        JSONObject test = new JSONObject("{\"foo\": \"123\"}" );
//        JSONObject test = new JSONObject("{}" );
//        System.out.println( test.get( "name" ) );
    }



    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestPayloadString = request.getReader().lines().collect(Collectors.joining());
        JSONObject payloadJSON = new JSONObject(requestPayloadString);
        String pageUrl = payloadJSON.get( "pageUrl" ).toString();
        String name = payloadJSON.get( "name" ).toString();
        String email = payloadJSON.get( "email" ).toString();
        String content = payloadJSON.get( "content" ).toString();
        // # validate pageUrl
        if ( pageUrl == "null" ) {
            Comment comment = new Comment( pageUrl, null, name, email, content, null );

            // # connect to database
            Connection connection = ConnectToMySQL.connect();
            try {
                    Statement statement = connection.createStatement();
                    statement.executeQuery("USE CommentSystem");
                String insertString = "insert into comments values\n" +
                        "(\n" +
                        '\'' + comment.pageId + "',\n'" +
                        comment.userId + "',\n'" +
                        comment.name + "',\n'" +
                        comment.email + "',\n'" +
                        comment.content + "',\n" +
                        "now()"+ "\n" +
                        ");";
                statement.execute( insertString );
                connection.close();
                response.setContentType("application/json");
                PrintWriter pw = response.getWriter();
                pw.print("{}");
            } catch( SQLException e ) {
                throw new IllegalStateException(e);
            }
        }
    }
}
