package utils;

import pageEvents.*;

public final class PageBuilder {

    public static pageEvents.BoardPageEvents boardPageEvents;
    public static pageEvents.CalculatorEvents calculatorEvents;
    public static pageEvents.ClockAppEvents clockAppEvents;
    public static pageEvents.DashboardPageEvents dashboardPageEvents;
    public static pageEvents.HomePageEvents homePageEvents;
    public static pageEvents.LoginPageEvents loginPageEvents;
    public static pageEvents.SettingsPageEvents settingsPageEvents;
    public static pageEvents.ZippopotamusEvents zippopotamusEvents;


    static
    {
        buildPages();
    }

    private static void buildPages()
    {
        boardPageEvents = new pageEvents.BoardPageEvents();
        calculatorEvents = new pageEvents.CalculatorEvents();
        clockAppEvents = new pageEvents.ClockAppEvents();
        dashboardPageEvents = new pageEvents.DashboardPageEvents();
        homePageEvents = new pageEvents.HomePageEvents();
        loginPageEvents = new pageEvents.LoginPageEvents();
        settingsPageEvents = new pageEvents.SettingsPageEvents();
        zippopotamusEvents = new pageEvents.ZippopotamusEvents();
    }

}
