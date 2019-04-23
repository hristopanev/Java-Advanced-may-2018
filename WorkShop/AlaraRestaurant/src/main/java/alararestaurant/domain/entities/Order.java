package alararestaurant.domain.entities;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "orders")
public class Order extends BaseEntity {

    private String customer;
    private LocalDate dateTIme;
    private TypeEnum type;
    private Employee employee;
    private Set<OrderItem> orderItems;

    public Order() {
    }


    @Column(name = "customer", columnDefinition = "TEXT", nullable = false)
    public String getCustomer() {
        return this.customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Column(name = "date_time", columnDefinition = "DATETIME", nullable = false)
    public LocalDate getDateTIme() {
        return this.dateTIme;
    }

    public void setDateTIme(LocalDate dateTIme) {
        this.dateTIme = dateTIme;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "type", columnDefinition = "ENUM('ForHere, ToGo')", nullable = false)
    public TypeEnum getType() {
        return this.type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(
            name = "employee_id", referencedColumnName = "id", nullable = false
    )
    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @OneToMany(targetEntity = OrderItem.class, mappedBy = "order")
    public Set<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
