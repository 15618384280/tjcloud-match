package com.tjcloud.engine.service;

import com.tjcloud.engine.utils.TemplateUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("templateEngineService")
public class TemplateEngineServiceImpl implements TemplateEngineService {

	@Override
	public String formatString(String template, Map<String, Object> data) {
		return TemplateUtils.formatString(template, data);
	}
}
