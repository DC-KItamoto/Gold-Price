package financeTest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
// import java.util.Map;
// import com.google.gson.Gson;

public class Gold {
    private static final String API_KEY = "0f2832847bb70fa6dffe59c30705ae16";
    public double GoldPrice() {
        double price = 0.0;
        try {
            URL url = new URL("https://api.metalpriceapi.com/v1/latest");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("x-api-key", API_KEY);
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = reader.readLine();
            System.out.println(line);
            // if (line != null) {
            //     Gson gson = new Gson();
            //     ApiResponse response = gson.fromJson(line, ApiResponse.class);
            //     if (response.isSuccess()) {
            //         price = response.getRates().get("XAU");
            //     } else {
            //         System.out.println("API Error: " + response.getError().getMessage());
            //     }
            // }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return price;
    }
}
// class ApiResponse {
//     private boolean success;
//     private ErrorData error;
//     private Map<String, Double> rates;
//     public boolean isSuccess() {
//         return success;
//     }
//     public ErrorData getError() {
//         return error;
//     }
//     public Map<String, Double> getRates() {
//         return rates;
//     }
// }
// class ErrorData {
//     private int statusCode;
//     private String message;
//     public int getStatusCode() {
//         return statusCode;
//     }
//     public String getMessage() {
//         return message;
//     }
// }