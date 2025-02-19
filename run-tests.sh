#!/bin/sh


echo "Running tests of type: $TEST_TYPE"

if [ "$TEST_TYPE" = "UI" ]; then
    mvn test -Dtest=pl.inpost.home.task.runners.UiTestRunner -Dselenium.remote.url="$SELENIUM_REMOTE_URL" -ntp
elif [ "$TEST_TYPE" = "API" ]; then
    mvn test -Dtest=pl.inpost.home.task.runners.ApiTestRunner -Dapi.key="$API_KEY" -ntp
else
    mvn test -Dapi.key="$API_KEY" -Dselenium.remote.url="$SELENIUM_REMOTE_URL" -ntp # Runs all tests
fi
