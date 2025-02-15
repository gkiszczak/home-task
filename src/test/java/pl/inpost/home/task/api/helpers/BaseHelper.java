package pl.inpost.home.task.api.helpers;

import pl.inpost.home.task.config.Config;

public class BaseHelper {

    protected String getEndpoint(String endpoint) {
	return Config.getBaseApiUrl() + endpoint;
	}
}