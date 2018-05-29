package mysqlConnect.dababasesClass;

public class User {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPasswwd() {
        return passwwd;
    }

    public void setPasswwd(String passwwd) {
        this.passwwd = passwwd;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    private String id;
    private String passwwd;
    private String flag;
}
