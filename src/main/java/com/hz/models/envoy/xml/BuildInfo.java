package com.hz.models.envoy.xml;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;

@AllArgsConstructor
@NoArgsConstructor
public class BuildInfo {
	@XmlElement(name="build_id")
	public String buildId;
	@XmlElement(name="build_time_gmt")
	public String BuildTime;
}
