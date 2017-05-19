package com.wildstartech.dispatchtrack.spi.xml.serviceorder;

import java.util.List;
import java.util.logging.Logger;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.wildstartech.dispatchtrack.Driver;
import com.wildstartech.dispatchtrack.Localization;
import com.wildstartech.dispatchtrack.ServiceOrder;
import com.wildstartech.dispatchtrack.spi.xml.XMLElementProcessor;
import com.wildstartech.dispatchtrack.spi.xml.XMLElementProcessorMessages;
import com.wildstartech.dispatchtrack.spi.xml.serviceorder.driver.DriverListXMLFactory;

public class DriversElementProcessor extends XMLElementProcessor<ServiceOrder> {
   private static final String _CLASS=CustomerElementProcessor.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   private static final String elementLabel="drivers";
   
   
   @Override
   public String getElementLabel() {
      logger.entering(_CLASS, "getElementLabel()");
      logger.exiting(_CLASS, "getElementLabel()",
            DriversElementProcessor.elementLabel);
      return DriversElementProcessor.elementLabel;
   }

   @Override
   public void processElement(ServiceOrder order, XMLStreamReader reader) 
   throws XMLStreamException {
      logger.entering(_CLASS, "processElement(ServiceOrder,XMLStreamReader)",
            new Object[] {order,reader});
      DriverListXMLFactory listFactory=null;
      List<Driver> drivers=null;
      String msg=null;
      
      if ((order != null) && (reader != null)) {
         listFactory=new DriverListXMLFactory();
         drivers=listFactory.parse(reader);
         if (drivers != null) {
            order.setDrivers(drivers);
         } // END if (drivers != null)
      } else {
         if (order == null) {
            msg=Localization.getString(
               XMLElementProcessor._RESOURCE_BUNDLE, 
               XMLElementProcessorMessages.OBJECT_PARAM_NULL, 
               null,    // locale, 
               null,    // cl, 
               new Object[] {"ServiceOrder"});
            logger.severe(msg);
         } // END if (order == null)
         if (reader == null) {
            msg=Localization.getString(
                  XMLElementProcessor._RESOURCE_BUNDLE, 
                  XMLElementProcessorMessages.XML_STREAM_READER_NULL, 
                  null,    // locale, 
                  null,    // cl, 
                  null);   // parameters
            logger.severe(msg);
         } // if (reader == null)         
      } // END if ((order != null) && (reader != null))
      logger.exiting(_CLASS, "processElement(ServiceOrder,XMLStreamReader)");
   }
}