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

import java.util.ArrayList;
import java.util.List;

public class MockItem implements Item {
   private boolean countalbe=false;
   private boolean delivered=false;
   
   private int deliveredQuantity=0;
   private int quantity=0;
   private int saleSequence=0;
   private int setupTime=0;
   
   private float cube=0f;
   private float weight=0f;

   private List<ReturnCode> returnCodes=null;
   
   private String description="";
   private String itemId="";
   private String itemNotes="";
   private String location="";
   private String notes="";
   private String number="";
   private String serialNumber="";
   private String storeCode="";
   private String warehouseNotes="";
   
   /**
    * Default, no-argument constructor.
    */
   public MockItem() {
      this.returnCodes=new ArrayList<ReturnCode>();
   }
   
   //***** countable
   @Override
   public boolean isCountable() {
      return this.countalbe;
   }
   @Override
   public void setCountable(boolean countable) {
      this.countalbe=countable;
   }

   //***** cube
   @Override
   public float getCube() {
      return this.cube;
   }
   @Override
   public void setCube(float cube) {
      this.cube=cube;
   }

   //***** delivered
   @Override
   public boolean isDelivered() {
      return this.delivered;
   }
   @Override
   public void setDelivered(boolean value) {
      this.delivered=value;
   }
   
   //***** deliveredQuantity
   @Override
   public int getDeliveredQuantity() {
      return this.deliveredQuantity;
   }
   @Override
   public void setDeliveredQuantity(int quantity) {
      this.deliveredQuantity=quantity;
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

   //***** itemId
   @Override
   public String getItemId() {
      return this.itemId;
   }

   @Override
   public void setItemId(String itemId) {
      this.itemId=itemId;
   }

   //***** itemNotes
   @Override
   public String getItemNotes() {
      return this.itemNotes;
   }
   @Override
   public void setItemNotes(String notes) {
      this.itemNotes=notes;      
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
   
  //***** notes
   @Override
   public String getNotes() {
      return this.notes;
   }
   @Override
   public void setNotes(String notes) {
      this.notes=notes;      
   }

   //***** number
   public String getNumber() {
      return this.number;
   }
   public void setNumber(String number) {
      this.number=number;      
   }
   //***** quantity
   @Override
   public int getQuantity() {
      return this.quantity;
   }
   @Override
   public void setQuantity(int quantity) {
      this.quantity=quantity;
   }

 //***** returnCodes
   public boolean addReturnCode(ReturnCode code) {
      return this.returnCodes.add(code);
   }
   public void clearReturnCodes() {
      this.returnCodes.clear();
   }
   public ReturnCode getReturnCode(int index) {
      return this.returnCodes.get(index);
   }
   public List<ReturnCode> getReturnCodes() {
      return this.returnCodes;
   }
   public ReturnCode removeReturnCode(int index) {
      return this.returnCodes.get(index);
   }
   public boolean removeReturnCode(ReturnCode code) {
      return this.returnCodes.remove(code);
   }
   public ReturnCode setReturnCode(int index,ReturnCode code) {
      return this.returnCodes.set(index,code);
   }
   public void setReturnCodes(ReturnCode... codes) {
      if (codes != null) {
         clearReturnCodes();
         for (ReturnCode code: codes) {
            this.returnCodes.add(code);
         } // END for (ReturnCode code: codes)
      } // END if (codes != null)      
   }
   public void setReturnCodes(List<ReturnCode> codes) {
      if (codes != null) {
         clearReturnCodes();
         this.returnCodes.addAll(codes);         
      } // END if (codes != null)      
   }
   
   //***** saleSequence
   @Override
   public int getSaleSequence() {
      return this.saleSequence;
   }
   @Override
   public void setSaleSequence(int saleSequence) {
      this.saleSequence=saleSequence;
   }

   //***** serialNumber
   @Override
   public String getSerialNumber() {
      return this.serialNumber;
   }
   @Override
   public void setSerialNumber(String serialNumber) {
      this.serialNumber=serialNumber;
   }

   //***** setupTime
   @Override
   public int getSetupTime() {
      return this.setupTime;
   }
   @Override
   public void setSetupTime(int setupTime) {
      this.setupTime=setupTime;
   }

   //***** storeCode
   @Override
   public String getStoreCode() {
      return this.storeCode;
   }
   @Override
   public void setStoreCode(String storeCode) {
      this.storeCode=storeCode;
   }
   
   //***** warehouseNotes
   @Override
   public String getWarehouseNotes() {
      return this.warehouseNotes;
   }
   @Override
   public void setWarehouseNotes(String notes) {
      this.warehouseNotes=notes;      
   }

   //****** weight
   @Override
   public float getWeight() {
      return this.weight;
   }

   @Override
   public void setWeight(float weight) {
      this.weight=weight;
   }
}