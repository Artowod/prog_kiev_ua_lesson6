package ua.prog.java.lesson6;

import java.io.File;
import java.util.Scanner;

public class FileOperation {

	public FileOperation() {

	}

	private File[] filesList(String sourceFolderPath) {
		File folder = new File(sourceFolderPath);
		File[] filesList = folder.listFiles();
//		for (File file : filesList) {
//			 System.out.println(file);
//			 System.out.println(file.getName());
//		}
		return filesList;
	}

	public void copyFiles(String sourceFolderPath, String DestinationFolderPatch, int threadsQuantity) {
		File[] filesListSourceFolder = filesList(sourceFolderPath);
		Thread[] copyFilesThreadsArray = new Thread[threadsQuantity];
		for (int i = 0; i < threadsQuantity; i++) {
			CopyFiles instanceOfCopyFiles = new CopyFiles(filesListSourceFolder, DestinationFolderPatch);
			Thread copyFilesThread = new Thread(new Thread(instanceOfCopyFiles));
			copyFilesThreadsArray[i] = copyFilesThread;
			copyFilesThread.start();
		}
		for (int i = 0; i < threadsQuantity; i++) {
			try {
				copyFilesThreadsArray[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Copy of files has been completed!");
	}

	public void folderMonitor(String sourceFolderPath) {
		MonitorFolder instanceOfCopyFiles = new MonitorFolder(sourceFolderPath);
		Thread monitorFolderThread = new Thread(new Thread(instanceOfCopyFiles));
		monitorFolderThread.setDaemon(true);
		monitorFolderThread.start();
		
		System.out.println("the defined catalogue is being monitored now ...");
		System.out.println("to initiate the Exit please press 0 ");
		for (;;) {
			Scanner in = new Scanner(System.in);
			if (in.nextLine().equals("0")) {
				break;
			}
		}
		System.out.println("End.");
	}

}
