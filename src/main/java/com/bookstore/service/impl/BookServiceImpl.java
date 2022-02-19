package com.bookstore.service.impl;

import com.bookstore.dao.BookDao;
import com.bookstore.entity.Books;
import com.bookstore.service.BookService;
import com.bookstore.service.base.BaseServiceImpl;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class BookServiceImpl extends BaseServiceImpl<Books, Long, BookDao> implements BookService {
    public BookServiceImpl(BookDao repository) {
        super(repository);
    }

    public boolean deleteImage(String image_path) {
        try {
            String absolutePath = new File(image_path).getAbsolutePath();
            File f = new File(absolutePath);
            if (f.exists())
                return f.delete();
            else System.out.println(f.exists());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public byte[] readImage(Part image) throws IOException {
        byte[] imageByte ;
        if (image != null&& image.getSize() > 0)
        {
            long size = image.getSize();
            imageByte = new byte[(int) size];
            InputStream stream = image.getInputStream();

            stream.close();
            return imageByte;
        } else throw new IOException("no image");
    }
    public void convertToFile(String address,Long id) throws IOException {
        Path path = Paths.get(address);
        byte[] buffer = java.nio.file.Files.readAllBytes(path);
        File targetFile = new File("C:\\Users\\Lion\\Desktop\\BookStorWebsit\\src\\main\\webapp\\image\\"+id+".jpg");
        OutputStream outStream = new FileOutputStream(targetFile);
        outStream.write(buffer);

        IOUtils.closeQuietly(outStream);
    }

}
