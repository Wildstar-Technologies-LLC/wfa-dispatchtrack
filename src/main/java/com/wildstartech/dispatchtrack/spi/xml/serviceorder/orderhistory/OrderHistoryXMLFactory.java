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
package com.wildstartech.dispatchtrack.spi.xml.serviceorder.orderhistory;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.wildstartech.dispatchtrack.HistoryEvent;
import com.wildstartech.dispatchtrack.Localization;
import com.wildstartech.dispatchtrack.Note;
import com.wildstartech.dispatchtrack.spi.xml.XMLFactory;
import com.wildstartech.dispatchtrack.spi.xml.XMLFactoryMessages;
import com.wildstartech.dispatchtrack.spi.xml.serviceorder.note.NoteXMLFactory;

public class OrderHistoryXMLFactory {
   private static String _CLASS=
         OrderHistoryXMLFactory.class.getName();
   private static Logger logger=Logger.getLogger(_CLASS);
   private static final String elementLabel="order_history";
   
   public List<HistoryEvent> parse(XMLStreamReader reader) 
   throws XMLStreamException {
      logger.entering(_CLASS, "parse(XMLStreamReader)",reader);
      boolean done=false;
      List<HistoryEvent> historyEvents=null;
      HistoryEvent event=null;
      HistoryXMLFactory historyFactory=null;
      String elementName=null;
      String msg=null;
      
      historyEvents=new ArrayList<HistoryEvent>();
      if (reader != null) {
         historyFactory=new HistoryXMLFactory();
         while ((reader.hasNext() && !done)) {
            switch (reader.getEventType()) {
               case XMLStreamConstants.START_ELEMENT:
                  elementName=reader.getLocalName();
                  switch(elementName) {
                     case elementLabel:
                        event=historyFactory.parse(reader);
                        if (event != null) {
                           historyEvents.add(event);                           
                        } // END if (serviceOrder != null)
                        break;
                  } // END switch(elementName)
                  break;
               case XMLStreamConstants.END_ELEMENT:
                  elementName=reader.getLocalName();
                  switch(elementName) {
                     case elementLabel:
                        done=true;
                        break;
                  } // END switch(elementName)
                  break;
            } // END switch (reader.getEventType())
            if (reader.hasNext()) {
               reader.next();
            } // END if (reader.hasNext())
         } // END while (reader.hasName())
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
      
      logger.entering(_CLASS, "parse(XMLStreamReader)",historyEvents);
      return historyEvents;
   }
}