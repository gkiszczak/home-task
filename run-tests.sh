#!/bin/sh


echo "Running tests of type: $TEST_TYPE"

if [ "$TEST_TYPE" = "UI" ]; then
    mvn test -Dtest=pl.inpost.home.task.runners.UiTestRunner -Dselenium.remote.url="$SELENIUM_REMOTE_URL" -ntp
elif [ "$TEST_TYPE" = "API" ]; then
    mvn test -Dtest=pl.inpost.home.task.runners.ApiTestRunner -ntp
else
    mvn test  -ntp # Runs all tests
fi
