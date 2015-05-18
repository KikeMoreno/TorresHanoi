package hanoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *Autor: Enrique Moreno Agraso
 */

public class Tablero {
	//ATRIBUTOS
	private Torre torres[] = new Torre[3];
	private int movimientos = 0;
	private int numDiscos;
	private int pos=0;
	
	//CONSTRUCTORES
	/**
	 * Constructor con el parámetro numero de discos.
	 * @param numDiscos Numero de Discos
	 */
	public Tablero(int numDiscos) {
		this.numDiscos = numDiscos;
		//Creamos las torres
		for (int i=0;i<3;i++){
			torres[i] = new Torre (numDiscos);
		}
		//Creamos los discos en la torre 0
		for (int i=numDiscos;i>0;i--){
			Disco d = new Disco(i);
			torres[0].introducir(d);
		}
	}
	
	/**
	 * Constructor vacio
	 */
	public Tablero(){
		
	}
	
	// GETTERS & SETTERS
	/**
	 * Devuelve los movimientos de la partida.
	 * @return movimientos Movimientos de la partida.
	 */
	public int getMovimientos(){
		return movimientos;
	}
	
	/**
	 * Establece los movimientos de la partida.
	 * @param mov Movimientos de la partida.
	 */
	public void setMovimientos(int mov){
		movimientos=mov;
	}
	
	/**
	 * Devuelve el numero de discos de la partida.
	 * @return numDiscos Numero de discos de la partida.
	 */
	public int getNumDiscos(){
		return numDiscos;
	}
	
	/**
	 * Establece el numero de discos de la partida.
	 * @param num Numero de discos de la partida.
	 */
	public void setNumDiscos(int num){
		numDiscos=num;
	}

	// METODOS
	
	/**
	 * Añade una torre al tablero.
	 * @param t Torre del tablero.
	 */
	public void crearTorres(int num){
		for (int i=0;i<3;i++){
			torres[i] = new Torre (num);
		}
	}
	
	public void crearDisco(int torre, int tamaño){
			Disco disco = new Disco(tamaño);
			torres[torre].introducir(disco);
	}
	
	/**
	 * Mueve un disco de una torre a otra.
	 * @param o origen
	 * @param d destino
	 * @return boolean
	 */
	public boolean moverDisco(int o, int d){
		if (torres[o].getSizeUltimoDisco() < torres[d].getSizeUltimoDisco() || torres[d].getSizeUltimoDisco()==-1){
			torres[d].introducir(torres[o].sacar());
			movimientos++;
			return true;
		}
		return false;
	}
	
	/**
	 * Devuelve un boolean si has llegado al fin de la partida o no.
	 * @return boolean
	 */
	public boolean comprobarFin(){
		return torres[2].getOcupacion()==numDiscos;
	}
	
	/**
	 * Devuelve un string con lo que hay en la partida.
	 */
	public void imprimir(){
		for (int i=0;i<3;i++){
			torres[i].imprimir();	
		}
		System.out.println("movimientos="+movimientos);
	}
	
	/**
	 * Guarda el progreso de la partida en un xml
	 */
	public void guardar(){
		XMLOutputFactory factory = XMLOutputFactory.newInstance();
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();

		try {
			//Creaamos el archivo xml donde se guardaran los datos.
			XMLEventWriter writer = factory.createXMLEventWriter(new FileWriter("partida.xml"));
			Characters characters;
			XMLEvent end = eventFactory.createDTD("\n"); //Fin de linea.
			XMLEvent tab = eventFactory.createDTD("\t"); //Tabulador.
			
			//Inicializamos el documento.
			XMLEvent event = eventFactory.createStartDocument();
			writer.add(event);
			
			writer.add(end); //Cambiamos de linea.
			
			//Abrimos el elemento partida.
			event = eventFactory.createStartElement("","","partida");
			writer.add(event);
			
			writer.add(end); //Cambiamos de linea.
			writer.add(tab); //Tabulamos.
			
			//Abrimos el elemento nDiscos
			event = eventFactory.createStartElement("","","nDiscos");
			writer.add(event);
			
			//Si hay discos escribimos el numero de discos que tenemos en la partida.
			if(this.getNumDiscos()!=0){
				characters = eventFactory.createCharacters(""+this.getNumDiscos());
				writer.add(characters);
			}
			//Cerramos el elemento nDiscos.
			event = eventFactory.createEndElement("", "", "nDiscos");
			writer.add(event);
			
			writer.add(end); //Cambiamos de linea.
			writer.add(tab); //Tabulamos.
			
			//Abrimos el elemento Movimientos.
			event = eventFactory.createStartElement("","","Movimientos");
			writer.add(event);
			
			//Si hemos hecho algún movimiento lo escribimos
			if(this.getMovimientos()!=0){
				characters = eventFactory.createCharacters(""+this.getMovimientos());
				writer.add(characters);
			}
			//Cerramos el elemento Movimientos.
			event = eventFactory.createEndElement("", "", "Movimientos");
			writer.add(event);
			
			writer.add(end); //Cambiamos de linea.
			writer.add(tab); //Tabulamos.
			
			//Bucle, hasta que no hayamos creado todas las torres no salimos.
			for(int i=0;i<torres.length;i++){
				//Abrimos el elemento Torre.
				event = eventFactory.createStartElement("","","Torre");
				writer.add(event);
				
				writer.add(end); //Cambiamos de linea.
				writer.add(tab); //Tabulamos.
				writer.add(tab); //Tabulamos.
						
				for(int j=0;j<torres[i].getOcupacion();j++){
					//Abrimos el elemento Disco.
					event = eventFactory.createStartElement("","","Disco");
					writer.add(event);
					
					//Introducimos el tamaño del disco.
					event = eventFactory.createAttribute("tamano", ""+torres[i].getSizeDisco(j));
					writer.add(event);
					
					writer.add(end); //Cambiamos de linea
					writer.add(tab); //Tabulamos
					writer.add(tab); //Tabulamos
					writer.add(tab); //Tabulamos
					
					//Abrimos el elemento ocupacion.
					event = eventFactory.createStartElement("","","ocupacion");
					writer.add(event);
					
					
					//Introducimos la ocupacion del disco.
					characters = eventFactory.createCharacters(""+(j+1));
					writer.add(characters);
						
					//Cerramos el elemento ocupacion.
					event = eventFactory.createEndElement("", "", "ocupacion");
					writer.add(event);
						
					writer.add(end); //Cambiamos de linea
					writer.add(tab); //Tabulamos
					writer.add(tab); //Tabulamos
						
					//Cerramos el elemento disco.
					event = eventFactory.createEndElement("", "", "Disco");
					writer.add(event);
					
				}
				
				writer.add(end); //Cambiamos de linea.
				writer.add(tab); //Tabulamos.
				
				//Cerramos el elemento Torre.
				event = eventFactory.createEndElement("", "", "Torre");
				writer.add(event);
				
				writer.add(end); //Cambiamos de linea.
				
				//Tabulamos el elemento Torres.
				if(i!=2){
					writer.add(tab);
				}
			}
			
			//Cerramos el elemento partida.
			event = eventFactory.createEndElement("", "", "partida");
			writer.add(event);
			
			writer.flush();
			writer.close();
			
			//Mostramos por pantalla que se ha guardado correctamente.
			System.out.println("SE HA GUARDADO LA PARTIDA CORRECTAMENTE");
			
			}catch (XMLStreamException e){
				e.printStackTrace();
			}catch (IOException e){
				e.printStackTrace();
			}
	}
	
	@SuppressWarnings({ "unchecked", "null" })
	public void cargar(String xml){
		try {
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			InputStream in = new FileInputStream(xml);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			int t=-1;
			int tam=0;
			
			//Mientras exista un evento
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				
				//Si lo que encontramos es un evento de inicio.
				if(event.isStartElement()){
					StartElement startElement = event.asStartElement();
					//Si el elemento es ndiscos.
					if (startElement.getName().getLocalPart() == ("nDiscos")) {
						//Leemos el siguiente elemento.
						event = eventReader.nextEvent();
						//Introducimos el valor del numero de discos.
						this.setNumDiscos(event.asCharacters().getEventType());
						this.crearTorres(this.getNumDiscos());
					//Si el elemento es movimientos.
					}else if (startElement.getName().getLocalPart() == ("Movimientos")) {
						//Leemos el siguiente elemento
						event = eventReader.nextEvent();
						//Introducimos el valor de los movimientos de la partida.
						this.setMovimientos(event.asCharacters().getEventType());
					//Si el elemento es una torre.
					}else if((startElement.getName().getLocalPart() == ("Torre"))){
						t++;
					//Si el elemento es disco.
					}else if(startElement.getName().getLocalPart() == ("Disco")){
						Iterator<Attribute> attributes = startElement.getAttributes();
						while(attributes.hasNext()){
							Attribute attribute=attributes.next();
							if(attribute.getName().toString().equals("tamano")){
								//Guardo en una variable el tamaño del disco de la torre t
								tam=Integer.parseInt(attribute.getValue());
							}
						}
					//Si el elemento es ocupacion.
					}else if (startElement.getName().getLocalPart() == ("ocupacion")) {
						event = eventReader.nextEvent();
						//Si hay torres
						if(t>=0){
							//Creo el disco de tamaño tam en la torre t.
							this.crearDisco(t, tam);
						}
					}
				}	
			}
			System.out.println("CARGA COMPLETADA");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
	
}
