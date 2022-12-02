package com.example.kiseleva.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "symptom")
public class SessionSymptom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @ManyToOne
    @JoinColumn(name = "symptom_id")
    private Symptom symptom;

    @Column(name = "grade")
    private String grade;

    public String getGrade() {return grade;}

    public void setGrade(String grade) {this.grade = grade;}

    public Symptom getSymptom() {return symptom;}

    public void setSymptom(Symptom symptom) {this.symptom = symptom;}

    public Session getSession() {return session;}

    public void setSession(Session session) {this.session = session;}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

}
