import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class Elenco extends ArrayList<Persona>{
	
	public Elenco() {
	}

	public void scrivicsv(Finestra f) {
		JFileChooser chooser=new JFileChooser();
		//chooser.setFileFilter(new TxtFileFilter());
		int n=chooser.showSaveDialog(f);
		if(n==JFileChooser.APPROVE_OPTION) {
			try {
				FileWriter fw=new FileWriter(chooser.getSelectedFile());
				for(int i=0;i<this.size();i++) {
					fw.write("Sos");
				}
				
				fw.flush();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void importacsv(Finestra f) {
		JFileChooser chooser=new JFileChooser();
		//chooser.setFileFilter(new TxtFileFilter());
		int n=chooser.showOpenDialog(f);
		if(n==JFileChooser.APPROVE_OPTION) {
			try {
				BufferedReader br=new BufferedReader(new FileReader(chooser.getSelectedFile()));
				String line="";
				for(int i=0;i<this.size();i++) {
					if((line=br.readLine())!=null) {
						String s[]=line.split(",");
						
					}
				}
				br.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void deserializza(Finestra f) {
		JFileChooser chooser=new JFileChooser();
		//chooser.setFileFilter(new TxtFileFilter());
		int n=chooser.showOpenDialog(f);
		if(n==JFileChooser.APPROVE_OPTION) {
			try {
				ObjectInputStream obs=new ObjectInputStream(new FileInputStream(chooser.getSelectedFile()));
				Elenco elenco=(Elenco)obs.readObject();
				for(int i=0;i<elenco.size();i++) {
					this.add(elenco.get(i));
				}
				obs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void serializza(Finestra f) {
		JFileChooser chooser=new JFileChooser();
		//chooser.setFileFilter(new TxtFileFilter());
		int n=chooser.showOpenDialog(f);
		if(n==JFileChooser.APPROVE_OPTION) {
			try {
				ObjectOutputStream obt=new ObjectOutputStream(new FileOutputStream(chooser.getSelectedFile()));
				obt.writeObject(this);
				obt.flush();
				obt.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
