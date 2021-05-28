package Trees;

public abstract class Account {
    private String userName;
    private String password;


    public abstract boolean resetPassword();
}

 abstract class Admin extends Account {
    public boolean addExitPanel(String exitPanel) {
        return false;
    }
}