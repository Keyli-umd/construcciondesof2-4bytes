// =======================
// Invoice
// =======================
package app.domain.model;

import java.util.Date;

public class Invoice {
    private int id;
    private Date date;
    private double total;

    public Invoice() {}

    public Invoice(int id, Date date, double total) {
        this.id = id;
        this.date = date;
        this.total = total;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", date=" + date +
                ", total=" + total +
                '}';
    }
}


