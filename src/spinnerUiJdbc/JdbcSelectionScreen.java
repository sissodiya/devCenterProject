package spinnerUiJdbc;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.widgets.Button;

public class JdbcSelectionScreen extends JdbcOracleConnection {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			JdbcSelectionScreen window = new JdbcSelectionScreen();
			window.open();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
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

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("microbiologyInstruments");
		
		Menu menuBar = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menuBar);
		
		 // Create the File item's dropdown menu
	    Menu fileMenu = new Menu(menuBar);

	    // Create all the items in the bar menu
	    MenuItem fileItem = new MenuItem(menuBar, SWT.CASCADE);
	    fileItem.setText("File");
	    fileItem.setMenu(fileMenu);

	    // Create all the items in the File dropdown menu
	    MenuItem newItem = new MenuItem(fileMenu, SWT.NONE);
	    newItem.setText("New");
	    MenuItem openItem = new MenuItem(fileMenu, SWT.NONE);
	    openItem.setText("Open...");
	    MenuItem saveItem = new MenuItem(fileMenu, SWT.NONE);
	    saveItem.setText("Save");
	    MenuItem saveAsItem = new MenuItem(fileMenu, SWT.NONE);
	    saveAsItem.setText("Save As...");

	    shell.setMenuBar(menuBar);
	    shell.open();
	    /*
	     * while (!shell.isDisposed()) {
	      if (!display.readAndDispatch()) {
	        display.sleep();
	      }
	    }
	     * */
		
		ListViewer listViewer = new ListViewer(shell, SWT.BORDER | SWT.V_SCROLL);
		List list = listViewer.getList();
		list.setBounds(10, 61, 408, 143);
		
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(299, 10, 119, 35);
		btnNewButton.setText("executeQuery");
		btnNewButton.addListener(SWT.Selection, (Listener) new Listener() {
		      public void handleEvent(Event e) {
		        switch (e.type) {
		        case SWT.Selection:
		          System.out.println("Query In Execution");
		          
		          JdbcOracleConnection jdbcOC = new JdbcOracleConnection();
					jdbcOC.databaseAction();
		          
					break;
		        }
		      }
		    });
	}
}
