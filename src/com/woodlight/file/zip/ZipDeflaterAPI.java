package com.woodlight.file.zip;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.zip.Deflater;

public class ZipDeflaterAPI {
    public void deflateJavaObject() {

        String inputString = "text";
        byte[] input = inputString.getBytes(StandardCharsets.UTF_8);

        // Compress the bytes
        byte[] output = new byte[100];
        Deflater compresser = new Deflater();
        compresser.setInput(input);
        compresser.finish();
        int compressedDataLength = compresser.deflate(output);
        compresser.end();
    }
}
