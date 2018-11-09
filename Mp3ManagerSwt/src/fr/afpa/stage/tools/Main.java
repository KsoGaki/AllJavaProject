package fr.afpa.stage.tools;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.TreeListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class Main {

	protected Shell shell;

	public List<File> fillFile(List<File> fileList) {
		File filesDirectory = new File("file");
		File[] filesArray = filesDirectory.listFiles();
		for(int i = 0; i < filesArray.length ; i++) {
			fileList.add(filesArray[i]);
		}
		return fileList;
	}

	public void open() {  // Open the window. 
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	protected void createContents() { // Create contents of the window.
		shell = new Shell();
		shell.setSize(950, 650);
		shell.setText("SWT Application");

		Tree tree = new Tree(shell, SWT.BORDER | SWT.MULTI);
		tree.setBounds(10, 10, 150, 590);
		List<File> fileList = new ArrayList<>();
		fileList = fillFile(fileList);
		for (int i = 0; i < fileList.size(); i++) {
			TreeItem item = new TreeItem(tree, SWT.NONE);
			item.setText((i + 1) +"- " + fileList.get(i).getName());
		}
		tree.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				char charAt = e.item.toString().split("\\{")[1].charAt(0);
				System.out.println(charAt);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
				
			}
		});

	}



	public static void main(String[] args) {
		try {
			Main window = new Main();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
