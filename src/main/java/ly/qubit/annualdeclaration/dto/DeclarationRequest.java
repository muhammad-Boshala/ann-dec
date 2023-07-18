package ly.qubit.annualdeclaration.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link ly.qubit.annualdeclaration.model.AnnualDeclaration}
 */
public class DeclarationRequest implements Serializable {
    private final LocalDate submissionDate;
    private final Set<DocumentDto> documents;
    private Set<FamilyMemberDto> familyMembers;

    public DeclarationRequest(LocalDate submissionDate, Set<DocumentDto> documents, Set<FamilyMemberDto> familyMembers) {
        this.submissionDate = submissionDate;
        this.documents = documents;
        this.familyMembers = familyMembers;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public Set<DocumentDto> getDocuments() {
        return documents;
    }

    public Set<FamilyMemberDto> getFamilyMembers() {
        return familyMembers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeclarationRequest entity = (DeclarationRequest) o;
        return Objects.equals(this.submissionDate, entity.submissionDate) &&
                Objects.equals(this.documents, entity.documents)
                && Objects.equals(this.familyMembers, entity.familyMembers)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(submissionDate, documents, familyMembers);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "submissionDate = " + submissionDate + ", " +
                "familyMembers = " + familyMembers + ", " +
                "documents = " + documents + ")";
    }

    /**
     * DTO for {@link ly.qubit.annualdeclaration.model.Document}
     */
    public static class DocumentDto implements Serializable {
        private final String fileName;
        private final String filePath;

        public DocumentDto(String fileName, String filePath) {
            this.fileName = fileName;
            this.filePath = filePath;
        }

        public String getFileName() {
            return fileName;
        }

        public String getFilePath() {
            return filePath;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DocumentDto entity = (DocumentDto) o;
            return Objects.equals(this.fileName, entity.fileName) &&
                    Objects.equals(this.filePath, entity.filePath);
        }

        @Override
        public int hashCode() {
            return Objects.hash(fileName, filePath);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "fileName = " + fileName + ", " +
                    "filePath = " + filePath + ")";
        }
    }
}