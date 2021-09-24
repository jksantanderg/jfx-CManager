package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;



public class ContactManager {
	private List<Contact> contact;
	private String FILE_IMPORT_TXT_PATH = "data/contactData.txt";
	private String FILE_EXPORT_TXT_PATH = "data/exportData.txt";
	private String FILE_SAVE_PATH = "data/contacts.apo";
	

	public ContactManager() {
		contact = new ArrayList <Contact>();
		contact.add(new Contact("0","Yessica","yessica@gmail.com"));
	}
	
    @SuppressWarnings("unchecked")
	public boolean LoadData() throws FileNotFoundException, IOException, ClassNotFoundException {
    	
    	File f = new File(FILE_SAVE_PATH);
    	boolean isLoaded = false;
    	if(f.exists()) {
    		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
    		contact = (List<Contact>) ois.readObject();
    		ois.close();
    		isLoaded = true;
    	}
    	return isLoaded;
    }

    public void saveData() throws FileNotFoundException, IOException {
    	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_SAVE_PATH));
    	oos.writeObject(contact);
    	oos.close();
    }
    
	public void importData() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(FILE_IMPORT_TXT_PATH));
		String line = br.readLine();
		while(line!=null) {
			String[] parts = line.split(";");
			Contact register = new Contact(parts[0],parts[1],parts[2]);
			Add(register);
			line = br.readLine();
		}
		
		br.close();
		
	}
	




	public void exportData() throws IOException {
		FileWriter fw = new FileWriter(FILE_EXPORT_TXT_PATH,false);
		for(int i=0;i<contact.size();i++) {
			Contact myContact = contact.get(i);
			fw.write(myContact.getId()+";"+myContact.getName()+";"+myContact.getEmail()+"\n");
			
		}
		fw.close();
	}
    
	public boolean Add(Contact newContact) {
		
		if (contact.add(newContact)) {
			return true;
		}
		else {
			return false;

		}
	}

	
	/*public  void Add(String id, String name, String email) {
		
		for(int i=0; i<contact.size() ; i++) {
			
			if(name!=null && name!=""  && email!=null&& email!="" ){
				i = i+1;
				String numCadena= Integer.toString(i);
				id =  numCadena;
				contact.add(new Contact(id,name,email));
			}else{
				System.out.println("Error");
			}
		}
	}	*/
	
	//TODO
	public boolean Remove(int index) {
	
			return true;
	}
	
	public List<Contact> getContact() {
		return contact;
	}
	
	
	

	


}
