package org.mybatis.generator.config;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;
import static org.mybatis.generator.internal.util.messages.Messages.getString;

import java.util.List;

import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.XmlElement;

public class JavaServiceGeneratorConfiguration extends PropertyHolder {

	private String targetPackage;

	private String targetProject;

	public JavaServiceGeneratorConfiguration() {
		super();
	}

	public String getTargetPackage() {
		return targetPackage;
	}

	public void setTargetPackage(String targetPackage) {
		this.targetPackage = targetPackage;
	}

	public String getTargetProject() {
		return targetProject;
	}

	public void setTargetProject(String targetProject) {
		this.targetProject = targetProject;
	}

	public XmlElement toXmlElement() {
		XmlElement answer = new XmlElement("javaServiceGenerator");

		if (targetPackage != null) {
			answer.addAttribute(new Attribute("targetPackage", targetPackage));
		}
		if (null != targetProject)
			answer.addAttribute(new Attribute("targetProject", targetProject));

		addPropertyXmlElements(answer);
		return answer;
	}

	public void validate(List<String> errors, String contextId) {
		if (!stringHasValue(targetProject)) {
			errors.add(getString("ValidationError.40", contextId)); //$NON-NLS-1$
		}

		if (!stringHasValue(targetPackage)) {
			errors.add(getString("ValidationError.41", //$NON-NLS-1$
					"javaServiceGenerator", contextId)); //$NON-NLS-1$
		}
	}

}
