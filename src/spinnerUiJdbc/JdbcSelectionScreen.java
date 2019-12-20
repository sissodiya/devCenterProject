package spinnerUiJdbc;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;

import org.eclipse.swt.SWT;
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
		
			JdbcSelectionScreen window = new JdbcSelectionScreen();
			window.open();
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

	    shell.setMenuBar(menuBar);
	    
	    shell.open();
	    
        //Calling functions() through a JdbcOracleConnection object |jdbcOC|

	    jdbcOC.makeDatabaseConnection();
	    jdbcOC.executeQueryInstrumentName();
	    
	    List list = new List(shell, SWT.DROP_DOWN);
		
	    Button btnNewButton = new Button(shell, SWT.NONE);

		btnNewButton.addListener(SWT.Selection, (Listener) new Listener() {
		      public void handleEvent(Event e) {
		        switch (e.type) {
		        case SWT.Selection:
		          System.out.println("Query In Execution");
		          	jdbcOC.executeQueryCollDown();					
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
                if(list.getSelectionCount() > 0) {
                	jdbcOC.executeQueryDispDown();	
                }
            }
        });
		
	}
}