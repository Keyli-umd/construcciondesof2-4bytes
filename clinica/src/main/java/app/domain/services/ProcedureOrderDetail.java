// =======================
// ProcedureOrderDetail
// =======================
package app.domain.services;
public class ProcedureOrderDetail extends OrderItem {
    private String procedureName;

    public ProcedureOrderDetail() {}

    public ProcedureOrderDetail(int id, String description, String procedureName) {
        super(id, description);
        this.procedureName = procedureName;
    }

    public String getProcedureName() { return procedureName; }
    public void setProcedureName(String procedureName) { this.procedureName = procedureName; }

    @Override
    public String toString() {
        return "ProcedureOrderDetail{" +
                "id=" + getId() +
                ", description='" + getDescription() + '\'' +
                ", procedureName='" + procedureName + '\'' +
                '}';
    }
}
