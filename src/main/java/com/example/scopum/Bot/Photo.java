package com.example.scopum.Bot;

import java.io.File;
import java.util.Objects;

public class Photo {
    private File photo;


    public File getPhoto() {
        return photo;
    }

    public void setPhoto(String name) {
        ClassLoader cl = getClass().getClassLoader();
        String absolutePath = cl.getResource(name).getPath();
        this.photo = new File(absolutePath);
    }
}
