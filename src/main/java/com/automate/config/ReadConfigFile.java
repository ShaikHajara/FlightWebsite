package com.automate.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {

	public Properties prop;
	public FileInputStream fis;
	public String geckodriverPath;
	public String chromedriverPath;
	public String drivername;

	public String getDriverPath(String drivername) {
		getProperties();
		this.drivername = drivername;
		if (drivername.equals("geckodriver")) {
			geckodriverPath = prop.getProperty("geckodriver");
			System.out.println(geckodriverPath);
			return geckodriverPath;
		} else if (drivername.equals("chromedriver")) {
			chromedriverPath = prop.getProperty("chromedriver");
		}
		System.out.println(chromedriverPath);
		return chromedriverPath;
	}

	public void getProperties() {

		try {
			fis = new FileInputStream(
					"C:\\Users\\Shaik.Hajara\\eclipse-workspace\\Flight\\src\\main\\resources\\config\\config.properties");
		} catch (final FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fis);
			fis.close();
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getUrl() {
		getProperties();
		final String url = prop.getProperty("url");
		return url;

	}
}
