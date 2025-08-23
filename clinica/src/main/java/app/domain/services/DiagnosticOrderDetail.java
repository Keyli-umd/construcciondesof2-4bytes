// =======================
// DiagnosticOrderDetail
// =======================
package app.domain.services;
public class DiagnosticOrderDetail extends OrderItem {
    private String examName;

    public DiagnosticOrderDetail() {}

    public DiagnosticOrderDetail(int id, String description, String examName) {
        super(id, description);
        this.examName = examName;
    }

    public String getExamName() { return examName; }
    public void setExamName(String examName) { this.examName = examName; }

    @Override
    public String toString() {
        return "DiagnosticOrderDetail{" +
                "id=" + getId() +
                ", description='" + getDescription() + '\'' +
                ", examName='" + examName + '\'' +
                '}';
    }
}
