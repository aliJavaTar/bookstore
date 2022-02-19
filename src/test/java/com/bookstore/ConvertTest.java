package com.bookstore;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;
import static org.apache.commons.io.FileUtils.openInputStream;


public class ConvertTest {
    @Test
    public void whenConvertingToFile_thenCorrect() throws IOException {
        Path path = Paths.get("C:\\Users\\Lion\\Desktop\\ali.txt");
        byte[] buffer = java.nio.file.Files.readAllBytes(path);
         //id
        File targetFile = new File("C:\\Users\\Lion\\Desktop\\BookStorWebsit\\src\\main\\webapp\\image\\"+"id"+".jpg");
        OutputStream outStream = new FileOutputStream(targetFile);
        outStream.write(buffer);

        IOUtils.closeQuietly(outStream);
    }
}
