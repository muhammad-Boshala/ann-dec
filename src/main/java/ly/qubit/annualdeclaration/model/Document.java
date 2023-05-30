package ly.qubit.annualdeclaration.model;

import jakarta.persistence.*;

@Entity
@Table(name = "document", schema = "pensioners")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "declaration_id", nullable = false)
    private AnnualDeclaration declaration;

    @Column(name = "file_name", nullable = false, length = 200)
    private String fileName;

    @Column(name = "file_path", nullable = false, length = 200)
    private String filePath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AnnualDeclaration getDeclaration() {
        return declaration;
    }

    public void setDeclaration(AnnualDeclaration declaration) {
        this.declaration = declaration;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}