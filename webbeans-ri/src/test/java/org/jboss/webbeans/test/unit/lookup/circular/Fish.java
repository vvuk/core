package org.jboss.webbeans.test.unit.lookup.circular;

import javax.inject.Initializer;

class Fish
{
   
   private Water water;
   
   @Initializer
   public Fish(Water water)
   {
      this.water = water;
   }
   
}
