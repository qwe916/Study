package com.example.spring.jdbc;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter@Data
public class Image {
    private int id;
    private String url;
    private String name;

    public Image(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public Image(int id, String url, String name) {
        this.id = id;
        this.url = url;
        this.name = name;
    }

    public Image() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Image image)) return false;

        if (id != image.id) return false;
        if (!Objects.equals(url, image.url)) return false;
        return Objects.equals(name, image.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
