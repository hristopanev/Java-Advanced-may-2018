package Vlog;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Vlogger {
    private String name;
    private Set<Vlogger> followers;
    private Set<Vlogger> following;

    public Vlogger(String name) {
        this.name = name;
        this.followers = new HashSet<>();
        this.following = new HashSet<>();
    }

    public void follow(Vlogger v){
        if (v == this){return;}
        this.followers.add(v);
    }

    public void addFollowing(Vlogger v){
        if (v == this){return;}
        this.following.add(v);
    }

    public String getName() {
        return this.name;
    }

    public int getFollowerCount(){
        return this.followers.size();
    }

    public int getFollowingCount(){
        return this.following.size();
    }


    public String toFullString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The V-Logger has a total of %d vloggers in its logs.",
                this.getFollowerCount()))
                .append(System.lineSeparator());
        sb.append(this.toBasicString()).append(System.lineSeparator());

        List<Vlogger> sortedFollowers = this.followers
                .stream()
                .sorted((f, s ) -> f.getName().compareTo(s.getName()))
                .collect(Collectors.toList());
        for (Vlogger follower : sortedFollowers) {
            sb.append("*  ").append(follower.getName()).append(System.lineSeparator());
        }

        return  sb.toString();
    }

    public String toBasicString() {
        return String.format("%s : %d followers, %s following",
                this.name, this.getFollowerCount(), this.getFollowingCount());
    }
}
