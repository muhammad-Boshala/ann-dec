package ly.qubit.annualdeclaration.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "family_member", schema = "pensioners", indexes = {
        @Index(name = "unique_family_member_national_number", columnList = "national_number", unique = true)
})
public class FamilyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "family_member_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pensioner_id", nullable = false)
    private Pensioner pensioner;

    @Column(name = "national_number", nullable = false, length = 12)
    private String nationalNumber;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "gender", nullable = false, length = 10)
    private String gender;

    @OneToOne(mappedBy = "familyMember")
    private Beneficiary beneficiary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pensioner getPensioner() {
        return pensioner;
    }

    public void setPensioner(Pensioner pensioner) {
        this.pensioner = pensioner;
    }

    public String getNationalNumber() {
        return nationalNumber;
    }

    public void setNationalNumber(String nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }

}