package org.example;

public class Subscriber {
    public static void main(String[] args) {
        ClienteMQTT clienteMQTT = new ClienteMQTT("tcp://localhost:1883", null, null);
        clienteMQTT.iniciar();

        new Ouvinte(clienteMQTT, "/mensagens/", 0);
    }
}
