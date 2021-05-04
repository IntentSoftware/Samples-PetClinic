package com.spring_petclinic.spring_petclinic_rest.domain.models;

import com.spring_petclinic.spring_petclinic_rest.intent.IntentManageClass;
import com.spring_petclinic.spring_petclinic_rest.intent.Mode;
import java.util.List;
import javax.persistence.*;



@Entity
@Table(name = "vet")
@IntentManageClass(privateMethods = Mode.Ignore)
public class Vet extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    @Column(name = "first_name", length = 30, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 30, nullable = false)
    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "vet_specialty",
            joinColumns = { @JoinColumn(name = "vet_id") },
            inverseJoinColumns = { @JoinColumn(name = "specialty_id") }
    )
    private List<Specialty> specialties;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Specialty> getSpecialties() {
        return this.specialties;
    }

    public void setSpecialties(List<Specialty> specialties) {
        this.specialties = specialties;
    }
}
