package com.woodlight.file.zip;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class ZipInflaterAPI {

    public ZipInflaterAPI(ZipInflaterAPI zipInflaterAPI) {}

    public void inflateDeflatedJavaObject() {
        try {
            String inputString = "text";
            byte[] input = inputString.getBytes(StandardCharsets.UTF_8);

            byte[] output = new byte[100];
            Deflater compresser = new Deflater();
            int compressedDataLength = compresser.deflate(output);
            compresser.end();

            Inflater decompresser = new Inflater();
            decompresser.setInput(output, 0, compressedDataLength);
            byte[] result = new byte[100];
            int resultLength = decompresser.inflate(result);
            decompresser.end();

        } catch (DataFormatException ex) {
            ex.printStackTrace();
        }
    }
}
