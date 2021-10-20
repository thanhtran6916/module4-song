package com.music.model;


import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongForm {

    private Long id;

    @NotEmpty(message = "khong duoc de trong")
    @Size(max = 800, message = "khong qua 800 ky tu")
    @Pattern(regexp = "^\\w+$", message = "khong chua ky tu dac biet")
    private String name;

    @NotEmpty(message = "khong duoc de trong")
    @Size(max = 300, message = "khong qua 300 ky tu")
    @Pattern(regexp = "^\\w+$", message = "khong chua ky tu dac biet")
    private String artist;

    @NotEmpty(message = "khong duoc de trong")
    @Size(max = 1000, message = "khong quas 1000 ky tu")
    @Pattern(regexp = "^[^,]+$", message = "khong chua dau ,")
    private String category;

    private MultipartFile file;

    public SongForm() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
