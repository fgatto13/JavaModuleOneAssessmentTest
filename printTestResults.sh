#!/bin/bash

# Exit immediately if a command fails
set -e

cd "$PROJECT_DIR"

echo "Starting Maven test in $(pwd)..."

# Maven command
mvn clean test | awk '/\[INFO\]  T E S T S/{flag=1} flag' > test_log.txt

# Check result
if [ $? -eq 0 ]; then
  echo "Maven test completed successfully."
else
  echo "Maven test failed."
  exit 1
fi