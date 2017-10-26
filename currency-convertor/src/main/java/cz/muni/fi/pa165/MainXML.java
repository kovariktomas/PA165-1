/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165;

import cz.muni.fi.pa165.currency.CurrencyConvertor;
import java.math.BigDecimal;
import java.util.Currency;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *
 * @author xkovari6
 */
public class MainXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringXMLConfig.xml");
           
        CurrencyConvertor obj = (CurrencyConvertor) context.getBean("CurrencyConvertor");
        obj.convert(Currency.getInstance("EUR"), Currency.getInstance("CZK"), new BigDecimal(1));
    }
           
}
    

