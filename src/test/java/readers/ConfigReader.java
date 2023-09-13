package readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.BrowserType;

public class ConfigReader {

	private static Properties properties;
	private final String propertyFilePath = "src/test/resources/configs/Configuration.properties";

	public ConfigReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public BrowserType getBrowserType() {
		String browserName = properties.getProperty("browserType");

		if (browserName == null || browserName.equals("chrome"))
			return BrowserType.CHROME;

		else if (browserName.equalsIgnoreCase("firefox"))
			return BrowserType.FIREFOX;

		else if (browserName.equals("edge"))
			return BrowserType.EDGE;

		else
			throw new RuntimeException(
					"Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}

	public long getImplicitWait() {
		String implicitlyWait = properties.getProperty("implicitWait");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
	}

	public String getExcelPath() {
		String path = properties.getProperty("excelPath");
		if (path != null)
			return path;
		else
			throw new RuntimeException("excelPath not specified in the Configuration.properties file.");
	}

	public String getApplicationUrl() {
		String path = properties.getProperty("appUrl");
		if (path != null)
			return path;
		else
			throw new RuntimeException("appUrl not specified in the Configuration.properties file.");
	}

	// Home Page

	public String getHomePageTitle() {
		String path = properties.getProperty("homePageTitle");
		if (path != null)
			return path;
		else
			throw new RuntimeException("homePageTitle not specified in the Configuration.properties file.");
	}

	// Login Page

	public String getLoginPageTitle() {
		String path = properties.getProperty("loginPageTitle");
		if (path != null)
			return path;
		else
			throw new RuntimeException("loginPageTitle not specified in the Configuration.properties file.");
	}

	public String getLoginPageHeader() {
		String path = properties.getProperty("loginPageHeader");
		if (path != null)
			return path;
		else
			throw new RuntimeException("loginPageHeader not specified in the Configuration.properties file.");
	}

	public String getUsernameDefaultText() {
		String path = properties.getProperty("userNameDefaultText");
		if (path != null)
			return path;
		else
			throw new RuntimeException("userNameDefaultText not specified in the Configuration.properties file.");
	}

	public String getPasswordDefaultText() {
		String path = properties.getProperty("passwordDefaultText");
		if (path != null)
			return path;
		else
			throw new RuntimeException("passwordDefaultText not specified in the Configuration.properties file.");
	}

	public String getTextFieldFintColor() {
		String path = properties.getProperty("defaultTextFontColor");
		if (path != null)
			return path;
		else
			throw new RuntimeException("defaultTextFontColor not specified in the Configuration.properties file.");
	}

	public String getStudentPageTitle() {
		String title = properties.getProperty("studentPageTitle");
		if (title != null)
			return title;
		else
			throw new RuntimeException("getstudentpage title is not speicified in the configuration file");

	}

	public String getDashBoardTitle() {
		String path = properties.getProperty(getDashBoardTitle());
		if (path != null)
			return path;
		else
			throw new RuntimeException("getstudentpage title is not speicified in the configuration file");

	}

	public String getProgramPageURL() {
		String path = properties.getProperty("programPageUrl");
		if (path != null)
			return path;
		else
			throw new RuntimeException("ProgramUrl not specified in the Configuration.properties file.");
	}

	public String getBatchPageURL() {
		String path = properties.getProperty("batchPageUrl");
		if (path != null)
			return path;
		else
			throw new RuntimeException("BatchURl not specified in the Configuration.properties file.");
	}

	public String getClassPageURL() {
		String path = properties.getProperty("classPageUrl");
		if (path != null)
			return path;
		else
			throw new RuntimeException("classURl not specified in the Configuration.properties file.");
	}

	public String getUserPageURL() {
		String path = properties.getProperty("userPageUrl");
		if (path != null)
			return path;
		else
			throw new RuntimeException("UserURl not specified in the Configuration.properties file.");
	}
	public String getAdminURL() {
		String path = properties.getProperty("adminPageUrl");
		if (path != null)
			return path;
		else
			throw new RuntimeException("adminURl not specified in the Configuration.properties file.");
	}
	public String getAttendanceURL() {
		String path = properties.getProperty("attendancePageURl");
		if (path != null)
			return path;
		else
			throw new RuntimeException("attendance not specified in the Configuration.properties file.");
	}
	public String getLogoutURL() {
		String path = properties.getProperty("logoutPageUrl");
		if (path != null)
			return path;
		else
			throw new RuntimeException("logout url not specified in the Configuration.properties file.");
	}
}
