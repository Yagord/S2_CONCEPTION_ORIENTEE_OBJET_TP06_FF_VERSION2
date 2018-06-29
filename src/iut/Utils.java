/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut;

/**
 * Utilitaires
 * @author aguidet
 */
public class Utils {
  /**
     * Calcul le PGCD de deux nombres
     * @param a le premier nombre
     * @param b le deuxième nombre
     * @return le pgcd de a et b
     * @pre a>0
     * @pre b>0
     * @post pgcd>0
     */
    public static int pgcd(int a, int b)
        {
            assert a>0;
            assert b>0;
            
            if(a<b)
            {
                int temp=a;
                a=b;
                b=temp;
            }
            int r = a%b;
            while(r!=0)
            {
                a = b;
				b = r;
				r = a%b;
            }
            
            assert b>0;
            return b;
        }  
}
