import java.util.Date;
import java.util.UUID;

public class Comment {
    String pageId;
    String userId;
    String name;
    String email;
    String content;
    java.sql.Date date;

    public Comment( String pageId, String name, String email, String content, java.sql.Date date) {
        this.pageId = pageId;
        this.name = name;
        this.email = email;
        this.content = content;
        this.date = date;

        this.userId = UUID.randomUUID().toString();
    }
}
