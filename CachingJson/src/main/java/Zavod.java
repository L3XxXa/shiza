import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Zavod {
    public String jsonZavod(String note){
        Gson gson = new Gson();
        GsonBuilder gsonBuilder = gson.newBuilder();
        Json json = new Json(note);
        return gson.toJson(json);
    }
    public String jsonUnzavod(String note){
        Gson gson = new Gson();
        GsonBuilder gsonBuilder = gson.newBuilder();
        return gson.fromJson(note, Json.class).toString();
    }
}
