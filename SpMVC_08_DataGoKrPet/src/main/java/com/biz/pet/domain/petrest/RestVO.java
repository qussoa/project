package com.biz.pet.domain.petrest;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * java 1.7이상에서만 작동된다
 * jaxb dependency(pom.xml)에 추가해주면된다
 */

@XmlRootElement(name = "rfcOpenApi")
public class RestVO {
	
	public RestBody body;
	
}
