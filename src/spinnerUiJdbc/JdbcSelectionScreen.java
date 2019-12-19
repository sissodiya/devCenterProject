package spinnerUiJdbc;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;

import java.util.Arrays;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Button;

import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.List;

public class JdbcSelectionScreen extends JdbcOracleConnection{
	
	
	protected Shell shell;
	 JdbcOracleConnection jdbcOC = new JdbcOracleConnection();
	 
	int i=0;
	
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
		shell.setText("microbiologyInstrumentsStats");
		shell.setLayout(new FormLayout());
		
		Menu menuBar = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menuBar);
		
		 // Create the File item's drop down menu
	    Menu fileMenu = new Menu(menuBar);

	    // Create all the items in the bar menu
	    MenuItem fileItem = new MenuItem(menuBar, SWT.CASCADE);
	    fileItem.setText("File");
	    fileItem.setMenu(fileMenu);

	    // Create all the items in the File drop down menu
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
	    
	    List list = new List(shell, SWT.DROP_DOWN);
		
	    Button btnNewButton = new Button(shell, SWT.NONE);

		btnNewButton.addListener(SWT.Selection, (Listener) new Listener() {
		      public void handleEvent(Event e) {
		        switch (e.type) {
		        case SWT.Selection:
		          System.out.println("Query In Execution");
		          
		        //Calling databaseAction() through a JdbcOracleConnection object |jdbcOC|
		          
		          jdbcOC.databaseAction();
				 
		          
					System.out.println(jdbcOC.rsInstName.toString());
					int instArrayLength = jdbcOC.resultSetSize;
					
					for (int loopIndex = 0; loopIndex < instArrayLength; loopIndex++) {
					      list.add(jdbcOC.instrumetNameArrayFinal[loopIndex]);
					    }

		          break;
		        }
		      }
		    });
		
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.right = new FormAttachment(100, -10);
		fd_btnNewButton.top = new FormAttachment(0);
		btnNewButton.setLayoutData(fd_btnNewButton);
		btnNewButton.setText("executeQuery");
		
		FormData fd_list = new FormData();
		fd_list.bottom = new FormAttachment(btnNewButton, 0, SWT.BOTTOM);
		fd_list.right = new FormAttachment(btnNewButton, -6);
		fd_list.top = new FormAttachment(0);
		fd_list.left = new FormAttachment(0, 10);
		list.setLayoutData(fd_list);
		
		 // Print selection
        list.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event arg0) {
                if(list.getSelectionCount() > 0)
                    System.out.println(Arrays.toString(list.getSelection()));
            }
        });
		
		Button btnCheckButtonDispatchDownload = new Button(shell, SWT.CHECK);
		FormData fd_btnCheckButton = new FormData();
		btnCheckButtonDispatchDownload.setLayoutData(fd_btnCheckButton);
		btnCheckButtonDispatchDownload.setText("DispatchDownload");
		
		Button btnCheckButtonCollectedDownload = new Button(shell, SWT.CHECK);
		fd_btnCheckButton.bottom = new FormAttachment(btnCheckButtonCollectedDownload, -6);
		fd_btnCheckButton.left = new FormAttachment(btnCheckButtonCollectedDownload, 0, SWT.LEFT);
		FormData fd_btnCheckButton_1 = new FormData();
		fd_btnCheckButton_1.left = new FormAttachment(0, 108);
		btnCheckButtonCollectedDownload.setLayoutData(fd_btnCheckButton_1);
		btnCheckButtonCollectedDownload.setText("CollectedDownload");
		
		Button btnCheckButtonR_mode= new Button(shell, SWT.CHECK);
		fd_btnCheckButton_1.bottom = new FormAttachment(btnCheckButtonR_mode, -6);
		FormData fd_btnCheckButton_2 = new FormData();
		fd_btnCheckButton_2.bottom = new FormAttachment(100, -10);
		fd_btnCheckButton_2.left = new FormAttachment(0, 108);
		btnCheckButtonR_mode.setLayoutData(fd_btnCheckButton_2);
		btnCheckButtonR_mode.setText("R_mode");
		
	}
}
	

