package cz.muni.fi.pa165.currency;

import java.math.BigDecimal;
import java.util.Currency;
import javax.inject.Inject;
import javax.inject.Named;


/**
 * This is base implementation of {@link ExchangeRateTable}.
 *
 * @author kovarik tomas
 */
@Named
public class ExchangeRateTableImpl implements ExchangeRateTable {

 
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

        if(sourceCurrency.getCurrencyCode().equals("EUR")&&targetCurrency.getCurrencyCode().equals("CZK"))
            return new BigDecimal(27);
        else {
            return null;// throw new ExternalServiceFailureException("");
        }
    }

}
