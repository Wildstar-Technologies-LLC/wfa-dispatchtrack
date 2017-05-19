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
package com.wildstartech.dispatchtrack.spi.xml.customer;

import java.util.logging.Logger;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.wildstartech.dispatchtrack.Customer;
import com.wildstartech.dispatchtrack.Localization;
import com.wildstartech.dispatchtrack.spi.CustomerImpl;
import com.wildstartech.dispatchtrack.spi.xml.XMLElementProcessor;
import com.wildstartech.dispatchtrack.spi.xml.XMLFactory;
import com.wildstartech.dispatchtrack.spi.xml.XMLFactoryMessages;

/**
 * Parses a {@code Customer} object from an XML stream.
 * @author Derek Berube, Wildstar Technologies, LLC.
 * @version 0.1, 2017-05-02
 *
 */
public class CustomerXMLFactory extends XMLFactory<Customer> {
   private static final String _CLASS=CustomerXMLFactory.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   
   public CustomerXMLFactory() {
      logger.entering(_CLASS, "CustomerXMLFactory()");
      registerXMLElementProcessor(new Address1ElementProcessor());
      registerXMLElementProcessor(new Address2ElementProcessor());
      registerXMLElementProcessor(new CityElementProcessor());
      registerXMLElementProcessor(new CustomerIdElementProcessor());
      registerXMLElementProcessor(new EmailElementProcessor());
      registerXMLElementProcessor(new FirstNameElementProcessor());
      registerXMLElementProcessor(new LastNameElementProcessor());
      registerXMLElementProcessor(new LatitudeElementProcessor());
      registerXMLElementProcessor(new LongitudeElementProcessor());
      registerXMLElementProcessor(new Phone1ElementProcessor());
      registerXMLElementProcessor(new Phone2ElementProcessor());
      registerXMLElementProcessor(new StateElementProcessor());
      registerXMLElementProcessor(new ZipElementProcessor());
      logger.entering(_CLASS, "CustomerXMLFactory()");
   }
   
   public Customer parse(XMLStreamReader reader) throws XMLStreamException {
      logger.entering(_CLASS, "parse(XMLStreamReader)",reader);
      boolean done=false;
      Customer customer=null;
      String elementName=null;
      String msg=null;
      XMLElementProcessor<Customer> handler=null;
      
      if (reader != null) {
         elementName=reader.getLocalName();
         if (
               (elementName != null) && 
               (elementName.equals("customer"))
            ) {
            reader.next();
            customer=new CustomerImpl();
            while ((reader.hasNext()) && !done) {
               switch (reader.getEventType()) {
                  case XMLStreamConstants.START_ELEMENT:
                     elementName=reader.getLocalName();                     
                     handler=getElementProcessor(elementName);
                     if (handler != null) {
                        handler.processElement(customer, reader);
                        handler=null;
                     } // END if (handler != null)
                     break;
                  case XMLStreamConstants.END_ELEMENT:
                     elementName=reader.getLocalName();
                     switch(elementName) {
                        case "customer":
                           done=true;                           
                           break;
                     } // END switch(elementName)
                     break;
               } // END switch (reader.getEventType())
               if (reader.hasNext()) {
                  reader.next();
               } // END if (reader.hasNext())
            } // END while (reader.hasName())
         } // END if ((elementName != null) && ...    
      } else {
         msg=Localization.getString(
            "XMLFactorymessages",
            XMLFactoryMessages.ERR_XML_STREAM_READER_NULL, 
            null,  // locale
            null,  // cl
            null); // params
         logger.severe(msg);
      } // END // (reader != null) 
      
      logger.exiting(_CLASS, "parse(XMLStreamReader)",customer);
      return customer;
   }
} 