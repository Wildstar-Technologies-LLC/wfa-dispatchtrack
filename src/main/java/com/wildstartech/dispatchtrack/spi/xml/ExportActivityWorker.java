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

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.wildstartech.dispatchtrack.Localization;
import com.wildstartech.dispatchtrack.ServiceOrder;
import com.wildstartech.dispatchtrack.spi.xml.serviceorder.ServiceOrdersXMLFactory;

/**
 * Manages the logic required to invoke and process the results of the API call
 * to extract activity data for a particular date.
 * 
 * <table>
 * <tr>
 * <th>Response Code</th>
 * <th>Description</th>
 * </tr>
 * <tr>
 * <td>406</td>
 * <td>The <code>date</code> parameter was not specified as part of the web
 * request.</td>
 * </tr>
 * </table>
 * 
 * @author Derek Berube, Wildstar Technologies, LLC.
 * @version 0.1
 */
public abstract class ExportActivityWorker {
   private static final String _CLASS = ExportActivityWorker.class.getName();
   private static final Logger logger = Logger.getLogger(_CLASS);
   private static final String DATE_FORMAT = "yyyy-MM-dd";

   private Date activityDate;

   /**
    * Default, no-argument constructor.
    */
   public ExportActivityWorker() {
      super();
      logger.entering(_CLASS, "ExportActivityWorker()");
      logger.exiting(_CLASS, "ExportActivityWorker()");
   }

   public List<ServiceOrder> parse(InputStream in) {
      logger.entering(_CLASS, "parse(InputStream)", in);
      List<ServiceOrder> serviceOrders = null;
      ServiceOrdersXMLFactory listFactory = null;
      String msg = null;
      XMLInputFactory xmlFactory = null;
      XMLStreamReader reader = null;
      try {
         if (in != null) {
            xmlFactory = XMLInputFactory.newInstance();
            reader = xmlFactory.createXMLStreamReader(in);
            listFactory = new ServiceOrdersXMLFactory();
            while (reader.hasNext()) {
               serviceOrders = listFactory.parse(reader);
            } // END while(reader.hasNext())
            reader.close();
         } // END if (in != null)
      } catch (XMLStreamException ex) {
         msg = Localization.getString(
                  WebExportActivityWorker._RESOURCE_BUNDLE,
                  WebExportActivityWorkerMessages.ERR_XML_STREAM, 
                  null, 
                  null, 
                  null);
         logger.log(Level.SEVERE, msg, ex);
      } // END try/catch
      logger.exiting(_CLASS, "parse(InputStream)", serviceOrders);
      return serviceOrders;
   }

   /**
    * Constructor taking the desired activity date as an initializing parameter.
    * 
    * @param date
    *           The date for which activity should be returned.
    */
   public ExportActivityWorker(Date date) {
      super();
      logger.entering(_CLASS, "ExportActivityWorker(Date)", date);
      setActivityDate(date);
      logger.entering(_CLASS, "ExportActivityWorker(Date)");
   }

   /* ***** Accessor Methods *****/
   public Date getActivityDate() {
      logger.entering(_CLASS, "getActivityDate()");
      logger.exiting(_CLASS, "getActivityDate()", this.activityDate);
      return this.activityDate;
   }

   public void setActivityDate(Date activityDate) {
      logger.entering(_CLASS, "setActivityDate(Date)", activityDate);
      this.activityDate = activityDate;
      logger.exiting(_CLASS, "setActivityDate(Date)");
   }

   /* ***** Utility Methods *****/
   // ********** dateForamt
   public DateFormat getDateFormat() {
      logger.entering(_CLASS, "getDateFormat()");
      DateFormat dFmt = null;

      dFmt = new SimpleDateFormat(DATE_FORMAT);

      logger.exiting(_CLASS, "getDateFormat()", dFmt);
      return dFmt;
   }

   public Map<String, String> getParameterMap() {
      logger.entering(_CLASS, "getParameterMap()");
      Date activityDate = null;
      DateFormat dfmt = null;
      Map<String, String> map = null;

      map = new TreeMap<String, String>();
      dfmt = getDateFormat();
      activityDate = getActivityDate();
      if (activityDate != null) {
         map.put("date", dfmt.format(activityDate));
      } // END if (activityDate != null)

      logger.exiting(_CLASS, "getParameterMap()", map);
      return map;
   }
}