package cz.muni.fi.pa165.currency;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import javax.inject.Inject;
import javax.inject.Named;


/**
 * This is base implementation of {@link ExchangeRateTable}.
 *
 * @author kovarik tomas
 */
public class ExchangeRateTableImpl implements ExchangeRateTable {

    @Inject @Named("ExchangeRateTable")
    public ExchangeRateTableImpl() {
       
    }

    @Override
    public BigDecimal getExchangeRate(Currency sourceCurrency, Currency targetCurrency) throws ExternalServiceFailureException 
    {
       if (sourceCurrency == null) {
            throw new IllegalArgumentException("targetCurrency is null");
        }
        if (targetCurrency == null) {
            throw new IllegalArgumentException("targetCurrency is null");
        }
       
        if(sourceCurrency.getCurrencyCode()=="EUR"&&targetCurrency.getCurrencyCode()=="CZK")
            return new BigDecimal(27);
        else {
            return null;// throw new ExternalServiceFailureException("");
        }
    }

}
