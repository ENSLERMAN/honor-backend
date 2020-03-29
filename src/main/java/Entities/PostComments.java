package Entities;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="honor_posts_comments")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PostComments implements Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nickname;
    @Column
    private String description;
    @Column
    @Temporal(value = TemporalType.DATE)
    private Date time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private Post post;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNickname() {
        return nickname;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Date getTime() {
        return time;
    }

    @Override
    public void setNickname(String nickname) {
        this.nickname=nickname;
    }

    @Override
    public void setDescription(String description) {
        this.description=description;
    }

    @Override
    public void setTime(Date time) {
        this.time=time;
    }

    @Override
    public void setRedactable(Redactable redactable) {
        this.post=(Post) redactable;
    }
}
