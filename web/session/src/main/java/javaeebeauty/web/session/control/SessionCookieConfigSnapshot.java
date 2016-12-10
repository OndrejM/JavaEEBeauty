package javaeebeauty.web.session.control;

import javax.servlet.SessionCookieConfig;

public class SessionCookieConfigSnapshot implements SessionCookieConfig {

    private String name;
    private String domain;
    private String path;
    private String comment;
    private Boolean httpOnly;
    private Boolean secure;
    private Integer maxAge;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isHttpOnly() {
        return httpOnly != null ? httpOnly : false;
    }

    public void setHttpOnly(boolean httpOnly) {
        this.httpOnly = httpOnly;
    }

    public boolean isSecure() {
        return secure != null ? secure : false;
    }

    public void setSecure(boolean secure) {
        this.secure = secure;
    }

    public int getMaxAge() {
        return maxAge != null ? maxAge : -1;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public boolean isHttpOnlySet() {
        return httpOnly != null;
    }
    
    public boolean isSecureSet() {
        return secure != null;
    }
    
    public boolean isMaxAgeSet() {
        return maxAge != null;
    }
}
