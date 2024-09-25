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
@Table(name = "course")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;
    @Column(length = 50)
    private String name;
    @Column(name = "learning_time")
    private int learningTime;
    private String introduction;
    private String description;
    private double fee;
    @Column(name = "student_count")
    private int studentCount;
    @Column(name = "subject_count")
    private int subjectCount;
    private String photo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    @JsonManagedReference
    private List<Registration> registrations;

    @Column(name = "course_type_id", updatable = false, insertable = false)
    private int courseTypeId;
    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "course_type_id")
    private CourseType courseType;

}
