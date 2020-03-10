package com.accenture.be.business;

import com.accenture.be.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class UserMarshgallingServiceImpl implements UserMarshgallingService {
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;


    @Override
    public void convertFromObjectToXML(Object object, String filepath) throws IOException, JAXBException {
        FileOutputStream os=null;
        try {
            marshaller = JAXBContext.newInstance(User.class).createMarshaller();
            os = new FileOutputStream(filepath);
            marshaller.marshal(object, new StreamResult(os));
        } finally {
            if (os!=null){
            os.close();}
        }
    }

    @Override
    public Object convertFromXMLToObject(String xmlfile) throws IOException, JAXBException {
        FileInputStream is = null;
        try {
            unmarshaller = JAXBContext.newInstance(User.class).createUnmarshaller();
            is = new FileInputStream(xmlfile);
            return (User)unmarshaller.unmarshal(new StreamSource(is));
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }
}
