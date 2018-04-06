package ua.prog.java.lesson6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFiles implements Runnable {
	private File[] filesListSourceFolder;
	private String DestinationFolderPatch;
	
	public CopyFiles(File[] filesListSourceFolder, String DestinationFolderPatch) {
		this.filesListSourceFolder = filesListSourceFolder;
		this.DestinationFolderPatch = DestinationFolderPatch;
	}

	public CopyFiles() {

	}

	@Override
	public void run() {
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
