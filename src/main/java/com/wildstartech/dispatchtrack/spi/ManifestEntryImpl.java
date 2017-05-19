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

import com.wildstartech.dispatchtrack.ManifestEntry;

public class ManifestEntryImpl implements ManifestEntry {
   private static final String _CLASS=ManifestEntryImpl.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   
   private int stopNumber=0;
   private Date scheduledDateTime=null;
   private Date windowEndTime=null;
   private Date windowStartTime=null;
   private String number=null;
   private String serviceOrderId=null;
   private String serviceUnit=null;
   private String status=null;
   
   /**
    * Default, no-argument constructor;
    */
   public ManifestEntryImpl() {
      logger.entering(_CLASS, "ManifestEntryImpl()");
      logger.exiting(_CLASS, "ManifestEntryImpl()");
   }
   
   //***** number
   @Override
   public String getNumber() {
      logger.entering(_CLASS, "getNumber()");
      logger.exiting(_CLASS, "getNumber()",this.number);
      return this.number;
   }

   @Override
   public void setNumber(String number) {
      logger.entering(_CLASS, "setNumber(String)",number);
      this.number=number;
      logger.exiting(_CLASS, "setNumber(String)");
   }

   @Override
   public Date getScheduledDate() {
      logger.entering(_CLASS, "getScheduledDate()");
      logger.exiting(_CLASS, "getScheduledDate()",this.scheduledDateTime);
      return this.scheduledDateTime;
   }

   @Override
   public void setScheduledDate(Date date) {
      logger.entering(_CLASS, "setScheduledDate(Date)",date);
      this.scheduledDateTime=date;
      logger.exiting(_CLASS, "setScheduledDate(Date)");
   }

   @Override
   public void setScheduledDate(String date) {
      // TODO - Need to parse XML Date 
   }

   @Override
   public Date getScheduledTime() {
      logger.entering(_CLASS, "getScheduledTime()");
      logger.exiting(_CLASS, "getScheduledTime()",this.scheduledDateTime);
      return this.scheduledDateTime;
   }

   @Override
   public void setScheduledTime(Date scheduledTime) {
      logger.entering(_CLASS, "setScheduledTime(Date)",scheduledTime);
      this.scheduledDateTime=scheduledTime;
      logger.exiting(_CLASS, "setScheduledTime(Date)");
   }

   @Override
   public String getServiceOrderId() {
      logger.entering(_CLASS, "getServiceOrderId()");
      logger.exiting(_CLASS, "getServiceOrderId()",this.serviceOrderId);
      return this.serviceOrderId;
   }

   @Override
   public void setServiceOrderId(String serviceOrderId) {
      logger.entering(_CLASS, "setServiceOrderId(String)",serviceOrderId);
      this.serviceOrderId=serviceOrderId;
      logger.exiting(_CLASS, "setServiceOrderId(String)");      
   }

   @Override
   public String getServiceUnit() {
      logger.entering(_CLASS, "getServiceUnit()");
      logger.exiting(_CLASS, "getServiceUnit()",this.serviceUnit);
      return this.serviceUnit;
   }

   @Override
   public void setServiceUnit(String serviceUnit) {
      logger.entering(_CLASS, "setServiceUnit(String)",serviceUnit);
      this.serviceUnit=serviceUnit;
      logger.exiting(_CLASS, "setServiceUnit(String)");
   }

   @Override
   public String getStatus() {
      logger.entering(_CLASS, "getStatus()");
      logger.exiting(_CLASS, "getStatus()",this.status);
      return this.status;
   }

   @Override
   public void setStatus(String status) {
      logger.entering(_CLASS, "setStatus(String)",status);
      this.status=status;
      logger.exiting(_CLASS, "setStatus(String)");
   }

   @Override
   public int getStopNumber() {
      logger.entering(_CLASS, "getStopNumber()");
      logger.exiting(_CLASS, "getStopNumber()",this.stopNumber);
      return this.stopNumber;
   }

   @Override
   public void setStopNumber(int stopNumber) {
      logger.entering(_CLASS, "setStopNumber(int)",stopNumber);
      this.stopNumber=stopNumber;
      logger.exiting(_CLASS, "setStopNumber(int)");
   }

   @Override
   public Date getWindowEndTime() {
      logger.entering(_CLASS, "getWindowEndTime()");
      logger.exiting(_CLASS, "getWindowEndTime()",this.windowEndTime);
      return this.windowEndTime;
   }

   @Override
   public void setWindowEndTime(Date endTime) {
      logger.entering(_CLASS, "setWindowEndTime(Date)",endTime);
      this.windowEndTime=endTime;
      logger.exiting(_CLASS, "setWindowEndTime(Date)");
   }

   @Override
   public void setWindowEndTime(String endTime) {
      logger.entering(_CLASS, "setWindowEndTime(String)",endTime);
      // TODO Auto-generated method stub
      logger.exiting(_CLASS, "setWindowEndTime(String)",endTime);      
   }

   @Override
   public Date getWindowStartTime() {
      logger.entering(_CLASS, "getWindowStartTime()");
      logger.exiting(_CLASS, "getWindowStartTime()",this.windowStartTime);
      return this.windowStartTime;
   }

   @Override
   public void setWindowStartTime(Date startTime) {
      logger.entering(_CLASS, "setWindowStartTime(Date)",startTime);
      this.windowStartTime=startTime;
      logger.exiting(_CLASS, "setWindowStartTime(Date)");
   }

   @Override
   public void setWindowStartTime(String startTime) {
      logger.entering(_CLASS, "setWindowStartTime(String)",startTime);
      // TODO Auto-generated method stub
      logger.exiting(_CLASS, "setWindowStartTime(String)");
   }
}