package p01.gringottsDatabase.gringotts;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/*@Entity(name = "wizard_deposits")*/
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class WizardDeposit {
    private int id;
    private String first_name;
    private String last_name;
    private String notes;
    private int age;
    private String magic_wand_creator;
    private int magic_wand_size;
    private String  deposit_group;
    private Date deposit_start_date;
    private BigDecimal deposit_amount;
    private BigDecimal deposit_interest;
    private BigDecimal deposit_charge;
    private Date deposit_expiration_date;
    private boolean is_deposit_expired;

    public  WizardDeposit(){}

    public WizardDeposit(int id, String first_name, String last_name, String notes, int age, String magic_wand_creator, int magic_wand_size, String deposit_group, Date deposit_start_date, BigDecimal deposit_amount, BigDecimal deposit_interest, BigDecimal deposit_charge, Date deposit_expiration_date, boolean is_deposit_expired) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.notes = notes;
        this.age = age;
        this.magic_wand_creator = magic_wand_creator;
        this.magic_wand_size = magic_wand_size;
        this.deposit_group = deposit_group;
        this.deposit_start_date = deposit_start_date;
        this.deposit_amount = deposit_amount;
        this.deposit_interest = deposit_interest;
        this.deposit_charge = deposit_charge;
        this.deposit_expiration_date = deposit_expiration_date;
        this.is_deposit_expired = is_deposit_expired;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "first_name", length = 50)
    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @Column(name = "last_name", length = 60)
    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Column(name = "notes", length = 1000)
    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Basic(optional = false)
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "magic_wand_creator", length = 100)
    public String getMagic_wand_creator() {
        return this.magic_wand_creator;
    }

    public void setMagic_wand_creator(String magic_wand_creator) {
        this.magic_wand_creator = magic_wand_creator;
    }

    @Column(name = "magic_wand_size")
    public int getMagic_wand_size() {
        return this.magic_wand_size;
    }

    public void setMagic_wand_size(int magic_wand_size) {
        this.magic_wand_size = magic_wand_size;
    }

    @Column(name = "deposit_group", length = 20)
    public String getDeposit_group() {
        return this.deposit_group;
    }

    public void setDeposit_group(String deposit_group) {
        this.deposit_group = deposit_group;
    }

    @Column(name = "deposit_start_date")
    public Date getDeposit_start_date() {
        return this.deposit_start_date;
    }

    public void setDeposit_start_date(Date deposit_start_date) {
        this.deposit_start_date = deposit_start_date;
    }
    @Column(name = "deposit_amount")
    public BigDecimal getDeposit_amount() {
        return this.deposit_amount;
    }

    public void setDeposit_amount(BigDecimal deposit_amount) {
        this.deposit_amount = deposit_amount;
    }

    @Column(name = "deposit_interest")
    public BigDecimal getDeposit_interest() {
        return this.deposit_interest;
    }

    public void setDeposit_interest(BigDecimal deposit_interest) {
        this.deposit_interest = deposit_interest;
    }

    @Column(name = "deposit_charge")
    public BigDecimal getDeposit_charge() {
        return this.deposit_charge;
    }

    public void setDeposit_charge(BigDecimal deposit_charge) {
        this.deposit_charge = deposit_charge;
    }

    @Column(name = "deposit_expiration_date")
    public Date getDeposit_expiration_date() {
        return this.deposit_expiration_date;
    }

    public void setDeposit_expiration_date(Date deposit_expiration_date) {
        this.deposit_expiration_date = deposit_expiration_date;
    }

    @Column(name = "is_deposit_expired")
    public boolean isIs_deposit_expired() {
        return this.is_deposit_expired;
    }

    public void setIs_deposit_expired(boolean is_deposit_expired) {
        this.is_deposit_expired = is_deposit_expired;
    }
}
