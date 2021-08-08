package com.hz;

import com.hz.configuration.EnphaseCollectorProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.export.influx.InfluxMetricsExportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.influx.InfluxDbAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.nativex.hint.*;
import org.springframework.scheduling.annotation.EnableScheduling;

// We only want InfluxDB configurations if profile set to influxdb so exclude from autoconfig
@SpringBootApplication(exclude = {InfluxMetricsExportAutoConfiguration.class, InfluxDbAutoConfiguration.class}, proxyBeanMethods = false)
@EnableConfigurationProperties(EnphaseCollectorProperties.class)
@EnableScheduling
@AotProxyHint(targetClass = com.hz.services.LocalDBService.class, proxyFeatures = ProxyBits.IS_STATIC)
@JdkProxyHint(types = {org.hibernate.query.spi.NativeQueryImplementor.class, org.hibernate.query.spi.QueryImplementor.class})
@TypeHint(types = {com.hz.models.envoy.xml.EnvoyDevice.class, com.hz.models.envoy.xml.EnvoyPackage.class, com.hz.models.envoy.xml.EnvoyPackage.class, com.hz.models.envoy.xml.BuildInfo.class})
@TypeHint(types = {com.hz.models.envoy.json.AcbType.class, com.hz.models.envoy.json.ACB.class, com.hz.models.envoy.json.TypeBase.class})
@TypeHint(
		types = {com.hz.controllers.models.BillAnswer.class, com.hz.controllers.models.BillQuestion.class, com.hz.controllers.models.BillResult.class,
				com.hz.controllers.models.DateRange.class, com.hz.controllers.models.FloatValue.class, com.hz.controllers.models.History.class, com.hz.controllers.models.IntValue.class,
				com.hz.controllers.models.PvC.class, com.hz.controllers.models.Status.class, com.hz.controllers.models.Usage.class},
		access = AccessBits.ALL)
@TypeHint(
		types = {com.hz.models.database.DailySummary.class, com.hz.models.database.Total.class},
		access = AccessBits.ALL
)
@TypeHint(
		types = {org.hibernate.query.spi.NativeQueryImplementor.class, org.hibernate.query.spi.QueryImplementor.class},
		access = AccessBits.ALL
)
@TypeHint(
		types = {org.springframework.web.servlet.resource.ResourceUrlEncodingFilter.class}, typeNames = {"org.springframework.web.servlet.resource.ResourceUrlEncodingFilter$ResourceUrlEncodingRequestWrapper"},
		access = AccessBits.PUBLIC_METHODS
)
public class EnphaseCollectorApplication {
	public static void main(String[] args) {
		SpringApplication.run(EnphaseCollectorApplication.class, args);
	}
}
