package woodspring.springcache.entity;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class FXSpot {
	static final DecimalFormat f = new DecimalFormat("##.00000000");
	private String symbol;
	private BigDecimal price;
	private String tenor;
	private long quoteTime;
	private String pxStr;
	//private int notation;
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
		this.pxStr = f.format(price);
	}
	public String getPriceString() {
		return pxStr;
	}
	@Override
	public String toString() {
		return "FXSpot [symbol=" + symbol + ", price=" + price + ", tenor=" + tenor + ", quoteTime=" + quoteTime + "]";
	}
	public String getTenor() {
		return tenor;
	}
	public void setTenor(String tenor) {
		this.tenor = tenor;
	}
	public long getQuoteTime() {
		return quoteTime;
	}
	public void setQuoteTime(long quoteTime) {
		this.quoteTime = quoteTime;
	}


}
