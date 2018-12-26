package net.skhu.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import lombok.Data;

@Data
public class Pagination {
	int pg = 1;
	int sz = 15;
	int sb;
	String st;
	int ob;
	int recordCount;

	public String getQueryString() {
		String url = null;
		try {
			String temp = (st == null) ? "" : URLEncoder.encode(st, "UTF-8");
			url = String.format("pg=%d&sz=%d&ob=%d&sb=%d&st=%s", pg, sz, ob, sb, temp);
		} catch (UnsupportedEncodingException e) {
		}
		return url;
	}
}
