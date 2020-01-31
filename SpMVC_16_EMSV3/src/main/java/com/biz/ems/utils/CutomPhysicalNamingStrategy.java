package com.biz.ems.utils;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class CutomPhysicalNamingStrategy implements PhysicalNamingStrategy {

	@Override
	public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		// TODO Auto-generated method stub
		return convertToSnakeCase(name);
	}

	@Override
	public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		// TODO Auto-generated method stub
		return convertToSnakeCase(name);
	}

	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		// TODO Auto-generated method stub
		return convertToSnakeCase(name);
	}

	@Override
	public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		// TODO Auto-generated method stub
		return convertToSnakeCase(name);
	}

	@Override
	public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		// TODO Auto-generated method stub
		return convertToSnakeCase(name);
	}

	public Identifier convertToSnakeCase(Identifier identifier) {
		if (identifier == null) {
			return identifier;
		}
		String regex = "([a-z])([A-z])";
		String rplacement = "$1_$1";

		String newName = identifier.getText().replaceAll(regex, rplacement).toLowerCase();

		return identifier;

	}

}
