package Entities;

import java.util.Date;

public abstract class Redactable {
    public abstract void setTime(Date time);
    public abstract void setDescription(String str);
    public abstract void setTitle(String title);
    public abstract void setAuthor(String author);
    public abstract void setTitle_image_name(String title_image_name);
    public abstract void setTitle_image(String title_image);
    public abstract String getTitle_image_name();
    public abstract String getTitle();
    public abstract int getId();
    public abstract String getDescription();
    public abstract String getTitle_image();
    public abstract Date getTime();
    public abstract String getAuthor();
}
