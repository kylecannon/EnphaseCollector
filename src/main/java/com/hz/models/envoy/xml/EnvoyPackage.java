package com.hz.models.envoy.xml;

import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;

@NoArgsConstructor
public class EnvoyPackage {

	public EnvoyPackage(String pn) {
		this.pn = pn;
	}

	@XmlElement
	public String pn;
	@XmlElement
	public String version;
	@XmlElement
	public String build;

	public EnvoyPackage(String pn) {
		this.pn = pn;
	}

}
