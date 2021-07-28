package com.woodlight.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class LeafURLConnection {
    LeafURLConnection(String path) throws IOException {

        URL url = new URL("");
        URLConnection connection = url.openConnection();
        connection.connect();

    }
}
