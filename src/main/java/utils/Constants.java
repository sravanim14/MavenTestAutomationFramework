package utils;

public class Constants {
    public static String url = "https://trello.com/";
    public static String appPath = "C:\\Windows\\System32\\calc.exe";
    public static String emailAddress = "";
    public static String password = "";
    public static String appiumURL = "http://0.0.0.0:4723/wd/hub";
    public static String mobileAppName = "deskclock";
    public static String mobileAppActivity = "deskclock.DeskClock"; //mobileAppName + activity, leave same as appName if there isn't and activity
    public static String phoneOSVersion = "13";
    public static String nameOfTester = System.getProperty("user.name"); //name that gets displayed on extent report
    public static String testType = ""; //set by runners
    public static String browser = "firefox"; //must be firefox or chrome
    public static boolean enable_browserstack = false;
    public static String BROWSERSTACK_USERNAME="tombotsford_fN5uoL";
    public static String BROWSERSTACK_ACCESS_KEY="TgN986jDUHkWpcS7HSB4";
    public static String BROWSERSTACK_URL="https://" + BROWSERSTACK_USERNAME + ":" + BROWSERSTACK_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

}
