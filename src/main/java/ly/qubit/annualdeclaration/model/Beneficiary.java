package ly.qubit.annualdeclaration.model;

import jakarta.persistence.*;

@Entity
@Table(name = "beneficiary", schema = "pensioners")
public class Beneficiary {
    @Id
    @Column(name = "family_member_id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "family_member_id", nullable = false)
    private FamilyMember familyMember;

    @Column(name = "entitlement_type", nullable = false, length = 100)
    private String entitlementType;

    @Column(name = "entitlement_details", length = Integer.MAX_VALUE)
    private String entitlementDetails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FamilyMember getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(FamilyMember familyMember) {
        this.familyMember = familyMember;
    }

    public String getEntitlementType() {
        return entitlementType;
    }

    public void setEntitlementType(String entitlementType) {
        this.entitlementType = entitlementType;
    }

    public String getEntitlementDetails() {
        return entitlementDetails;
    }

    public void setEntitlementDetails(String entitlementDetails) {
        this.entitlementDetails = entitlementDetails;
    }

}