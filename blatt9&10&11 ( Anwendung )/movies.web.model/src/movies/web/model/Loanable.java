package movies.web.model;

import java.io.Serializable;
import java.util.Date;

public interface Loanable extends Serializable{

	public Date getLoanedUntil();

	public void setLoanedUntil(Date loanedUntil);

	public boolean isLoanable();

	public void setLoanable(boolean loanable);

}
