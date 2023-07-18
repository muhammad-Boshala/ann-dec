package ly.qubit.annualdeclaration.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link ly.qubit.annualdeclaration.model.AnnualDeclaration}
 */
public class ReviewRequest implements Serializable {
    private final Integer id;
    private final String status;

    public ReviewRequest(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewRequest entity = (ReviewRequest) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.status, entity.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "status = " + status + ")";
    }
}