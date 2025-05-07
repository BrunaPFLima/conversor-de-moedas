package cotacao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Criação do cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Configuração da requisição HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/2480e22ab67e07d2ea8d7bab/latest/USD"))
                .build();

        // Enviar a requisição e obter a resposta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Captura do corpo da resposta
        String json = response.body();
        System.out.println("JSON recebido: " + json);  // Imprimir para debug

        // Usando Gson para deserializar a resposta
        Gson gson = new Gson();
        ExchangeRateResponse exchange = gson.fromJson(json, ExchangeRateResponse.class);

        // Verificando se as taxas de câmbio foram obtidas corretamente
        if (exchange.getConversion_rates() != null) {
            // Iniciando a interação com o usuário
            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("\n*** Conversor de Moedas ***");
                System.out.println("1. Converter USD para BRL");
                System.out.println("2. Converter USD para EUR");
                System.out.println("3. Converter USD para ARS");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                int option = scanner.nextInt();

                if (option == 0) {
                    System.out.println("Saindo...");
                    running = false;
                } else if (option == 1 || option == 2 || option == 3) {
                    // Solicitar valor a ser convertido
                    System.out.print("Informe o valor em USD para conversão: ");
                    double usdAmount = scanner.nextDouble();

                    // Realizar a conversão com base na opção escolhida
                    double result = 0.0;
                    String currency = "";
                    switch (option) {
                        case 1:
                            result = usdAmount * exchange.getConversion_rates().get("BRL");
                            currency = "BRL";
                            break;
                        case 2:
                            result = usdAmount * exchange.getConversion_rates().get("EUR");
                            currency = "EUR";
                            break;
                        case 3:
                            result = usdAmount * exchange.getConversion_rates().get("ARS");
                            currency = "ARS";
                            break;
                    }

                    System.out.println("Resultado: " + usdAmount + " USD = " + result + " " + currency);
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            }

            scanner.close(); // Fechar o scanner
        } else {
            System.out.println("Erro ao obter as taxas de câmbio.");
        }
    }
}
