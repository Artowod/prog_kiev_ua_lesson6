package ua.prog.java.lesson6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class FileOperation {

	public FileOperation() {

	}

	private File[] filesList(String sourceFolderPath) {
		File folder = new File(sourceFolderPath);
		File[] filesList = folder.listFiles();
		for (File file : filesList) {
			// System.out.println(file);
			// System.out.println(file.getName());
		}
		return filesList;
	}

	public void copyFiles(String sourceFolderPath, String DestinationFolderPatch, int threadsQuantity) {
		File[] filesListSourceFolder = filesList(sourceFolderPath);
		
//		for()
			CopyFiles instanceOfCopyFiles = new CopyFiles(filesListSourceFolder, DestinationFolderPatch);
			Thread copyFilesThread = new Thread(new Thread(instanceOfCopyFiles));
			
			
		
		
		for (File sourceFile : filesListSourceFolder) {
			try (FileInputStream fis = new FileInputStream(sourceFile.getAbsolutePath());
					FileOutputStream fos = new FileOutputStream(DestinationFolderPatch + "/" + sourceFile.getName())) {
				byte[] bufer = new byte[1024];
				int byteread = 0;
				for (; (byteread = fis.read(bufer)) > 0;) {
					fos.write(bufer, 0, byteread);
				}
			} catch (IOException e) {
				System.out.println("Something wrong with CopyFiles " + e);
			}

		}

	}

}
