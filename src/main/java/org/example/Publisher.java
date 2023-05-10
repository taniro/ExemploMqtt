package org.example;

import java.text.SimpleDateFormat;

/*

 EXEMPLO BASEADO NO CÓDIGO DISPONÍVEL EM https://www.paulocollares.com.br/programacao/exemplo-de-mqtt-com-java/

 */

public class Publisher {
    public static void main(String[] args) throws InterruptedException {
        ClienteMQTT clienteMQTT = new ClienteMQTT("tcp://localhost:1883", null, null);
        clienteMQTT.iniciar();

        while (true) {
            Thread.sleep(1000);
            String mensagem = "Mensagem enviada em " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(System.currentTimeMillis());

            clienteMQTT.publicar("/mensagens/", mensagem.getBytes(), 0);
        }
    }
}