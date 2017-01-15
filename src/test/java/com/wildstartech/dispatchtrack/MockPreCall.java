package com.wildstartech.dispatchtrack;

public class MockPreCall implements PreCall {
   private String confirmationStatus="";
   private String confirmationStatusText="";
   
   public MockPreCall() {
      
   }
   
   //***** confirmationStatus
   @Override
   public String getConfirmationStatus() {
      return this.confirmationStatus;
   }
   @Override
   public void setConfirmationStatus(String status) {
      this.confirmationStatus=status;
   }
   //***** confirmationStatusText
   @Override
   public String getConfirmationStatusText() {
      return this.confirmationStatusText;
   }
   @Override
   public void setConfirmationStatusText(String statusText) {
      this.confirmationStatusText=statusText;
   }
}