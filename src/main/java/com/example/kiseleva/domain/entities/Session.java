package com.example.kiseleva.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "diagnose_id")
    private Diagnose diagnose;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "status")
    private String status;

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}

    public Diagnose getDiagnose() {return diagnose;}

    public void setDiagnose(Diagnose diagnose) {this.diagnose = diagnose;}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

}
