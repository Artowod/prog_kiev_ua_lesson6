package ua.prog.java.lesson6;

import java.io.File;

public class MonitorFolder implements Runnable {
	private String SourceFolderPatch;

	public MonitorFolder(String SourceFolderPatch) {
		this.SourceFolderPatch = SourceFolderPatch;
	}

	public MonitorFolder() {

	}

//	private File checkWhatWasChanged(File initialFolderState, File currentFolderState) {
//		for(String x: initialFolderState.list()) {
//			System.out.print(x + " ");
//
//		}
//		System.out.println();
//		
//		for(String y: currentFolderState.list()) {
//			System.out.print(y + " ");
//
//		}		
//		if (initialFolderState.list().length > currentFolderState.list().length) {
//			for(String fileCounter:initialFolderState.list() ) {
//				if(!currentFolderState.list().toString().contains(fileCounter)) {
//					System.out.println("--del--");
//					return new File(fileCounter);
//				}
//			}
//		} 		
//		if (currentFolderState.list().length > initialFolderState.list().length) {
//			for(String fileCounter:currentFolderState.list() ) {
//				if(!initialFolderState.list().toString().contains(fileCounter)) {
//					System.out.println("--add--");
//					return new File(fileCounter);
//				}
//			}
//		} 
//		return new File("C:\\temp\\My USB\\Falcon\\mf1.jpg"); /* will be changed */
//	}

	@Override
	public void run() {
		File monitoredFolder = new File(SourceFolderPatch);
		for (int i = 0; i < 100; i++) {
			File currentMonitoredFolder = new File(SourceFolderPatch);
			
			System.out.print("initial files list: < ");
			for(String x: monitoredFolder.list()) {
				System.out.print(x + " ");
			}
			System.out.println(">");
			
			System.out.print("current files list: < ");
			for(String y: currentMonitoredFolder.list()) {
				System.out.print(y + " ");
			}
			System.out.println(">\n--");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}			
			
//			System.out.println("<" + monitoredFolderLength + "," + currentMonitoredFolderLength + ">");
//			if (monitoredFolderLength < currentMonitoredFolderLength) {
//				System.out.println("\n Some file or folder has been added to the monitored folder.");
//				File changedObject = checkWhatWasChanged(newMonitoredFolder,currentMonitoredFolder);
//				System.out.println(changedObject.getName() + " has been added.");
			//	monitoredFolderLength = currentMonitoredFolderLength;
//			}
//			if (monitoredFolderLength > currentMonitoredFolderLength) {
//				System.out.println("\n Some file or folder has been deleted from the monitored folder.");
//				File changedObject = checkWhatWasChanged(newMonitoredFolder,currentMonitoredFolder);
//				System.out.println(changedObject.getName() + " has been deleted.");
			//	monitoredFolderLength = currentMonitoredFolderLength;
//			}
}
