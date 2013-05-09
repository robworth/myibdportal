package com.worthsoln.patientview.model;

import com.worthsoln.utils.LegacySpringUtils;
import org.apache.commons.lang.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.Date;

@Entity
public class User extends BaseModel {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private boolean emailverified;

    @Column(nullable = true)
    private boolean firstlogon;

    @Column(nullable = false)
    private boolean dummypatient;

    @Column(nullable = true)
    private Date lastlogon;

    @Column(nullable = true)
    private int failedlogons;

    @Column(nullable = true)
    private boolean accountlocked;

    @Column(nullable = false)
    private String screenname;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    @Transient
    // get the user's role in the currently selected tenancy
    public String getRole() {
        return LegacySpringUtils.getUserManager().getCurrentTenancyRole(this);
    }

    @Transient
    // get the user's first name from the name string, handles the case where name is like "joe ross chenery"
    public String getFirstName() {
        String firstName = "";

        if (StringUtils.isNotBlank(name)) {
            String[] names = name.split(" ");

            if (names.length > 0) {
                firstName = names[0];
            }
        }

        return firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmailverified() {
        return emailverified;
    }

    public void setEmailverified(boolean emailverified) {
        this.emailverified = emailverified;
    }

    public boolean isFirstlogon() {
        return firstlogon;
    }

    public void setFirstlogon(boolean firstlogon) {
        this.firstlogon = firstlogon;
    }

    public boolean isDummypatient() {
        return dummypatient;
    }

    public void setDummypatient(boolean dummypatient) {
        this.dummypatient = dummypatient;
    }

    public Date getLastlogon() {
        return lastlogon;
    }

    public void setLastlogon(Date lastlogon) {
        this.lastlogon = lastlogon;
    }

    public int getFailedlogons() {
        return failedlogons;
    }

    public void setFailedlogons(int failedlogons) {
        this.failedlogons = failedlogons;
    }

    public boolean isAccountlocked() {
        return accountlocked;
    }

    public void setAccountlocked(boolean accountlocked) {
        this.accountlocked = accountlocked;
    }

    public String getScreenname() {
        return screenname;
    }

    public void setScreenname(String screenname) {
        this.screenname = screenname;
    }
}
