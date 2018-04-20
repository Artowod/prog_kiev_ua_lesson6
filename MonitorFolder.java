package ua.prog.java.lesson6;

import java.io.File;

public class MonitorFolder implements Runnable {
	private String SourceFolderPatch;

	public MonitorFolder(String SourceFolderPatch) {
		this.SourceFolderPatch = SourceFolderPatch;
	}

	public MonitorFolder() {

	}

	private void checkWhatWasChanged(String[] initialFolderState, String[] currentFolderState) {
		if (initialFolderState.length > currentFolderState.length) {
			for (String fileCounterLongerFilesList : initialFolderState) {
				if (!String.join("", currentFolderState).contains(fileCounterLongerFilesList)) {
					System.out.println(fileCounterLongerFilesList + " has been deleted.");
					break;
				}
			}
		}
		if (currentFolderState.length > initialFolderState.length) {
			for (String fileCounterLongerFilesList : currentFolderState) {
				if (!String.join("", initialFolderState).contains(fileCounterLongerFilesList)) {
					System.out.println(fileCounterLongerFilesList + " has been added.");
					break;
				}
			}
		}
	}

	@Override
	public void run() {
		File monitoredFolder = new File(SourceFolderPatch);
		String[] initialFilesList = monitoredFolder.list();
		for (int i = 0; i < 100; i++) {
			String[] currentFilesList = monitoredFolder.list();
			if (initialFilesList.length != currentFilesList.length) {
				checkWhatWasChanged(initialFilesList, currentFilesList);
				initialFilesList = currentFilesList;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
