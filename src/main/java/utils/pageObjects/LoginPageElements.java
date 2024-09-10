package utils.pageObjects;

public interface LoginPageElements {
    String loginText = "//h1[text()='Log in to Trello']";
    //String passwordScreenText = "//div[text()='Log in to continue to:']";
    String passwordScreenText = "//h5[text()='Log in to continue']";
    String emailField = "user";
    String passwordField = "password";
    String loginButtonUsername = "login";
    String loginButtonPassword = "login-submit";
}
