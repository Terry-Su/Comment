import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class Comment {
    public String pageId;
    public String userId;
    public String name;
    public String email;
    public String content;
    public java.sql.Timestamp createTime;

    public Comment( String pageId, String userId, String name, String email, String content, java.sql.Timestamp createTime) {
        this.pageId = pageId;
        this.name = name;
        this.email = email;
        this.content = content;
        this.createTime = createTime;
        if ( userId != null ) {
            this.userId = userId;
        } else {
            this.userId = UUID.randomUUID().toString();
        }
    }

    public Object getMap() {
        return new Object(){};
    }
}
