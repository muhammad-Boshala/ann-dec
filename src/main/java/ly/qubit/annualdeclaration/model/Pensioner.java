package ly.qubit.annualdeclaration.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "pensioner", schema = "pensioners", indexes = {
        @Index(name = "unique_national_number", columnList = "national_number", unique = true)
})
public class Pensioner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pensioner_id", nullable = false)
    private Integer id;

    @Column(name = "national_number", nullable = false, length = 12)
    private String nationalNumber;

    @Column(name = "pension_number", nullable = false, length = 10)
    private String pensionNumber;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "address", nullable = false, length = 200)
    private String address;

    @OneToMany(mappedBy = "pensioner")
    private Set<AnnualDeclaration> annualDeclarations = new LinkedHashSet<>();

    @OneToMany(mappedBy = "pensioner")
    private Set<FamilyMember> familyMembers = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNationalNumber() {
        return nationalNumber;
    }

    public void setNationalNumber(String nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    public String getPensionNumber() {
        return pensionNumber;
    }

    public void setPensionNumber(String pensionNumber) {
        this.pensionNumber = pensionNumber;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<AnnualDeclaration> getAnnualDeclarations() {
        return annualDeclarations;
    }

    public void setAnnualDeclarations(Set<AnnualDeclaration> annualDeclarations) {
        this.annualDeclarations = annualDeclarations;
    }

    public Set<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(Set<FamilyMember> familyMembers) {
        this.familyMembers = familyMembers;
    }

}