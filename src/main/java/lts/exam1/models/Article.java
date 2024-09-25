package lts.exam1.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "article")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private int articleId;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String author;
    private String content;
    @Column(length = 1000)
    private String description;
    @Column(name = "create_time")
    private LocalDate createTime;
    private String photo;

    @Column(name = "topic_id", updatable = false, insertable = false)
    private int topicId;
    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @Column(name = "account_id", updatable = false, insertable = false)
    private int accountId;
    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "account_id")
    private Account account;
}
