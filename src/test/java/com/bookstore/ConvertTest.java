package com.bookstore;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;
import static org.apache.commons.io.FileUtils.openInputStream;


public class ConvertTest {
    @Test
    public void whenConvertingInputStreamToFile_thenCorrect4()
            throws IOException {
        InputStream initialStream = openInputStream
                (new File("C:\\Users\\Lion\\Desktop\\todo.txt"));

        File targetFile = new File("C:\\\\Users\\\\Lion\\\\Desktop\\\\ali.txt");

        copyInputStreamToFile(initialStream, targetFile);
    }
}
