/* 
 *  Wildstar Foundation Architecture DispatchTrack API for Java
 *
 *  Copyright (C) 2017 Wildstar Technologies, LLC.
 *
 *  This program is free software; you can redistribute it and/or modify it
 *  under the terms of the GNU General Public License as published by the Free
 *  Software Foundation; either version 2 of the License, or (at your option)
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful, but WITHOUT
 *  ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 *  FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for
 *  more details.
 *
 *  You should have received a copy of the GNU General Public License along
 *  with this program; if not, write to the Free Software Foundation, Inc., 59
 *  Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *  
 *  Linking this library statically or dynamically with other modules is making
 *  a combined work based on this library.  Thus, the terms and conditions of
 *  the GNU General Public License cover the whole combination.
 *
 *  As a special exception, the copyright holders of this library give you
 *  permission to link this library with independent modules to produce an
 *  executable, regardless of the license terms of these independent modules,
 *  and to copy and distribute the resulting executable under terms of your
 *  choice, provided that you also meet, for each linked independent module,
 *  the terms and conditions of the license of that module.  An independent
 *  module is a module which is not derived from or based on this library.  If
 *  you modify this library, you may extend this exception to your version of
 *  the library, but you are not obligated to do so.  If you do not wish to do
 *  so, delete this exception statement from your version.
 *  If you need additional information or have any questions, please contact:
 *
 *      Wildstar Technologies, LLC.
 *      63 The Greenway Loop
 *      Inlet Beach, FL 32461
 *      USA
 *
 *      derek.berube@wildstartech.com
 *      www.wildstartech.com
 */
package com.wildstartech.dispatchtrack.spi.xml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.wildstartech.dispatchtrack.Localization;

public abstract class XMLElementProcessor<T> {
   private static final String _CLASS=XMLElementProcessor.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   private static final String _DATE_FORMAT_PATTERN="yyyy-MM-dd HH:mm:ss Z";
   public static final String _RESOURCE_BUNDLE=
         "com.wildstartech.dispatchtrack.spi.xml.XMLElementProcessorMessages";
   
   private String elementLabel=null;
   private String[] eventLabel={
         "START_ELEMENT",
         "END_ELEMENT",
         "PROCESSING_INSTRUCTION",
         "CHARACTERS",
         "COMMENT",
         "SPACE",
         "START_DOCUMENT",
         "END_DOCUMENT",
         "ENTITY_REFERENCE",
         "ATTRIBUTE",
         "DTD",
         "CDATA",
         "NAMESPACE",
         "NOTATION_DECLARATION",
         "ENTITY_DECLARATION"
   };
   
   //********** Utility Methods
   public String getEventLabel(int constant) {
      logger.entering(_CLASS, "getEventLabel(int)",constant);
      String label=null;
      label=this.eventLabel[constant -1];
      logger.exiting(_CLASS, "getEventLabel(int)",label);
      return label;
   }
   //***** elementLabel
   public String getElementLabel() {
      logger.entering(_CLASS, "getElementLabel()");
      logger.exiting(_CLASS, "getElementLabel()",this.elementLabel);
      return this.elementLabel;
   }
   public void setElementLabel(String label) {
      logger.entering(_CLASS, "setElementLabel(String)",label);
      logger.exiting(_CLASS, "setElementLabel(String)");
   }
   //***** elementBoolean
   public boolean getElementBoolean(XMLStreamReader reader) 
   throws XMLStreamException {
      logger.entering(_CLASS,"getElementDate(XMLStreamReader)",reader);
      boolean result=false;
      String elementText="";
      
      elementText=getElementText(reader);
      if ((elementText != null) && (elementText.equalsIgnoreCase("true"))) {
         result=true;
      } // if ((elementText != null) && (elementText.equalsIgnoreCase("true"))
      logger.exiting(_CLASS,"getElementDate(XMLStreamReader)",result);
      return result;
   }
   //***** elementDate
   public Date getElementDate(XMLStreamReader reader) 
   throws XMLStreamException {
      logger.entering(_CLASS,"getElementDate(XMLStreamReader)",reader);
      Date date=null;
      String elementText="";
      
      elementText=getElementText(reader);
      date=getXMLTimestampAsDate(elementText);
      logger.exiting(_CLASS,"getElementDate(XMLStreamReader)",date);
      return date;
   }
   //***** elementFloat
   public float getElementFloat(XMLStreamReader reader) 
   throws XMLStreamException {
      logger.entering(_CLASS,"getElementFloat(XMLStreamReader)",reader);
      float value=0;
      String elementText="";
      String msg="";
      
      if (reader != null) {
         elementText=getElementText(reader);
         if ((elementText != null) && (!elementText.isEmpty())) {
            try {
               value=Float.valueOf(elementText);
            } catch (NumberFormatException ex) {
               msg=Localization.getString(
                  XMLElementProcessor._RESOURCE_BUNDLE, 
                  XMLElementProcessorMessages.ERR_PARSE, 
                  null, 
                  null, 
                  new Object[] {
                     "NumberFormatException",
                     "Float",
                     elementText});
               logger.log(Level.SEVERE, msg, ex);
               value=Float.MIN_VALUE;
            } // END try/catch
         } // END if ((elementText != null) && (!elementText.isEmpty()))
      }
      logger.exiting(_CLASS,"getElementFloat(XMLStreamReader)",value);
      return value;
   } // END if (reader != null)
   
   //***** elementInteger
   public int getElementInteger(XMLStreamReader reader) throws XMLStreamException {
      logger.entering(_CLASS,"getElementFloat(XMLStreamReader)",reader);
      int value=0;
      String elementText="";
      String msg="";
      
      if (reader != null) {
         elementText=getElementText(reader);
         if ((elementText != null) && (!elementText.isEmpty())) {
            try {
               value=Integer.valueOf(elementText);
            } catch (NumberFormatException ex) {
               msg=Localization.getString(
                  XMLElementProcessor._RESOURCE_BUNDLE, 
                  XMLElementProcessorMessages.ERR_PARSE, 
                  null, 
                  null, 
                  new Object[] {
                     "NumberFormatException",
                     "Integer",
                     elementText});
               logger.log(Level.SEVERE, msg, ex);
               value=Integer.MIN_VALUE;
            } // END try/catch
         } // END if ((elementText != null) && (elementText.isEmpty()))         
      } // END if (reader != null)
      logger.exiting(_CLASS,"getElementFloat(XMLStreamReader)",value);
      return value;
   }
   //***** elementText
   public String getElementText(XMLStreamReader reader) throws XMLStreamException {
      logger.entering(_CLASS, "getElementText(XMLStreamReader)",reader);
      boolean done=false;
      String elementText="";
      StringBuilder sb=null;
      
      sb=new StringBuilder();
      if (reader != null) {
         while (reader.hasNext() && (!done)) {
            reader.next();
            switch(reader.getEventType()) {
               case XMLStreamConstants.CDATA:
               case XMLStreamConstants.CHARACTERS:
                  sb.append(reader.getText());
                  break;
               case XMLStreamConstants.END_ELEMENT:
                  done=true;
                  break;
            } // END switch(reader.getEventType())            
         } // END while(reader.hasNext())
      }
      elementText=sb.toString();
      elementText=elementText.trim();
      
      logger.exiting(_CLASS, "getElementText(XMLStreamReader)",elementText);
      return elementText;
   }
   
   //***** XML Timestamp
   public Date getXMLTimestampAsDate(String dateText) {
      logger.entering(_CLASS, "getXMLTimestampAsDate()");
      Date date=null;
      SimpleDateFormat fmt=null;
      String msg=null;
      
      if ((dateText !=null) && (!dateText.isEmpty())) {
         fmt=new SimpleDateFormat(_DATE_FORMAT_PATTERN);
         try {
            date=fmt.parse(dateText);
         } catch (ParseException ex) {
            msg=Localization.getString(
                  XMLElementProcessor._RESOURCE_BUNDLE,
                  XMLElementProcessorMessages.ERR_XML_DATE_FORMAT,
                  null,
                  null,
                  new Object[] {dateText}
            );
            logger.log(Level.SEVERE, msg,ex);
         } // END try/catch            
      } // END if (dateText !=null)
      logger.exiting(_CLASS, "getXMLTimestampAsDate()",date);
      return date;
   }
   
   public abstract void processElement(T object, XMLStreamReader reader)
      throws XMLStreamException;   
}