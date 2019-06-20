/*
 * This class is used to customize the static resource path. While running the Embedded server it hooks the given custom static resource path.
 * StaticResourceCustomizer.java
 */
package com.sg.employee.config;

import java.io.File;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 *
 * @author Manju Kumar Mohan
 */

@Configuration
public class StaticResourceCustomizer implements EmbeddedServletContainerCustomizer {
	private final Logger logger = LoggerFactory.getLogger(StaticResourceCustomizer.class);

	private static final String STATIC_RESOURCE_FOLDER_PARAM = "static-resource-folder";
	private final String staticResourceFolderPath;

	/**
	 * Constructor to read the dynamic static resource path.
	 * 
	 * @param staticAssetsFolderPath path to the static resources for the
	 *                               application
	 */
	public StaticResourceCustomizer(@Value("${" + STATIC_RESOURCE_FOLDER_PARAM + ":}") String staticAssetsFolderPath) {
		this.staticResourceFolderPath = staticAssetsFolderPath;
	}

	private void customizeDocumentRoot(ConfigurableEmbeddedServletContainer container) {
		if (!StringUtils.isEmpty(staticResourceFolderPath)) {
			File docRoot;
			if (staticResourceFolderPath.startsWith(File.separator)) {
				docRoot = new File(staticResourceFolderPath);
			} else {
				final String workPath = Paths.get(".").toUri().normalize().getPath();
				docRoot = new File(workPath + staticResourceFolderPath);
			}
			if (docRoot.exists() && docRoot.isDirectory()) {
				logger.info("Custom location is used for static resources, directory is : {}",
						docRoot.getAbsolutePath());
				container.setDocumentRoot(docRoot);
			} else {
				logger.error("Custom location {} doesn't exist ", docRoot.getAbsolutePath());
			}
		} else {
			logger.error("Custom location is not specified, so will fall back to the default locations");
		}
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		customizeDocumentRoot(container);
	}

}
