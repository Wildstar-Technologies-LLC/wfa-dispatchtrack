package com.wildstartech.dispatchtrack.spi.xml.serviceorder.item;

import java.util.List;
import java.util.logging.Logger;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.wildstartech.dispatchtrack.Item;
import com.wildstartech.dispatchtrack.Localization;
import com.wildstartech.dispatchtrack.ReturnCode;
import com.wildstartech.dispatchtrack.spi.xml.XMLElementProcessor;
import com.wildstartech.dispatchtrack.spi.xml.XMLElementProcessorMessages;

public class ReturnCodesElementProcessor extends XMLElementProcessor<Item> {
   private static final String _CLASS=ReturnCodesElementProcessor.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   private static final String elementLabel="drivers";
   
   
   @Override
   public String getElementLabel() {
      logger.entering(_CLASS, "getElementLabel()");
      logger.exiting(_CLASS, "getElementLabel()",
            ReturnCodesElementProcessor.elementLabel);
      return ReturnCodesElementProcessor.elementLabel;
   }

   @Override
   public void processElement(Item item, XMLStreamReader reader) 
   throws XMLStreamException {
      logger.entering(_CLASS, "processElement(ServiceOrder,XMLStreamReader)",
            new Object[] {item,reader});
      ReturnCodesXMLFactory listFactory=null;
      List<ReturnCode> returnCodes=null;
      String msg=null;
      
      if ((item != null) && (reader != null)) {
         listFactory=new ReturnCodesXMLFactory();
         returnCodes=listFactory.parse(reader);
         if (returnCodes != null) {
            item.setReturnCodes(returnCodes);
         } // END if (drivers != null)
      } else {
         if (item == null) {
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