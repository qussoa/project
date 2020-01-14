package com.biz.rbooks.repository;

import org.apache.ibatis.jdbc.SQL;

public class BookSQL {

	public String insert_sql() {

		return new SQL() {
			{
				INSERT_INTO("tbl_books");

				INTO_COLUMNS("b_code");
				INTO_COLUMNS("b_name");
				INTO_COLUMNS("b_auther");
				INTO_COLUMNS("b_comp");
				INTO_COLUMNS("b_year");
				INTO_COLUMNS("b_iprice");

				INTO_VALUES("#{b_code,jdbcType=VARCHAR}");
				INTO_VALUES("#{b_name,jdbcType=VARCHAR}");
				INTO_VALUES("#{b_auther,jdbcType=VARCHAR}");
				INTO_VALUES("#{b_comp,jdbcType=VARCHAR}");
				INTO_VALUES("#{b_year,jdbcType=VARCHAR}");
				INTO_VALUES("#{b_iprice,jdbcType=VARCHAR}");

			}
		}.toString();
	}

	public String update_sql() {
		return new SQL() {
			{
				UPDATE("tbl_books");
				WHERE("b_code = #{b_code,jdbcType=VARCHAR}");
				SET("b_name = #{b_name,jdbcType=VARCHAR}");
				SET("b_auther = #{b_auther,jdbcType=VARCHAR}");
				SET("b_comp = #{b_comp,jdbcType=VARCHAR}");
				SET("b_year = #{b_year,jdbcType=VARCHAR}");
				SET("b_iprice = #{b_iprice,jdbcType=VARCHAR}");
			}
		}.toString();

	}

	public String rbinsert_sql() {
		return new SQL() {
			{
				INSERT_INTO("tbl_read_book");

				INTO_COLUMNS("rb_seq");
				INTO_COLUMNS("rb_bcode");
				INTO_COLUMNS("rb_date");
				INTO_COLUMNS("rb_stime");
				INTO_COLUMNS("rb_rtime");
				INTO_COLUMNS("rb_subject");
				INTO_COLUMNS("rb_text");
				INTO_COLUMNS("rb_star");

				INTO_VALUES("SEQ_READ_BOOK.NEXTVAL");
				INTO_VALUES("#{rb_bcode,jdbcType=VARCHAR}");
				INTO_VALUES("#{rb_date,jdbcType=VARCHAR}");
				INTO_VALUES("#{rb_stime,jdbcType=VARCHAR}");
				INTO_VALUES("#{rb_rtime,jdbcType=VARCHAR}");
				INTO_VALUES("#{rb_subject,jdbcType=VARCHAR}");
				INTO_VALUES("#{rb_text,jdbcType=VARCHAR}");
				INTO_VALUES("#{rb_star,jdbcType=VARCHAR}");

			}
		}.toString();
	}

	public String rbupdate_sql() {
		return new SQL() {
			{

				UPDATE("tbl_read_book");
				WHERE("rb_seq= #{rb_seq,jdbcType=VARCHAR}");
				SET("rb_bcode= #{rb_bcode,jdbcType=VARCHAR}");
				SET("rb_date= #{rb_date,jdbcType=VARCHAR}");
				SET("rb_stime= #{rb_stime,jdbcType=VARCHAR}");
				SET("rb_rtime= #{rb_rtime,jdbcType=VARCHAR}");
				SET("rb_subject= #{rb_subject,jdbcType=VARCHAR}");
				SET("rb_text= #{rb_text,jdbcType=VARCHAR}");
				SET("rb_star= #{rb_star,jdbcType=VARCHAR}");
			}
		}.toString();

	}
}
