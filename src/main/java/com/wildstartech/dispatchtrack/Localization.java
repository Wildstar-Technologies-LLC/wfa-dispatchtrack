/*
 * Copyright (c) 2017 Wildstar Technologies, LLC.
 */
package com.wildstartech.dispatchtrack;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility to provide localized instances of {@code FacesMessage} objects.
 * 
 * @author Derek Berube, Wildstar Technologies, LLC.
 * @version 0.1, 2016.08.28
 *
 */
public class Localization {
   private static final String _CLASS=Localization.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   
   public static String getString(String bundleName, 
         String resourceId,
         Locale locale,
         ClassLoader cl,
         Object[] params) {
      logger.entering(_CLASS, 
            "getString(String,String,String,Locale,ClassLoader,Object[])",
            new Object[] {
                  bundleName,resourceId,locale,cl,params
            });
      MessageFormat formatter=null;
      ResourceBundle bundle=null;
      String resource="";
      
      // If the locale isn't specified, then get the default locale.
      if (locale == null) {
         locale=Locale.getDefault();
      } // END if (locale == null)
      
      if (bundleName != null) {
         bundle=ResourceBundle.getBundle(bundleName,locale,cl);
         if (bundle != null) {
            try {
               resource=bundle.getString(resourceId);
            } catch (MissingResourceException ex) {
               logger.log(Level.SEVERE,
                     "Unable to locate specified resource.",
                     ex);
            } // END try/catch
         } // END if (bundle != null)
      } // END if (firstBundle != null) 
      
      if (resource != null) {
         if (params != null) {
            formatter=new MessageFormat(resource,locale);
            resource=formatter.format(params);
         } // END if (params != null)
      } else {
         logger.warning("No resource found.");
      } // END if (resource != null)
      
      logger.exiting(_CLASS, 
            "getString(String,String,String,Locale,ClassLoader,Object[])",
            resource);
      return resource;
   }
   
   /**
    * Returns a reference to a {@code ClassLoader} that can be used to
    * load resources for the application to use.
    * 
    * @return A reference to a {@code ClassLoader} that will be used 
    * to return localized message information.
    */
   public static ClassLoader getClassLoader() {
      logger.entering(_CLASS, "getClassloader()");
      ClassLoader cl=null;
      
      cl=Thread.currentThread().getContextClassLoader();
      if (cl == null) cl=Localization.class.getClassLoader();
      if (cl == null) cl=ClassLoader.getSystemClassLoader();
      
      logger.exiting(_CLASS, "getClassloader()",cl);
      return cl;
   }   
}