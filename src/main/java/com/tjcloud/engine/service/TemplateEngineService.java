package com.tjcloud.engine.service;

import java.util.Map;

public interface TemplateEngineService {
	String formatString(String template, Map<String, Object> data);
}
