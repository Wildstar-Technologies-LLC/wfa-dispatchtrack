package com.wildstartech.dispatchtrack.spi.xml.serviceorder.driver;

import java.util.logging.Logger;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.wildstartech.dispatchtrack.Driver;
import com.wildstartech.dispatchtrack.spi.xml.XMLElementProcessor;

public class IdElementProcessor extends XMLElementProcessor<Driver> {
   private static final String _CLASS=IdElementProcessor.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   private static final String elementLabel="id";
   
   
   @Override
   public String getElementLabel() {
      logger.entering(_CLASS, "getElementLabel()");
      logger.exiting(_CLASS, "getElementLabel()",
            IdElementProcessor.elementLabel);
      return IdElementProcessor.elementLabel;
   }

   @Override
   public void processElement(Driver driver, XMLStreamReader reader) 
   throws XMLStreamException {
      logger.entering(_CLASS, "processElement(Driver,XMLStreamReader)",
            new Object[] {driver,reader});
      String id=null;
      
      id=getElementText(reader);
      driver.setId(id);
      
      logger.exiting(_CLASS, "processElement(Driver,XMLStreamReader)");
   }
}