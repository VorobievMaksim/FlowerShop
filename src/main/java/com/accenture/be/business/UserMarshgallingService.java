package com.accenture.be.business;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface UserMarshgallingService {
    void convertFromObjectToXML(Object object, String filepath) throws IOException, JAXBException;
    Object convertFromXMLToObject(String xmlfile) throws IOException, JAXBException;
}
