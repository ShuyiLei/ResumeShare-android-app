package edu.brandeis.cs.shuyilei.resumeshare.beans;

/**
 * Created by shuyilei on 10/25/16.
 */
public class Experience {
    private String Account;
    private String Company;
    private String Position;

    private String Id;
    public String getId(){
        return this.Id;

    }
    public void setId(String Id){
        this.Id=Id;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }
}
