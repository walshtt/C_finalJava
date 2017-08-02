
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.bind.DatatypeConverter; 




public class XML_InputStudent {
   
     
	static final String student = "student";
    static final String name = "name";
    static final String age = "age";
    static final String major = "major";
    static final String activities = "activities";
    static final String grade = "grade";

    
    public ArrayList<Student> readConfig(String configFile) {
        ArrayList<Student> items = new ArrayList<>();
        try {
            // First, create a new XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            // Setup a new eventReader
            InputStream in = new FileInputStream(configFile);
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            // read the XML document
            Student item = null;

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    // If we have an item element, we create a new item
                    if (startElement.getName().getLocalPart().equals(student)) {
                    	 item = new Student(); 
                    }
                    
                    if(event.asStartElement().getName().getLocalPart()
                    		.equals(name)) {
                    	event = eventReader.nextEvent();
                    	item.name = (event.asCharacters().getData());
                    	continue;
                    }
                    
                    if (event.isStartElement()) {
                        if (event.asStartElement().getName().getLocalPart()
                                .equals(age)) {
                        	event = eventReader.nextEvent();
                        	int x =Integer.parseInt(event.asCharacters().getData());
                            item.setAge(x);
                            continue;
                        }
                    }
                    
                    if (event.asStartElement().getName().getLocalPart()
                            .equals(major)) {
                        event = eventReader.nextEvent();
                        item.major = (event.asCharacters().getData());
                        continue;
                    }

                    if (event.asStartElement().getName().getLocalPart()
                            .equals(activities)) {
                        event = eventReader.nextEvent();
                        String act =event.asCharacters().getData();
                        ArrayList<String> acts = new ArrayList<>();
                        
                        int temp =0;
                        for(int i = 0; i<act.length(); i++){
                        	if(act.charAt(i) == ','){
                        		acts.add( act.substring(temp, i));
                        		temp = i+1;
                        	}
                        	else if(i==act.length()-1){
                        		acts.add( act.substring(temp));
                        	}
                        		
                        }
                        item.activities = acts;
                        	
                        continue;
                    }

                    if (event.asStartElement().getName().getLocalPart()
                            .equals(grade)) {
                        event = eventReader.nextEvent();
                        item.grade = (event.asCharacters().getData()).charAt(0);
                        continue;
                    }
                }
                // If we reach the end of an item element, we add it to the list
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals(name)) {
                        items.add(item);
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
        	e.printStackTrace();
        }
        return items;
    }

}
   


