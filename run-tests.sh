#!/bin/sh


echo "Running tests of type: $TEST_TYPE"

if [ "$TEST_TYPE" = "UI" ]; then
    mvn test -Dtest=pl.inpost.home.task.runners.UiTestRunner
elif [ "$TEST_TYPE" = "API" ]; then
    mvn test -Dtest=pl.inpost.home.task.runners.ApiTestRunner
else
    mvn test  # Runs all tests
fi
