package com.wildstartech.dispatchtrack;

import java.util.Date;

public class MockSignature implements Signature {
   private Date createdAt=null;
   private String callbackCode=null;
   
   /** 
    * Default, no-argument constructor
    */
   public MockSignature() {      
   }
   
   //***** callbackCode
   @Override
   public String getCallbackCode() {
      return this.callbackCode;
   }
   @Override
   public void setCallbackCode(String callbackCode) {
      this.callbackCode=callbackCode;
   }

   //***** createdAt
   @Override
   public Date getCreatedAt() {
      return this.createdAt;
   }
   @Override
   public void setCreatedAt(Date date) {
      this.createdAt=date;
   }
}