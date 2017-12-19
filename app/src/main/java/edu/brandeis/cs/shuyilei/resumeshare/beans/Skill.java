package edu.brandeis.cs.shuyilei.resumeshare.beans;

/**
 * Created by shuyilei on 11/7/16.
 */

public class Skill {
    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getSkill() {
        return Skill;
    }

    public void setSkill(String skill) {
        Skill = skill;
    }

    private String Account;
    private String Skill;
    private String Id;
    public String getId(){
        return this.Id;

    }
    public void setId(String Id){
        this.Id=Id;
    }
}
