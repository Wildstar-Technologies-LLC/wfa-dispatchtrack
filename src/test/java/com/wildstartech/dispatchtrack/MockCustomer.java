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

public class MockCustomer implements Customer {
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
   public MockCustomer() {
      
   }
   
   //***** address1
   @Override
   public String getAddress1() {
      return this.address1;
   }
   @Override
   public void setAddress1(String address1) {
      this.address1=address1;
   }

   //***** address2
   @Override
   public String getAddress2() {
      return this.address2;
   }

   @Override
   public void setAddress2(String address2) {
      this.address2=address2;
   }

   //***** city
   @Override
   public String getCity() {
      return this.city;
   }
   @Override
   public void setCity(String city) {
      this.city=city;
   }
   
   //***** customerId
   @Override
   public String getCustomerId() {
      return this.customerId;
   }
   @Override
   public void setCustomerId(String customerId) {
      this.customerId=customerId;
   }

   //***** email
   @Override
   public String getEmail() {
      return this.email;
   }
   @Override
   public void setEmail(String email) {
      this.email=email;
   }

   //***** firstName
   @Override
   public String getFirstName() {
      return this.firstName;
   }
   @Override
   public void setFirstName(String firstName) {
      this.firstName=firstName;
   }

   //***** lastName
   @Override
   public String getLastName() {
      return this.lastName;
   }
   @Override
   public void setLastName(String lastName) {
      this.lastName=lastName;
   }
   
   //***** latitude
   @Override
   public float getLatitude() {
      return this.latitude;
   }
   @Override
   public void setLatitude(float latitude) {
      this.latitude=latitude;
   }

   //***** longitude
   @Override
   public float getLongitude() {
      return this.longitude;
   }
   @Override
   public void setLongitude(float longitude) {
      this.longitude=longitude;
   }
   
   //***** phone1
   @Override
   public String getPhone1() {
      return this.phone1;
   }
   @Override
   public void setPhone1(String phoneNumber) {
      this.phone1=phoneNumber;
   }

   //****** phone2
   @Override
   public String getPhone2() {
      return this.phone2;
   }
   @Override
   public void setPhone2(String phoneNumber) {
      this.phone2=phoneNumber;
   }
  
   //***** state
   @Override
   public String getState() {
      return this.state;
   }
   @Override
   public void setState(String state) {
      this.state=state;
   }

   //***** zip
   @Override
   public String getZip() {
      return this.zip;
   }
   @Override
   public void setZip(String zip) {
      this.zip=zip;
   }
}
