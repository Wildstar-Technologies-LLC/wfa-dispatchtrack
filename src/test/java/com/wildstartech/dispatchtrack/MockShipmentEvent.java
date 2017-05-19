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

public class MockShipmentEvent implements ShipmentEvent {
   private int timestamp=0;
   private String customerFlag=null;
   private String description=null;
   private String location=null;
   
   /**
    * Default, no-argument constructor.
    */
   public MockShipmentEvent() {
      
   }
   
   //***** customerFlag
   @Override
   public String getCustomerFlag() {
      return this.customerFlag;
   }
   @Override
   public void setCustomerFlag(String customerFlag) {
      this.customerFlag=customerFlag;
   }

   //***** description
   @Override
   public String getDescription() {
      return this.description;
   }
   @Override
   public void setDescription(String description) {
      this.description=description;
   }

   //***** location
   @Override
   public String getLocation() {
      return this.location;
   }
   @Override
   public void setLocation(String location) {
      this.location=location;
   }

   //***** timestamp
   @Override
   public int getTimestamp() {
      return this.timestamp;
   }
   @Override
   public void setTimestamp(int timestamp) {
      this.timestamp=timestamp;
   }
}