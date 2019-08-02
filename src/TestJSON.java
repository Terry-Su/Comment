import org.json.JSONObject;

public class TestJSON {
    public static void main(String[] args) {
//        JSONObject test = new JSONObject("{\"foo\": \"123\"}" );
        JSONObject test = new JSONObject("{\"pageUrl\":null,\"name\":\"Comment1\",\"email\":\"comment@mail.com\",\"content\":\"Comment content 1\"}" );
        System.out.println( test.get( "name" ) );
    }
}
