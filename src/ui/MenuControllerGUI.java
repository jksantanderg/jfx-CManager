package ui;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Contact;
import model.ContactManager;





public class MenuControllerGUI {
	
    @FXML
    private VBox vbMain;
	
    @FXML
    private MenuBar barMenu;
	
    @FXML
    private Pane mainPane;
    
    @FXML
    private TextField tfUsername;

    @FXML
    private TextField tfPassword;
    
    @FXML
    private TableView<Contact> tvContactList;

    @FXML
    private TableColumn<Contact,String> tcId;

    @FXML
    private TableColumn<Contact,String> tcName;

    @FXML
    private TableColumn<Contact,String> tcEmail;
    
    @FXML
    private TextField txtName;

    @FXML
    private TextField txtEmail;
    
    private ObservableList<Contact> observableList;
    
    private ContactManager contactManager;

	
    public MenuControllerGUI() {
    	contactManager = new ContactManager();
    	
    }
    
    private void inicializeTableView() {
    	observableList = FXCollections.observableArrayList(contactManager.getContact());
    	
    	tvContactList.setItems((ObservableList<Contact>) observableList);
    	//tvContactList.setItems(observableList);
    	tcId.setCellValueFactory(new PropertyValueFactory<Contact,String>("id"));
    	tcName.setCellValueFactory(new PropertyValueFactory<Contact,String>("name"));
    	tcEmail.setCellValueFactory(new PropertyValueFactory<Contact,String>("email"));
    }

    
   @FXML
    public void showForm1(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Formulario1.fxml"));
		fxmlLoader.setController(this);
    	Parent form1 = fxmlLoader.load();
    	mainPane.getChildren().setAll(form1);
    }
   
   @FXML
   void addContact(ActionEvent event) {
	   Contact newContact = null;
	/*String id= "";
	   String name = txtName.getText();
	   String email = txtEmail.getText();*/
	   contactManager.Add(newContact);
   }
   


    @FXML
   public void showForm2(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Formulario2.fxml"));
		fxmlLoader.setController(this);
    	Parent form2 = fxmlLoader.load();
    	mainPane.getChildren().setAll(form2);

    }
        
    @FXML
   public void showListContact(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Formulario3.fxml"));
		fxmlLoader.setController(this);
    	Parent form3 = fxmlLoader.load();
    	mainPane.getChildren().setAll(form3);
    	
    	inicializeTableView();

    }
    
    @FXML
    public void exportContact(ActionEvent event) throws IOException {
    	contactManager.exportData();

    }
    
    @FXML
    public void importContact(ActionEvent event) throws IOException {
    	contactManager.importData();
    	inicializeTableView();

    }    
    

    @FXML
    void loadData(ActionEvent event) throws FileNotFoundException, ClassNotFoundException, IOException {
    	if(contactManager.LoadData()) {
    		showInformation(event);
    		showListContact(event);
    	}
	
    	
    }

    @FXML
    void saveData(ActionEvent event) throws FileNotFoundException, IOException {
    	contactManager.saveData();
    }
    
    @FXML
    void AddContact(MouseEvent event) {

    }
    
    
    @FXML
    private Pane showInformation(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Contact Manger");
    	alert.setHeaderText("Yessica");
    	alert.setContentText("Contact Manager Application");
    	alert.show();
		return mainPane;//
		
		
    }

    
	public Stage getMainStage() {
		return getMainStage();
	}

	public void setMainStage(Pane primaryStage) {
		this.mainPane = primaryStage;
	}

	public void setMainStage(Stage primaryStage) {
		// TODO Auto-generated method stub
		
	}

    
    
    
}
