package utils.pageObjects;

public interface DashboardPageElements {

    String navBar = "header";
    String accountDropdown = "//button[@data-testid='header-member-menu-button']";
    String settingsButton = "//a[@data-testid='account-menu-settings']";
    String createBoardButton = "//li[@data-testid='create-board-tile']";
    String createBoardButtonMobile = "//*[@id=\"content\"]/div/div[2]/div/div/div/div/div[2]/div/div/div/div[2]/div[1]/div[2]/ul/li[6]/div";
    String boardTitleField = "//input[@data-testid='create-board-title-input']";
    String confirmCreateBoardButton = "//button[@data-testid='create-board-submit-button']";
}
