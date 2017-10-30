/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165;

import cz.muni.fi.pa165.currency.CurrencyConvertor;
import cz.muni.fi.pa165.currency.CurrencyConvertorImpl;
import java.math.BigDecimal;
import java.util.Currency;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 *
 * @author xkovari6
 */
public class MainXMLAnotation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ApplicationContext context = new AnnotationConfigApplicationContext("cz.muni.fi.pa165.currency");
           
        CurrencyConvertor obj = (CurrencyConvertor) context.getBean(CurrencyConvertorImpl.class);
        obj.convert(Currency.getInstance("EUR"), Currency.getInstance("CZK"), new BigDecimal(1));
    }
           
}
    

