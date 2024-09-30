package lts.exam1.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "registration")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private Integer registrationId;


    @Column(name = "course_id", updatable = false, insertable = false)
    private Integer courseId;
    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "student_id", updatable = false, insertable = false)
    private Integer studentId;
    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "status_id", updatable = false, insertable = false)
    private Integer statusId;
    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "status_id")
    private Status status;

    @Column(name = "account_id", updatable = false, insertable = false)
    private Integer accountId;
    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "registration_date")
    private LocalDate registrationDate;
    @Column(name = "starting_date")
    private LocalDate startingDate;
    @Column(name = "ending_date")
    private LocalDate endingDate;
}
