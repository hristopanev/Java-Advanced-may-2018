package p02.salesDatabase.sales_db;

import javax.persistence.*;
import java.util.Date;

/*@Entity*/
@Table(name = "sales")
public class Sale {
    private Long id;
    private Product product;
    private Customer customer;
    private Location location;
    private Date date;

    public Sale(){}

    public Sale(Long id, Product product, Customer customer, Location location, Date date) {
        this.id = id;
        this.product = product;
        this.customer = customer;
        this.location = location;
        this.date = date;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(targetEntity = Product.class)
    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne(targetEntity = Customer.class)
    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne(targetEntity = Location.class)
    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Column(name = "date")
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
