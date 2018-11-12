package p01.gringottsDatabase;

import p01.gringottsDatabase.gringotts.WizardDeposit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("wizard_deposits");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        WizardDeposit wizardDeposit = new WizardDeposit();
        wizardDeposit.setFirst_name("Gesho");
        wizardDeposit.setLast_name("Geshev");
        wizardDeposit.setNotes("positiv");
        wizardDeposit.setAge(25);
        wizardDeposit.setMagic_wand_creator("Prl");
        wizardDeposit.setMagic_wand_size(10);
        wizardDeposit.setDeposit_group("WoW");
        wizardDeposit.setDeposit_start_date(new Date());
        wizardDeposit.setDeposit_amount(new BigDecimal(55.10));
        wizardDeposit.setDeposit_interest(new BigDecimal(10.2));
        wizardDeposit.setDeposit_charge(new BigDecimal(5.5));
        wizardDeposit.setDeposit_expiration_date(new Date(+ 20));
        wizardDeposit.setIs_deposit_expired(false);

        entityManager.persist(wizardDeposit);

        entityManager.getTransaction().commit();
    }
}
