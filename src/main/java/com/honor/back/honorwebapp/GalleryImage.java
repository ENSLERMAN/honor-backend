package com.honor.back.honorwebapp;

import javax.persistence.*;

@Entity
@Table(name="honor_gallery")
public class GalleryImage {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String url;
    @Column
    private String server_path;

    public GalleryImage() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getServer_path() {
        return server_path;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setServer_path(String server_path) {
        this.server_path = server_path;
    }
}
