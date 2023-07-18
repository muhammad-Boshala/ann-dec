package ly.qubit.annualdeclaration.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for {@link ly.qubit.annualdeclaration.model.FamilyMember}
 */
public class FamilyMemberDto implements Serializable {
    private final String nationalNumber;
    private final String name;
    private final String motherName;
    private final Kinship kinship;
    private String maritalStatus;
    private String financialSituation;

    //for admin
    private boolean accepted;


    public FamilyMemberDto(String nationalNumber, String name, String motherName, Kinship kinship, String maritalStatus, String financialSituation) {
        this.nationalNumber = nationalNumber;
        this.name = name;
        this.motherName = motherName;
        this.kinship = kinship;
        this.maritalStatus = maritalStatus;
        this.financialSituation = financialSituation;

    }

    public String getNationalNumber() {
        return nationalNumber;
    }

    public String getName() {
        return name;
    }

    public Kinship getKinship() {
        return kinship;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }
    public String getFinancialSituation() {
        return financialSituation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyMemberDto entity = (FamilyMemberDto) o;
        return Objects.equals(this.nationalNumber, entity.nationalNumber) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.motherName, entity.motherName) &&
                Objects.equals(this.financialSituation, entity.financialSituation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nationalNumber, name, motherName, maritalStatus,financialSituation);
    }

    @Override
    public String toString() {
        return "FamilyMemberDto{" +
                "nationalNumber='" + nationalNumber + '\'' +
                ", name='" + name + '\'' +
                ", motherName='" + motherName + '\'' +
                ", kinship=" + kinship +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", financialSituation='" + financialSituation + '\'' +
                '}';
    }
}