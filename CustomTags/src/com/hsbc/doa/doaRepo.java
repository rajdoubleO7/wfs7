package com.hsbc.doa;

import java.sql.SQLException;
import java.util.List;

public interface doaRepo {
	public List getCustomerList (String query) throws SQLException;
}
