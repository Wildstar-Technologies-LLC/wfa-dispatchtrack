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

import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

import com.wildstartech.dispatchtrack.Customer;

public class CustomerImpl implements Customer {
   private static String _CLASS=CustomerImpl.class.getName();
   private static Logger logger=Logger.getLogger(_CLASS);
   private float latitude=0f;
   private float longitude=0f;
   
   private String address1="";
   private String address2="";
   private String city="";
   private String customerId="";
   private String email="";
   private String firstName="";
   private String lastName="";
   private String phone1="";
   private String phone2="";
   private String state="";
   private String zip="";
   
   /**
    * Default, no-argument constructor
    */
   public CustomerImpl() {
      logger.entering(_CLASS, "CustomerImpl()");
      logger.exiting(_CLASS, "CustomerImpl()");
   }
   
   //***** address1
   @Override
   public String getAddress1() {
      logger.entering(_CLASS, "getAddress1()");
      logger.exiting(_CLASS, "getAddress1()",this.address1);
      return this.address1;
   }
   @Override
   public void setAddress1(String address) {
      logger.entering(_CLASS, "setAddress1(String)",address);
      this.address1=address;
      logger.entering(_CLASS, "setAddress1(String)");
   }

   //***** address2
   @Override
   public String getAddress2() {
      logger.entering(_CLASS, "getAddress2()");
      logger.exiting(_CLASS, "getAddress2()",this.address2);
      return this.address2;
   }

   @Override
   public void setAddress2(String address) {
      logger.entering(_CLASS, "setAddress2(String)",address);
      this.address2=address;
      logger.entering(_CLASS, "setAddress2(String)");
   }

   //***** city
   @Override
   public String getCity() {
      logger.entering(_CLASS, "getCity()");
      logger.exiting(_CLASS, "getCity()",this.city);
      return this.city;
   }
   @Override
   public void setCity(String city) {
      logger.entering(_CLASS, "setCity(String)",city);
      this.city=city;
      logger.entering(_CLASS, "setCity(String)");      
   }
   
   //***** customerId
   @Override
   public String getCustomerId() {
      logger.entering(_CLASS, "getCustomerId()");
      logger.exiting(_CLASS, "getCustomerId()",this.customerId);
      return this.customerId;
   }
   @Override
   public void setCustomerId(String customerId) {
      logger.entering(_CLASS, "setCustomerId(String)",customerId);
      this.customerId=customerId;
      logger.exiting(_CLASS, "setCustomerId(String)");      
   }

   //***** email
   @Override
   public String getEmail() {
      logger.entering(_CLASS, "getEmail()");
      logger.exiting(_CLASS, "getEmail()",this.email);
      return this.email;
   }
   @Override
   public void setEmail(String email) {
      logger.entering(_CLASS, "setEmail(String)",email);
      this.email=email;
      logger.entering(_CLASS, "setEmail(String)");
   }

   //***** firstName
   @Override
   public String getFirstName() {
      logger.entering(_CLASS, "getFirstName()");
      logger.exiting(_CLASS, "getFirstName()",this.firstName);
      return this.firstName;
   }
   @Override
   public void setFirstName(String firstName) {
      logger.entering(_CLASS, "setFirstName(String)",firstName);
      this.firstName=firstName;
      logger.exiting(_CLASS, "setFirstName(String)");
   }

   //***** lastName
   @Override
   public String getLastName() {
      logger.entering(_CLASS, "getLastName()");
      logger.exiting(_CLASS, "getLastName()",this.lastName);
      return this.lastName;
   }
   @Override
   public void setLastName(String lastName) {
      logger.entering(_CLASS, "setLastName(String)",lastName);
      this.lastName=lastName;
      logger.exiting(_CLASS, "setLastName(String)");
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
   
   //***** phone1
   @Override
   public String getPhone1() {
      logger.entering(_CLASS, "getPhone1()");
      logger.exiting(_CLASS, "getPhone1()",this.phone1);
      return this.phone1;
   }
   @Override
   public void setPhone1(String phoneNumber) {
      logger.entering(_CLASS, "setPhone1(String)",phoneNumber);
      this.phone1=phoneNumber;
      logger.exiting(_CLASS, "setPhone1(String)");
   }

   //****** phone2
   @Override
   public String getPhone2() {
      logger.entering(_CLASS, "getPhone2()");
      logger.exiting(_CLASS, "getPhone2()",this.phone2);
      return this.phone2;
   }
   @Override
   public void setPhone2(String phoneNumber) {
      logger.entering(_CLASS, "setPhone2(String)",phoneNumber);
      this.phone2=phoneNumber;
      logger.exiting(_CLASS, "setPhone2(String)");
   }
   
   //***** state
   @Override
   public String getState() {
      logger.entering(_CLASS, "getState()");
      logger.exiting(_CLASS, "getState()",this.state);
      return this.state;
   }
   @Override
   public void setState(String state) {
      logger.entering(_CLASS, "setState(String)",state);
      this.state=state;
      logger.exiting(_CLASS, "setState(String)");
   }

   //***** zip
   @Override
   public String getZip() {
      logger.entering(_CLASS, "getZip()");
      logger.exiting(_CLASS, "getZip()",this.zip);
      return this.zip;
   }
   @Override
   public void setZip(String zip) {
      logger.entering(_CLASS, "setZip(String)",zip);
      this.zip=zip;
      logger.exiting(_CLASS, "setZip(String)");
   }
   
   public Map<String,String> toPropertyMap() {
      logger.entering(_CLASS, "toPropertyMap()");
      Map<String,String> map=null;
      
      map=new TreeMap<String,String>();
      map.put("address1", getAddress1());
      map.put("address2", getAddress2());
      map.put("city", getCity());
      map.put("customerId", getCustomerId());
      map.put("email", getEmail());
      map.put("firstName", getFirstName());
      map.put("lastName", getLastName());
      map.put("latitude", Float.toString(getLatitude()));
      map.put("longitude", Float.toString(getLongitude()));
      map.put("phone1", getPhone1());
      map.put("phone2", getPhone2());
      map.put("state", getState());
      map.put("zip", getZip());
      
      logger.exiting(_CLASS, "toPropertyMap()");
      return map;
   }
   
   public String toString() {
      logger.entering(_CLASS, "toString()");
      Map<String,String> map=null;
      String value=null;
      StringBuilder sb=null;
      
      map=toPropertyMap();
      sb=new StringBuilder(1024);
      for (String key: map.keySet()) {
         value=map.get(key);
         if (sb.length() > 0) {
            sb.append(",");
         } // END if (sb.length() > 0)
         sb.append(key).append("=\"").append(value).append("\"");         
      } // END for (String key: map.keySet())
      value=sb.toString();
      
      logger.exiting(_CLASS, "toString()",value);
      return value;
   }
}