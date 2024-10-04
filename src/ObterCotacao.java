import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ObterCotacao {

    public Moedas obtendoCotacao() {
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/YOUR-API-KEY/latest/USD");
        HttpClient client =  HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(endereco).build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return  gson.fromJson(response.body(), Moedas.class);

        } catch (IOException |  InterruptedException  e) {
            throw new RuntimeException(e);
        }


    }

}
