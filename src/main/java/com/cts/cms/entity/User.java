package com.cts.cms.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "member")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "contact_no", nullable = false, unique = true)
    private Long contactNo;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "nominees", nullable = false)
    private int nominees;

    @Column(name = "insurance_type", nullable = false)
    private String insuranceType;

    @Column(name = "max_claim_amount", nullable = false)
    private Long maxClaimAmount;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;
}
