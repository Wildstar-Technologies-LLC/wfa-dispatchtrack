package com.wildstartech.dispatchtrack.spi.xml.serviceorder.image;

import java.util.Date;
import java.util.logging.Logger;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.wildstartech.dispatchtrack.Image;
import com.wildstartech.dispatchtrack.Localization;
import com.wildstartech.dispatchtrack.spi.xml.XMLElementProcessor;
import com.wildstartech.dispatchtrack.spi.xml.XMLElementProcessorMessages;

public class ImageElementProcessor extends XMLElementProcessor<Image> {
   private static final String _CLASS=ImageElementProcessor.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   private static final String elementLabel="image";
   
   @Override
   public String getElementLabel() {
      logger.entering(_CLASS, "getElementLabel()");
      logger.exiting(_CLASS, "getElementLabel()",
            ImageElementProcessor.elementLabel);
      return ImageElementProcessor.elementLabel;
   }

   @Override
   public void processElement(Image image, XMLStreamReader reader) 
   throws XMLStreamException {
      logger.entering(_CLASS, "processElement(Image,XMLStreamReader)",
            new Object[] {image,reader});
      Date createdAt=null;
      String createdAtText=null;
      String msg=null;
      String source=null;
      String thumbnail=null;
      
      if ((image != null) && (reader != null)) {
         createdAtText=reader.getAttributeValue("", "created_at");
         createdAt=this.getXMLTimestampAsDate(createdAtText);
         source=reader.getAttributeValue("", "src");
         thumbnail=reader.getAttributeValue("", "thumbnail");
         image.setCreatedAt(createdAt);
         image.setSource(source);
         image.setThumbnail(thumbnail);
      }  else {
         if (image == null) {
            msg=Localization.getString(
               XMLElementProcessor._RESOURCE_BUNDLE, 
               XMLElementProcessorMessages.OBJECT_PARAM_NULL, 
               null,    // locale, 
               null,    // cl, 
               new Object[] {"Image"});
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
      logger.exiting(_CLASS, "processElement(Image,XMLStreamReader)");
   }
}