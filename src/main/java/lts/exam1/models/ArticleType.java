package lts.exam1.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "article_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_type_id")
    private int articleTypeId;
    @Column(length = 50)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "articleType")
    @JsonManagedReference
    private List<Topic> topics;
}
