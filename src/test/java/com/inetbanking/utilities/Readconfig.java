package com.inetbanking.utilities;

import java.io.FileInputStream;

import java.util.Properties;

public class Readconfig {

	Properties pro;

	public Readconfig() {
		try {

			FileInputStream fis = new FileInputStream("./Configuration/config.properties");
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String geturl() {
		return pro.getProperty("url");
	}

	public String username() {
		return pro.getProperty("username");
	}

	public String password() {
		return pro.getProperty("password");
	}

	public String chromepath() {
		return pro.getProperty("chromepath");
	}

	public String firefoxpath() {
		return pro.getProperty("firefoxpath");
	}

	public String iepath() {
		return pro.getProperty("iepath");
	}
}
