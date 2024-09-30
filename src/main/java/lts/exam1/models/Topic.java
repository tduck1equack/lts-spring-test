package lts.exam1.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "topic")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    private Integer topicId;
    @Column(length = 50)
    private String name;
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "topic")
    @JsonManagedReference
    private List<Article> articles;

    @Column(name = "article_type_id", updatable = false, insertable = false)
    private Integer articleTypeId;
    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "article_type_id")
    private ArticleType articleType;
}
