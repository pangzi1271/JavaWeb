public class Users {

    private int userID;
    private String userName;
    private String password;
    private String sex;
    private String email;

    public Users() {
    }

    public Users(String userName, String password, String sex, String email) {
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.email = email;
    }

    public Users(Integer userID, String userName, String password, String sex, String email) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.email = email;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
