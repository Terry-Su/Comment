import com.google.gson.Gson;
import org.json.JSONArray;
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
import java.util.ArrayList;


public class InterfaceCommentsServlet extends HttpServlet {
//    private ArrayList<Comment> commentListInDatabase = new ArrayList<Comment>();

    public ArrayList<Comment> getCommentListInDatabase() {
        ArrayList<Comment> result = new ArrayList<Comment>();
        Connection connection = ConnectToMySQL.connect();
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery("USE CommentSystem");
            // # query comment
            ResultSet resultSet = statement.executeQuery("SELECT * from comments");
            while(resultSet.next()) {
                String pageId = resultSet.getString(1);

                // validate pageId
//                if (pageId != "null") {
//                    continue;
//                }

                String userId = resultSet.getString(2);
                String name = resultSet.getString(3);
                String email = resultSet.getString(4);
                String content = resultSet.getString(5);
                java.sql.Timestamp createTime = resultSet.getTimestamp(6);
                Comment comment = new Comment(pageId, userId, name, email, content, createTime);
                result.add(comment);
            }

        } catch( SQLException e ) {
            throw new IllegalStateException(e);
        }
        return result;
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        String pageUrl = request.getParameter("pageUrl");
        String domElementId = request.getParameter("domElementId");

        // validate page url
        if ( pageUrl == null ) {
            response.setContentType("application/json");
            PrintWriter pw = response.getWriter();

            // # search comments in database
            ArrayList<Comment> commentListInDatabase = getCommentListInDatabase();
            String jsonString = new Gson().toJson(commentListInDatabase);
            pw.print(jsonString);
            pw.close();

        }

    }

}
