#!/bin/bash

set -e
HOST=jannik@5.1.89.111
PORT=2710
VERSION=$1
REMOTE_DIR=/home/jannik/homepage/
LOCAL_DIR=./build/libs/

if [[ -z ${VERSION} ]]; then
	echo "Version parameter required!";
	exit 1;
fi
FILE_NAME=homepage-${VERSION}.jar

./gradlew test check build;

if [[ $? -eq 0 ]]; then
	if ssh ${HOST} -p${PORT} [[ -f ${REMOTE_DIR}${FILE_NAME} ]]; then
		echo "The file exists on the remote server already!";
		exit 1;
	fi
	scp -P${PORT} ${LOCAL_DIR}${FILE_NAME} ${HOST}:${REMOTE_DIR}${FILE_NAME};

	ssh ${HOST} -p${PORT} ln -sf ${REMOTE_DIR}${FILE_NAME} ${REMOTE_DIR}homepage.jar;

	ssh ${HOST} -p${PORT} -t sudo systemctl restart homepage;

	echo "Deployed new version";
else
	echo error;
fi