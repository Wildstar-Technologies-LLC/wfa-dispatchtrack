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
package com.wildstartech.dispatchtrack.spi;

import java.util.Date;
import java.util.logging.Logger;

import com.wildstartech.dispatchtrack.HistoryEvent;

public class HistoryEventImpl implements HistoryEvent {
   private static final String _CLASS=HistoryEventImpl.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);

   private float latitude=0;
   private float longitude=0;
   private Date timestamp=null;
   private String history="";
   
   /**
    * Default, no-argument constructor
    */
   public HistoryEventImpl() {
      logger.entering(_CLASS, "HistoryEventImpl()");
      logger.exiting(_CLASS, "HistoryEventImpl()");
   }
   
   //***** history
   @Override
   public String getHistory() {
      logger.entering(_CLASS, "getHistory()");
      logger.exiting(_CLASS, "getHistory()",this.history);
      return this.history;
   }
   @Override
   public void setHistory(String history) {
      logger.entering(_CLASS, "setHistory(String)",history);
      if (history != null) {
         this.history=history;
      } else {
         this.history="";
      } // END if (history != null)
      logger.exiting(_CLASS, "setHistory(String)");
      
   }

   //***** latitude
   @Override
   public float getLatitude() {
      logger.entering(_CLASS, "getLatitude()");
      logger.exiting(_CLASS, "getLatitude()",this.latitude);
      return this.latitude;
   }
   @Override
   public void setLatitude(float latitude) {
      logger.entering(_CLASS, "setLatitude(float)",latitude);
      this.latitude=latitude;
      logger.exiting(_CLASS, "setLatitude(float)");
   }

   //***** longitude
   @Override
   public float getLongitude() {
      logger.entering(_CLASS, "getLongitude()");
      logger.exiting(_CLASS, "getLongitude()",this.longitude);
      return this.longitude;
   }
   @Override
   public void setLongitude(float longitude) {
      logger.entering(_CLASS, "setLongitude(float)",longitude);
      this.longitude=longitude;
      logger.exiting(_CLASS, "setLongitude(float)");
   }

   //***** timestamp
   @Override
   public Date getTimestamp() {
      logger.entering(_CLASS, "getTimestamp()");
      logger.exiting(_CLASS, "getTimestamp()",this.timestamp);
      return this.timestamp;
   }
   @Override
   public void setTimestamp(Date timestamp) {
      logger.entering(_CLASS, "setTimestamp(Date)",timestamp);
      this.timestamp=timestamp;
      logger.exiting(_CLASS, "setTimestamp(Date)");
   }
}