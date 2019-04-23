package judgesystem.domain.entities;

import judgesystem.domain.entities.base.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "users")
public class User extends BaseEntity {

    private String name;
    private Set<Submission> submissions;
    private Set<MaxResultForContest> maxResultForContests;
    private Set<MaxResultForProblem> maxResultForProblems;
    private Set<Contest> contests;
    private Set<Problem> problems;

    @Column(unique = true)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @OneToMany(mappedBy = "user")
    public Set<Submission> getSubmissions() {
        return this.submissions;
    }

    public void setSubmissions(Set<Submission> submissions) {
        this.submissions = submissions;
    }

    @OneToMany(mappedBy = "user")
    public Set<MaxResultForContest> getMaxResultForContests() {
        return this.maxResultForContests;
    }

    public void setMaxResultForContests(Set<MaxResultForContest> maxResultForContests) {
        this.maxResultForContests = maxResultForContests;
    }

    @OneToMany(mappedBy = "user")
    public Set<MaxResultForProblem> getMaxResultForProblems() {
        return this.maxResultForProblems;
    }

    public void setMaxResultForProblems(Set<MaxResultForProblem> maxResultForProblems) {
        this.maxResultForProblems = maxResultForProblems;
    }

    @ManyToMany()
    @JoinTable(
            name = "users_contests",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "contest_id", referencedColumnName = "id")
    )
    public Set<Contest> getContests() {
        return this.contests;
    }

    public void setContests(Set<Contest> contests) {
        this.contests = contests;
    }

    @ManyToMany()
    @JoinTable(
            name = "users_problems",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "problem_id", referencedColumnName = "id")
    )
    public Set<Problem> getProblems() {
        return this.problems;
    }

    public void setProblems(Set<Problem> problems) {
        this.problems = problems;
    }
}
