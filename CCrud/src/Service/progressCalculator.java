/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

/**
 *
 * @author Hassan
 */
public class progressCalculator{
public float progressCalculator(float montant,float monatantac){
     float progress = montant-monatantac ;
     float x = 0 ;/* prog.setProgress(0.09);*/
         if (progress>1000000){
             x=(float) 0.09;
         }
         if ((progress<1000000)&&(progress>100000)){
             x=(float) 0.30;
         }
         if ((progress<100000)&&(progress>10000)){
             x=(float) 0.60;
         }
         if ((progress<10000)&&(progress>1000)){
             x=(float) 0.70;
         }
         if ((progress<1000)&&(progress>100)){
            x=(float) 0.80;
         }
         if ((progress<100)&&(progress>10)){
            x=(float) 0.90;
         }
         if (progress<10){
            x=(float) 0.95;
         }
         if (progress==0){
            x=(float) 1;
         }
         return x;
}
        
}
