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
package com.wildstartech.dispatchtrack.spi.xml.serviceorder;

import java.util.logging.Logger;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.wildstartech.dispatchtrack.Localization;
import com.wildstartech.dispatchtrack.ServiceOrder;
import com.wildstartech.dispatchtrack.spi.ServiceOrderImpl;
import com.wildstartech.dispatchtrack.spi.xml.XMLElementProcessor;
import com.wildstartech.dispatchtrack.spi.xml.XMLFactory;
import com.wildstartech.dispatchtrack.spi.xml.XMLFactoryMessages;

/**
 * Creates a {@code ServiceOrder} objects from the XML stream.
 * 
 * @author Derek Berube, Wildstar Technologies, LLC.
 * @version 0.1, 2017-05-02
 *
 */
public class ServiceOrderXMLFactory extends XMLFactory<ServiceOrder> {
   private static final String _CLASS=ServiceOrderXMLFactory.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   
   public static final String _RESOURCE_BUNDLE=
      "com.wildstartech.dispatchtrack.spi.xml.serviceorder.ServiceOrderXMLFactoryMessages";
   
   public ServiceOrderXMLFactory() {
      logger.entering(_CLASS, "ServiceOrderXMLFactory()");
      
      registerXMLElementProcessor(new AccountElementProcessor());
      registerXMLElementProcessor(new AdditionalFieldsElementProcessor());
      registerXMLElementProcessor(new AmountElementProcessor());
      registerXMLElementProcessor(new CodElementProcessor());
      registerXMLElementProcessor(new CodAmountElementProcessor());
      registerXMLElementProcessor(new CustomerElementProcessor());
      registerXMLElementProcessor(new CustomFieldsElementProcessor());
      registerXMLElementProcessor(new DescriptionElementProcessor());
      registerXMLElementProcessor(new DisplayOrderNumberElementProcessor());
      registerXMLElementProcessor(new DriversElementProcessor());
      registerXMLElementProcessor(new ExtraElementProcessor());
      registerXMLElementProcessor(new FinishedAtElementProcessor());
      registerXMLElementProcessor(new ImagesElementProcessor());
      registerXMLElementProcessor(new ItemsElementProcessor());
      registerXMLElementProcessor(new NotesElementProcessor());
      registerXMLElementProcessor(new OrderHistoryElementProcessor());
      registerXMLElementProcessor(new OrderShipmentEventsElementProcessor());
      registerXMLElementProcessor(new OriginElementProcessor());
      registerXMLElementProcessor(new PaymentCollectedElementProcessor());
      registerXMLElementProcessor(new PaymentNotesElementProcessor());
      registerXMLElementProcessor(new PiecesElementProcessor());
      registerXMLElementProcessor(new PreCallElementProcessor());
      registerXMLElementProcessor(new RequestWindowEndTimeElementProcessor());
      registerXMLElementProcessor(new RequestWindowStartTimeElementProcessor());
      registerXMLElementProcessor(new ScheduledAtElementProcessor());
      registerXMLElementProcessor(new ServiceOrderElementProcessor());
      registerXMLElementProcessor(new ServiceTimeElementProcessor());
      registerXMLElementProcessor(new ServiceTypeElementProcessor());
      registerXMLElementProcessor(new ServiceUnitElementProcessor());
      registerXMLElementProcessor(new SignatureElementProcessor());
      registerXMLElementProcessor(new StartedAtElementProcessor());
      registerXMLElementProcessor(new StatusElementProcessor());
      registerXMLElementProcessor(new StopNumberElementProcessor());
      registerXMLElementProcessor(new SurveysElementProcessor());
      registerXMLElementProcessor(new TimeWindowEndElementProcessor());
      registerXMLElementProcessor(new TimeWindowStartElementProcessor());
      registerXMLElementProcessor(new TruckElementProcessor());
      
      logger.exiting(_CLASS, "ServiceOrderXMLFactory()");
   }
   /**
    * Parses a service order out of a given XML Stream
    * @param reader
    * @return
    * @throws XMLStreamException 
    */
   public ServiceOrder parse(XMLStreamReader reader) 
      throws XMLStreamException {
      logger.entering(_CLASS, "parse(XMLStreamReader)",reader);
      boolean done=false;
      ServiceOrder serviceOrder=null;
      String elementName=null;
      String msg=null;
      XMLElementProcessor<ServiceOrder> handler=null;
      
      if (reader != null) {
         elementName=reader.getLocalName();
         if (
               (elementName != null) && 
               (elementName.equals("service_order"))
            ) {
            serviceOrder=new ServiceOrderImpl();
            while ((reader.hasNext()) && !done) {
               switch (reader.getEventType()) {
                  case XMLStreamConstants.START_ELEMENT:
                     elementName=reader.getLocalName();                     
                     handler=getElementProcessor(elementName);
                     if (handler != null) {
                        handler.processElement(serviceOrder, reader);
                        handler=null;
                     } // END if (handler != null)
                     break;
                  case XMLStreamConstants.END_ELEMENT:
                     elementName=reader.getLocalName();
                     switch(elementName) {
                        case "service_order":
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
         // The specified reader was NULL.
         msg=Localization.getString(
               XMLFactory._RESOURCE_BUNDLE, 
               XMLFactoryMessages.ERR_XML_STREAM_READER_NULL,
               null, 
               null, 
               null);
         logger.severe(msg);
      } // END if (reader != null)
      logger.exiting(_CLASS, "parse(XMLStreamReader)",serviceOrder);
      return serviceOrder;
   }
}