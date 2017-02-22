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
package com.wildstartech.dispatchtrack;

import java.util.Date;

public interface ManifestEntry {
   //***** number
   public String getNumber();
   public void setNumber(String number);
   
   
   //***** scheduledDate
   public Date getScheduledDate();
   public void setScheduledDate(Date date);
   public void setScheduledDate(String date);
   
   //***** scheduledTime
   public Date getScheduledTime();
   public void setScheduledTime(Date scheduledTime);
   
   //***** serviceOrderId
   public String getServiceOrderId();
   public void setServiceOrderId(String serviceOrderId);
   
   //***** serviceUnit
   public String getServiceUnit();
   public void setServiceUnit(String serviceUnit);

   //***** status
   public String getStatus();
   public void setStatus(String status);
   
   //***** stopNumber
   public int getStopNumber();
   public void setStopNumber(int stopNumber);
   
   //***** windowEndTime
   public Date getWindowEndTime();
   public void setWindowEndTime(Date endTime);
   public void setWindowEndTime(String endTime);
   
   //***** windowStartTime
   public Date getWindowStartTime();
   public void setWindowStartTime(Date startTime);
   public void setWindowStartTime(String startTime);
   
}
