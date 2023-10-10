package org.example;

import java.io.IOException;

public class Main {
    public static void main (String[] args) throws IOException {

        new ConnectWindow(new Logging("./Chat_log"));
    }
}