package judgesystem.domain.entities;

import judgesystem.domain.entities.base.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "problems")
public class Problem extends BaseEntity {

    private String name;
    private Set<Submission> submissions;
    private Set<User> contestants;
    private Contest contest;
    private Set<MaxResultForProblem> maxResultForProblems;

    @Column
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "problem")
    public Set<Submission> getSubmissions() {
        return this.submissions;
    }

    public void setSubmissions(Set<Submission> submissions) {
        this.submissions = submissions;
    }

    @ManyToMany
    @JoinTable(
            name = "users_problems",
            joinColumns = @JoinColumn(name = "problem_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
    public Set<User> getContestants() {
        return this.contestants;
    }

    public void setContestants(Set<User> contestants) {
        this.contestants = contestants;
    }


    @ManyToOne
    public Contest getContest() {
        return this.contest;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }


    @OneToMany(mappedBy = "problem")
    public Set<MaxResultForProblem> getMaxResultForProblems() {
        return this.maxResultForProblems;
    }

    public void setMaxResultForProblems(Set<MaxResultForProblem> maxResultForProblems) {
        this.maxResultForProblems = maxResultForProblems;
    }
}
