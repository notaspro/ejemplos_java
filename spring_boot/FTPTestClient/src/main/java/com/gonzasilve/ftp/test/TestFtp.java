package com.gonzasilve.ftp.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class TestFtp {

	// new ftp client
	FTPClient ftp;
	String serverAddress = "";
	String userId = "";
	String password = "";
	//String remoteDirectory = "/home/gonzasilve/test/ftp_uploads";
	String remoteDirectory = "";
	String localDirectory = "";

	public static String REMOTE_SERVER_ADREESS = "remoteServerAdress";
	public static String REMOTE_SERVER_USER_ID = "remoteServerUserId";
	public static String REMOTE_SERVER_PASSWORD = "remoteServerPassword";
	public static String REMOTE_SERVER_DIRECTORY = "remoteServerDirectory";
	public static String LOCAL_SERVER_DIRECTORY = "localServerDirectory";

	private static Properties properties;

	public TestFtp() {

	}

	public void testFtp() {
		properties = new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("properties == null: "+(properties == null));
		
		serverAddress = properties.getProperty(REMOTE_SERVER_ADREESS).trim();
		userId = properties.getProperty(REMOTE_SERVER_USER_ID).trim();
		password = properties.getProperty(REMOTE_SERVER_PASSWORD).trim();
		remoteDirectory = properties.getProperty(REMOTE_SERVER_DIRECTORY).trim();
		localDirectory = properties.getProperty(LOCAL_SERVER_DIRECTORY);
		try {

			ftp = new FTPClient();
			// try to connect
			ftp.connect(serverAddress);
			// login to server
			if (!ftp.login(userId, password)) {
				ftp.logout();

			}
			int reply = ftp.getReplyCode();
			// FTPReply stores a set of constants for FTP reply codes.
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
			}

			// enter passive mode
			ftp.enterLocalPassiveMode();
			System.out.println(
					"ftp.getDefaultPort(): " + ftp.getDefaultPort() + ", ftp.getRemotePort()): " + ftp.getRemotePort());
			// get system name
			System.out.println("Remote system is " + ftp.getSystemType());
			// change current directory
			System.out.println("Current directory is " + ftp.printWorkingDirectory());
			System.out.println();

			// ---------------------------
			ftp.changeWorkingDirectory(remoteDirectory);

			
			String nameNewFolderBackup = remoteDirectory + "/newDirectory";
			System.out.println("Se creara el directorio remoto: "+nameNewFolderBackup);
			
			boolean folderBackupCreated = ftp.makeDirectory(nameNewFolderBackup);
			if (folderBackupCreated) {
				System.out.println("OK!");
				ftp.changeWorkingDirectory(nameNewFolderBackup);
			}

			String localNewFile = localDirectory + "\\test.txt";
			System.out.println("Se transferira el archivo: "+localNewFile);
			File file = new File(localNewFile);

			String fullPathRemote = nameNewFolderBackup + "/" + file.getName();
			InputStream input = new FileInputStream(file);
			boolean resBackup = this.ftp.storeFile(fullPathRemote, input);
			System.out.println("OK!");
			input.close();

			ftp.logout();
			ftp.disconnect();
			System.out.println("Test de Ftp completado.");
		} catch (Exception ex) {
			System.out.println("Excepcion!");
			ex.printStackTrace();
		}
	}
}
