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

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public abstract class XMLFactory<T> {
   private static final String _CLASS=XMLFactory.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   
   public static final String _RESOURCE_BUNDLE=
         "com.wildstartech.dispatchtrack.spi.xml.XMLFactoryMessages";
   
   private Map<String,XMLElementProcessor<T>> elementHandlers=null;
   
   
   public XMLFactory() {
      logger.entering(_CLASS, "XMLFactory()");
      logger.exiting(_CLASS, "XMLFactory()");
   }
   
   public Map<String,XMLElementProcessor<T>> getElementHandlers() {
      logger.entering(_CLASS,"getElementHandlers()");
      Map<String,XMLElementProcessor<T>> handlers=null;
      if (this.elementHandlers == null) {
         this.elementHandlers = new TreeMap<String,XMLElementProcessor<T>>();         
      } // END if (this.elementHandlers == null)
      handlers=Collections.unmodifiableMap(this.elementHandlers);
      logger.exiting(_CLASS,"getElementHandlers()",handlers);
      return handlers;
   }
   
   public void registerXMLElementProcessor(
         XMLElementProcessor<T> elementProcessor) {
      logger.entering(_CLASS,
         "registerXMLElementProcessor(XMLElementProcessor<T>",
         elementProcessor);
      if (elementProcessor != null) {
         if (this.elementHandlers == null) {
            this.elementHandlers = 
               new TreeMap<String,XMLElementProcessor<T>>();
         } // END if (this.elementHandlers == null)
         this.elementHandlers.put(
            elementProcessor.getElementLabel(), 
            elementProcessor);
      } // END if (elementProcessor != null)
      logger.exiting(_CLASS,
         "registerXMLElementProcessor(XMLElementProcessor<T>");
   }
   
   public XMLElementProcessor<T> getElementProcessor(String elementName) {
      logger.entering(_CLASS, "getElementProcessor(String)",elementName);
      XMLElementProcessor<T> processor=null;
      if (elementName != null) {
         processor=this.elementHandlers.get(elementName);
      } // END if (elementName != null)
      logger.entering(_CLASS, "getElementProcessor(String)",processor);
      return processor;
   }
   
   public abstract T parse(XMLStreamReader reader) throws XMLStreamException;
 }