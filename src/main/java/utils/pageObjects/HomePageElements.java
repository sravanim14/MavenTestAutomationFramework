package utils.pageObjects;

public interface HomePageElements {

    String signInButton = "//a[@href='/login' and text()='Log in' and contains(@data-uuid,'login')]";
    String mobileMenuButton = "//button[@data-testid='menubutton']";
    String mobileSignInButton = "//a[@href='/login' and text()='Log in' and contains(@class,'SmallNavstyles')]";

}
