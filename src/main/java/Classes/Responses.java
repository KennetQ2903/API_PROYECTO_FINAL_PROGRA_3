package Classes;

import java.util.HashMap;

public class Responses {
    public HashMap<String, Boolean>authResponse(boolean isAuth){
        HashMap<String, Boolean> response = new HashMap<>();
        response.put("isAuth", isAuth);
        return response;
    }
    public HashMap<String, String> addUsuario(String added, String message){
        HashMap<String, String> response = new HashMap<>();
        response.put("code", added);
        response.put("message", message);
        return response;
    }
}
