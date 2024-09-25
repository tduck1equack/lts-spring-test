package lts.exam1.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;
    private String photo;
    @Column(length = 50)
    private String name;
    private LocalDate birthday;
    @Column(length = 11)
    private String telephone;
    @Column(length = 40)
    private String email;
    @Column(length = 50)
    private String province;
    @Column(length = 50)
    private String district;
    @Column(length = 50)
    private String ward;
    @Column(name = "house_number", length = 50)
    private String houseNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    @JsonManagedReference
    private List<Registration> registrations;
}
