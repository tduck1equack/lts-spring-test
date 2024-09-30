package lts.exam1.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "course_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_type_id")
    private Integer courseTypeId;
    @Column(length = 30)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "courseType")
    @JsonManagedReference
    private List<Course> courses;
}
