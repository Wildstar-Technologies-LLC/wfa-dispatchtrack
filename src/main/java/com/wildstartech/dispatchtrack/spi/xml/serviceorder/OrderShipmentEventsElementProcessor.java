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

import java.util.List;
import java.util.logging.Logger;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.wildstartech.dispatchtrack.Localization;
import com.wildstartech.dispatchtrack.ServiceOrder;
import com.wildstartech.dispatchtrack.ShipmentEvent;
import com.wildstartech.dispatchtrack.spi.xml.XMLElementProcessor;
import com.wildstartech.dispatchtrack.spi.xml.XMLElementProcessorMessages;

public class OrderShipmentEventsElementProcessor extends XMLElementProcessor<ServiceOrder> {
   private static final String _CLASS=CustomerElementProcessor.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   private static final String elementLabel="order_shipment_events";
   
   
   @Override
   public String getElementLabel() {
      logger.entering(_CLASS, "getElementLabel()");
      logger.exiting(_CLASS, "getElementLabel()",
            OrderShipmentEventsElementProcessor.elementLabel);
      return OrderShipmentEventsElementProcessor.elementLabel;
   }

   @Override
   public void processElement(ServiceOrder order, XMLStreamReader reader) 
   throws XMLStreamException {
      logger.entering(_CLASS, "processElement(ServiceOrder,XMLStreamReader)",
            new Object[] {order,reader});
      OrderShipmentEventsXMLFactory listFactory=null;
      List<ShipmentEvent> shipmentEvents=null;
      String msg=null;
      
      if ((order != null) && (reader != null)) {
         listFactory=new OrderShipmentEventsXMLFactory();
         shipmentEvents=listFactory.parse(reader);
         if (shipmentEvents != null) {
            order.setOrderShipmentEvents(shipmentEvents);
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