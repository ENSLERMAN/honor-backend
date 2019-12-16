package Entities;



import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name="honor_gallery_comments")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class GalleryComments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nickname;
    @Column
    @Temporal(value = TemporalType.DATE)
    private Date time;
    @Column
    private String email;
    @Column
    private String comment;
    @Column
    private Boolean active;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="photo_id")
    private GalleryImage image;

    public GalleryComments() {
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public Date getTime() {
        return time;
    }

    public String getComment() {
        return comment;
    }

//    public GalleryImage getImage() {
//        return image;
//    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setImage(GalleryImage image) {
        this.image = image;
    }

}
