package com.wildstartech.dispatchtrack.spi.xml.serviceorder.driver;

import java.util.logging.Logger;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.wildstartech.dispatchtrack.Driver;
import com.wildstartech.dispatchtrack.spi.xml.XMLElementProcessor;

public class NameElementProcessor extends XMLElementProcessor<Driver> {
   private static final String _CLASS=
         NameElementProcessor.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   private static final String elementLabel="name";
   
   
   @Override
   public String getElementLabel() {
      logger.entering(_CLASS, "getElementLabel()");
      logger.exiting(_CLASS, "getElementLabel()",
            NameElementProcessor.elementLabel);
      return NameElementProcessor.elementLabel;
   }

   @Override
   public void processElement(Driver driver, XMLStreamReader reader) 
   throws XMLStreamException {
      logger.entering(_CLASS, "processElement(Driver,XMLStreamReader)",
            new Object[] {driver,reader});
      String name=null;
      
      name=getElementText(reader);
      driver.setName(name);
      
      logger.exiting(_CLASS, "processElement(Driver,XMLStreamReader)");
   }
}