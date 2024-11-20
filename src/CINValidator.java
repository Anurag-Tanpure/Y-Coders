
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CINValidator {

    public static boolean validateCIN(String cin) {
        String apiUrl = "https://api.mca.gov.in/validateCIN?cin=" + cin;
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                return response.toString().contains("valid");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) {
        String cin = "L12345MP2024PLC123456";
        if (validateCIN(cin)) {
            System.out.println("The CIN is valid.");
        } else {
            System.out.println("The CIN is invalid.");
        }
    }
}
