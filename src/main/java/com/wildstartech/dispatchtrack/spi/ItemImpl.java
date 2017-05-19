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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import com.wildstartech.dispatchtrack.Item;
import com.wildstartech.dispatchtrack.ReturnCode;

public class ItemImpl implements Item {
   private static final String _CLASS=ItemImpl.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   
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
   public ItemImpl() {
      logger.entering(_CLASS, "ItemImpl()");
      this.returnCodes=new ArrayList<ReturnCode>();
      logger.exiting(_CLASS, "ItemImpl()");
   }
   
   //***** countable
   @Override
   public boolean isCountable() {
      logger.entering(_CLASS, "isCountable()");
      logger.exiting(_CLASS, "isCountable()",this.countalbe);
      return this.countalbe;
   }
   @Override
   public void setCountable(boolean countable) {
      logger.entering(_CLASS, "setCountable(boolean)",countable);
      this.countalbe=countable;
      logger.exiting(_CLASS, "setCountable(boolean)");
   }

   //***** cube
   @Override
   public float getCube() {
      logger.entering(_CLASS, "getCube()");
      logger.exiting(_CLASS, "getCube()",this.cube);
      return this.cube;
   }
   @Override
   public void setCube(float cube) {
      logger.entering(_CLASS, "setCube(float)",cube);
      this.cube=cube;
      logger.exiting(_CLASS, "setCube(float)");
   }

   //***** delivered
   @Override
   public boolean isDelivered() {
      logger.entering(_CLASS, "isDelivered()");
      logger.exiting(_CLASS, "isDelivered()",this.delivered);
      return this.delivered;
   }
   @Override
   public void setDelivered(boolean value) {
      logger.entering(_CLASS, "setDelivered(boolean)",value);
      this.delivered=value;
      logger.entering(_CLASS, "setDelivered(boolean)");
   }
   
   //***** deliveredQuantity
   @Override
   public int getDeliveredQuantity() {
      logger.entering(_CLASS, "getDeliveredQuantity()");
      logger.exiting(_CLASS, "getDeliveredQuantity()",this.deliveredQuantity);
      return this.deliveredQuantity;
   }
   @Override
   public void setDeliveredQuantity(int quantity) {
      logger.entering(_CLASS, "setDeliveredQuantity(int)",quantity);
      this.deliveredQuantity=quantity;
      logger.entering(_CLASS, "setDeliveredQuantity(int)");
   }
   //***** description
   @Override
   public String getDescription() {
      logger.entering(_CLASS, "getDescription()");
      logger.exiting(_CLASS, "getDescription()",this.description);
      return this.description;
   }
   @Override
   public void setDescription(String description) {
      logger.entering(_CLASS, "setDescription(String)",description);
      this.description=description;
      logger.exiting(_CLASS, "setDescription(String)");
   }

   //***** itemId
   @Override
   public String getItemId() {
      logger.entering(_CLASS, "getItemId()");
      logger.exiting(_CLASS, "getItemId()",this.itemId);
      return this.itemId;
   }

   @Override
   public void setItemId(String itemId) {
      logger.entering(_CLASS, "setItemId(String)",itemId);
      this.itemId=itemId;
      logger.exiting(_CLASS, "setItemId(String)");
   }
   
   //***** itemNotes
   @Override
   public String getItemNotes() {
      logger.entering(_CLASS, "getItemNotes()");
      logger.exiting(_CLASS, "getItemNotes()",this.itemNotes);
      return this.itemNotes;
   }
   public void setItemNotes(String itemNotes) {
      logger.entering(_CLASS, "setItemNotes(String)",itemNotes);
      this.itemNotes=itemNotes;
      logger.exiting(_CLASS, "setItemNotes(String)");
   }

   //***** location
   @Override
   public String getLocation() {
      logger.entering(_CLASS, "getLocation()");
      logger.exiting(_CLASS, "getLocation()",this.location);
      return this.location;
   }
   @Override
   public void setLocation(String location) {
      logger.entering(_CLASS, "setLocation(String)",location);
      this.location=location;
      logger.exiting(_CLASS, "setLocation(String)");
   }
   
   //***** notes
   @Override
   public String getNotes() {
      logger.entering(_CLASS, "getNotes()");
      logger.exiting(_CLASS, "getNotes()",this.notes);
      return this.notes;
   }
   @Override
   public void setNotes(String notes) {
      logger.entering(_CLASS, "setNotes(String)",notes);
      this.notes=notes;
      logger.exiting(_CLASS, "setNotes(String)");
   }
   
   //***** number
   public String getNumber() {
      logger.entering(_CLASS, "getNumber()");
      logger.exiting(_CLASS, "getNumber()",this.number);
      return this.number;
   }
   public void setNumber(String number) {
      logger.entering(_CLASS, "setNumber(String)",number);
      this.number=number;
      logger.exiting(_CLASS, "setNumber(String)");
   }

   //***** quantity
   @Override
   public int getQuantity() {
      logger.entering(_CLASS, "getQuantity()");
      logger.exiting(_CLASS, "getQuantity()",this.quantity);
      return this.quantity;
   }
   @Override
   public void setQuantity(int quantity) {
      logger.entering(_CLASS, "setQuantity(int)",quantity);
      this.quantity=quantity;
      logger.exiting(_CLASS, "setQuantity(int)");
   }
   
   //***** returnCodes
   public boolean addReturnCode(ReturnCode code) {
      logger.entering(_CLASS, "addReturnCode(ReturnCode)",code);
      boolean result=false;
      this.returnCodes.add(code);
      logger.exiting(_CLASS, "addReturnCode(ReturnCode)",result);
      return result;
   }
   public void clearReturnCodes() {
      logger.entering(_CLASS, "clearReturnCodes()");
      this.returnCodes.clear();
      logger.exiting(_CLASS, "clearReturnCodes()");
   }
   public ReturnCode getReturnCode(int index) {
      logger.entering(_CLASS, "getReturnCode(int)",index);
      ReturnCode returnCode=null;
      returnCode=this.returnCodes.get(index);
      logger.exiting(_CLASS, "getReturnCode(int)",returnCode);
      return returnCode;
   }
   public List<ReturnCode> getReturnCodes() {
      logger.entering(_CLASS, "getReturnCodes()");
      List<ReturnCode> codes=null;
      codes=Collections.unmodifiableList(this.returnCodes);
      logger.exiting(_CLASS, "getReturnCodes()",codes);
      return codes;
   }
   public ReturnCode removeReturnCode(int index) {
      logger.entering(_CLASS, "removeCode(int)",index);
      ReturnCode code=null;
      code=this.returnCodes.get(index);
      logger.exiting(_CLASS, "removeCode(int)",code);
      return code;
   }
   public boolean removeReturnCode(ReturnCode code) {
      logger.entering(_CLASS, "removeReturnCode(ReturnCode)",code);
      boolean result=false;
      result=this.returnCodes.remove(code);
      logger.exiting(_CLASS, "removeReturnCode(ReturnCode)",result);
      return result;
   }
   public ReturnCode setReturnCode(int index,ReturnCode code) {
      logger.entering(_CLASS, "setReturnCode(int,ReturnCode)",
         new Object[]{index,code});
      ReturnCode returnCode=null;
      returnCode=this.returnCodes.set(index,code);
      logger.entering(_CLASS, "setReturnCode(int,ReturnCode)",returnCode);
      return returnCode;
   }
   public void setReturnCodes(ReturnCode... codes) {
      logger.entering(_CLASS, "setReturnCodes(ReturnCode...)",codes);
      if (codes != null) {
         clearReturnCodes();
         for (ReturnCode code: codes) {
            this.returnCodes.add(code);
         } // END for (ReturnCode code: codes)
      } // END if (codes != null)
      logger.exiting(_CLASS, "setReturnCodes(ReturnCode...)");
   }
   public void setReturnCodes(List<ReturnCode> codes) {
      logger.entering(_CLASS, "setReturnCodes(List<ReturnCode>)",codes);
      if (codes != null) {
         clearReturnCodes();
         this.returnCodes.addAll(codes);         
      } // END if (codes != null)
      logger.exiting(_CLASS, "setReturnCodes(List<ReturnCode>)");
   }

   //***** saleSequence
   @Override
   public int getSaleSequence() {
      logger.entering(_CLASS, "getSalesSequence()");
      logger.exiting(_CLASS, "getSalesSequence()",this.saleSequence);
      return this.saleSequence;
   }
   @Override
   public void setSaleSequence(int saleSequence) {
      logger.entering(_CLASS, "setSaleSequence(String)",saleSequence);
      this.saleSequence=saleSequence;
      logger.exiting(_CLASS, "setSaleSequende(String)");
   }

   //***** serialNumber
   @Override
   public String getSerialNumber() {
      logger.entering(_CLASS, "getSerialNumber()");
      logger.exiting(_CLASS, "getSerialNumber()",this.serialNumber);
      return this.serialNumber;
   }
   @Override
   public void setSerialNumber(String serialNumber) {
      logger.entering(_CLASS, "setSerialNumber(String)",serialNumber);
      this.serialNumber=serialNumber;
      logger.exiting(_CLASS, "setSerialNumber(String)");
   }

   //***** setupTime
   @Override
   public int getSetupTime() {
      logger.entering(_CLASS, "getSetupTime()");
      logger.exiting(_CLASS, "getSetupTime()",this.setupTime);
      return this.setupTime;
   }
   @Override
   public void setSetupTime(int setupTime) {
      logger.entering(_CLASS, "setSetupTime(int)",setupTime);
      this.setupTime=setupTime;
      logger.exiting(_CLASS, "setSetupTime(int)");
   }

   //***** storeCode
   @Override
   public String getStoreCode() {
      logger.entering(_CLASS, "getStoreCode()");
      logger.exiting(_CLASS, "getStoreCode()",this.storeCode);
      return this.storeCode;
   }
   @Override
   public void setStoreCode(String storeCode) {
      logger.entering(_CLASS, "setStoreCode(String)",storeCode);
      this.storeCode=storeCode;
      logger.exiting(_CLASS, "setStoreCode(String)");
   }
   
   //***** warehouseNotes
   @Override
   public String getWarehouseNotes() {
      logger.entering(_CLASS, "getWarehouseNotes()");
      logger.exiting(_CLASS, "getWarehouseNotes()",this.warehouseNotes);
      return this.warehouseNotes;
   }
   public void setWarehouseNotes(String notes) {
      logger.entering(_CLASS, "setWarehouseNotes(String)",notes);
      this.warehouseNotes=notes;
      logger.exiting(_CLASS, "setWarehouseNotes(String)");
   }

   //****** weight
   @Override
   public float getWeight() {
      logger.entering(_CLASS, "getWeight()");
      logger.exiting(_CLASS, "getWeight()",this.weight);
      return this.weight;
   }

   @Override
   public void setWeight(float weight) {
      logger.entering(_CLASS, "setWeight(int)",weight);
      this.weight=weight;
      logger.exiting(_CLASS, "setWeight(int)");
   }
}