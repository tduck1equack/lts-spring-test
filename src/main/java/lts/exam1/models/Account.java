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
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int accountId;
    @Column(length = 50)
    private String username;
    @Column(length = 50)
    private String account;
    @Column(length = 50)
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    @JsonManagedReference
    private List<Article> articles;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    @JsonManagedReference
    private List<Registration> registrations;

    @Column(name = "permission_id", updatable = false, insertable = false)
    private int permissionId;
    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "permission_id")
    private Permission permission;




}
