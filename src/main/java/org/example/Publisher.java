package org.example;

import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ClienteMQTT clienteMQTT = new ClienteMQTT("tcp://localhost:1883", null, null);
        clienteMQTT.iniciar();

        new Ouvinte(clienteMQTT, "/mensagens/", 0);

        while (true) {
            Thread.sleep(1000);
            String mensagem = "Mensagem enviada em " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(System.currentTimeMillis());

            clienteMQTT.publicar("/mensagens/", mensagem.getBytes(), 0);
        }
    }
}